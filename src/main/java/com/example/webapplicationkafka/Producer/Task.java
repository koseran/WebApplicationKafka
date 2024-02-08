package com.example.webapplicationkafka.Producer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class Task extends JsonSerializer {
    private String taskId;
    private String studentId;
    private String subject;
    private String dateOfSubmission;

    public Task(String taskId, String studentId, String subject, String dateOfSubmission) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.subject = subject;
        this.dateOfSubmission = dateOfSubmission;
    }

// Constructors, getters, setters, and other methods as needed

    @Override
    public byte[] serialize(String topic, Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing Task to JSON: " + e.getMessage(), e);
        }
    }
}
