package com.jay.chat_demo.chat;

import com.jay.chat_demo.modules.Greeting;
import com.jay.chat_demo.modules.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(@Payload HelloMessage message) throws InterruptedException {

        //Thread.sleep(1000);
        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()) + " !");
    }
}
