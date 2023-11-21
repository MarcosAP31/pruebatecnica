package com.pruebatecnica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    public void almacenarEventoEnS3(String eventId, String eventType, String eventData) {
        String jsonContent = String.format("{\"eventId\":\"%s\",\"eventType\":\"%s\",\"eventData\":\"%s\"}", eventId, eventType, eventData);

        byte[] jsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonBytes);

        String bucketName = "tu_bucket_name"; // Reemplaza con el nombre de tu bucket
        String key = "eventos/" + eventId + ".json";

        s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType("application/json")
                .contentLength((long) jsonBytes.length)
                .build(), inputStream);

        // Cierra el InputStream
        inputStream.close();
    }
}
