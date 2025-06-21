package com.algohub.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.util.Map;

@Controller
public class CodeSyncController {

    @MessageMapping("/code-sync")
    @SendTo("/topic/code/ROOM123")
    public Map<String, Object> syncCode(Map<String, Object> payload) {
        return payload; // forwards to all subscribers
    }
}
