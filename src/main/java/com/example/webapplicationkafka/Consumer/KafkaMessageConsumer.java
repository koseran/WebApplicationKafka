package com.example.webapplicationkafka.Consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "task.events")
    public void listen(ConsumerRecord<String, String> record) {
        // Process the Kafka message
        String message = record.value();
        System.out.println("Received message: " + message);

        // Send the message to the WebSocket topic
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
