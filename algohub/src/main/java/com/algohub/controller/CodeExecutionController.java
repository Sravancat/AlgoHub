package com.algohub.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@RestController
@RequestMapping("/api/code")
@CrossOrigin(origins = "http://localhost:3000/problems")
public class CodeExecutionController {

    @Value("${jdoodle.clientId}")
    private String clientId;

    @Value("${jdoodle.clientSecret}")
    private String clientSecret;

    @PostMapping("/run")
    public ResponseEntity<?> runCode(@RequestBody Map<String, String> payload) {
        String script = payload.get("script");
        String language = payload.get("language");
        String versionIndex = payload.get("versionIndex");

        String url = "https://api.jdoodle.com/v1/execute";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
            "clientId", clientId,
            "clientSecret", clientSecret,
            "script", script,
            "language", language,
            "versionIndex", versionIndex
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("JDoodle Error: " + e.getMessage());
        }
    }
}

