package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TwoController01 {

    private final RestTemplate restTemplate = new RestTemplate();

    private final KafkaTemplate kafkaTemplate;

    @GetMapping(value = "two01")
    public double two() {
        log.debug("two org.example.controller.two");

        double random = Math.random();
        log.debug("two org.example.controller.two.random: {}", random);
        if (random > 0.5) {
            Object result = restTemplate.getForObject("http://three:8080/three01", Object.class);
            log.debug("org.example.controller.two.result: {}", result);
        } else {
            kafkaTemplate.send("two-fail", 1L);
        }
        return random;
    }
}
