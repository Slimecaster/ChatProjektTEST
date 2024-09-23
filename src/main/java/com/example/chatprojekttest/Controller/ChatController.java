package com.example.chatprojekttest.Controller;

import com.example.chatprojekttest.Model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    // Serve the chat page
    @GetMapping("/chat")
    public String chat() {
        return "chat"; // Make sure chat.html is in the right location
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        return new Message(HtmlUtils.htmlEscape(message.getMessage()));
    }

}
