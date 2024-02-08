package com.example.webapplicationkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.util.List;

@SpringBootApplication
@EnableWebSocket
public class WebApplicationKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationKafkaApplication.class, args);
    }
}
