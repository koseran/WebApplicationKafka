package com.example.webapplicationkafka.Producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class TaskEventProducer {
    private final KafkaTemplate<String, Task> kafkaTemplate;

    @Autowired
    public TaskEventProducer(KafkaTemplate<String, Task> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceTasks() {
        String[] subjects = {"Math", "History", "Science", "English"};
        for (int i = 0; i < 20; i++) {
            Task task = new Task(
                    "Task" + (i + 1),
                    "Student" + (i + 1),
                    subjects[i % subjects.length],
                    "2024-01-27"
            );
            kafkaTemplate.send("task.events", task);
        }
    }
}
