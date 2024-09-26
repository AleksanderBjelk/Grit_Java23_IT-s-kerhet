package com.example.demo;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DDosAttackController {
    private final Bucket bucket;

    public DDosAttackController(Bucket bucket) {
        this.bucket = bucket;
    }

    @GetMapping("/attack")
    public ResponseEntity<String> sayHello() {
        long availableTokens = bucket.getAvailableTokens();{
            System.out.println("Available tokens: " + bucket.getAvailableTokens());
            ConsumptionProbe consumptionProbe = bucket.tryConsumeAndReturnRemaining(1);

            if (consumptionProbe.isConsumed()) {
                return ResponseEntity.ok("Hello");
            } else {
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("To many request");
            }
        }
    }
}
