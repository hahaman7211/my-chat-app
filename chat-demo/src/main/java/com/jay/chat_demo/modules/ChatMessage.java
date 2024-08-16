package com.jay.chat_demo.modules;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String text;
    private String sender;
    private MessageType type;
}
