package com.algohub.controller;


//src/main/java/com/algohub/controller/SignalingController.java
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.algohub.model.*;

@Controller
public class SignalingController {

 private final SimpMessagingTemplate messagingTemplate;

 public SignalingController(SimpMessagingTemplate messagingTemplate) {
     this.messagingTemplate = messagingTemplate;
 }

 // Handle incoming offer
 @MessageMapping("/offer")
 public void handleOffer(@Payload Offer offer) {
     messagingTemplate.convertAndSend("/topic/offer", offer); // Broadcasting to all clients
 }

 // Handle incoming answer
 @MessageMapping("/answer")
 public void handleAnswer(@Payload Answer answer) {
     messagingTemplate.convertAndSend("/topic/answer", answer);
 }

 // Handle incoming ICE candidate
 @MessageMapping("/ice")
 public void handleIce(@Payload IceCandidate iceCandidate) {
     messagingTemplate.convertAndSend("/topic/ice", iceCandidate);
 }
}
