package com.jay.chat_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //send back message to the client on destinations prefixed with /topic
        registry.enableSimpleBroker("/topic");

        //add a '/app' prefix to the MessageMapping
        registry.setApplicationDestinationPrefixes("/app");

    }

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //registry.addEndpoint("/gs-guide-websocket");
        registry.addEndpoint("/ws").withSockJS();
    }


}
