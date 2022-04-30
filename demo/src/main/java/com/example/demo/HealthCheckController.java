package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("health")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(new StatusDto());
    }

    private static class StatusDto {

        public String getStatus() {
            return "OK";
        }
    }
}
