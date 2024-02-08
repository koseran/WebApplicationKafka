package com.example.webapplicationkafka.Producer;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTaskController {
    private final TaskEventProducer kafkaProducer;

    public KafkaTaskController(TaskEventProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/producer")
    public String publishTask() {
        kafkaProducer.produceTasks();
        return "Task Published Successfully!";
    }
}
