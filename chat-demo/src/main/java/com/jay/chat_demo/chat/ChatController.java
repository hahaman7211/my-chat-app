package com.jay.chat_demo.chat;

import com.jay.chat_demo.modules.ChatMessage;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.message")
    @SendTo("topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {

        return message;
    }

    @MessageMapping("/chat.adduser")
    @SendTo("topic/public")
    public ChatMessage addUser(@Payload ChatMessage message,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());

        return message;
    }
}
