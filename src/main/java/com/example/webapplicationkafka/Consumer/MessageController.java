package com.example.webapplicationkafka.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String getMessages(Model model) {
        // Retrieve messages from some service or storage
        String message = "Hello from Kafka!";
        model.addAttribute("message", message);
        return "messages"; // This should match the name of your HTML page
    }
}
