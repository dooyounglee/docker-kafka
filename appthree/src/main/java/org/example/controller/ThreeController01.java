package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ThreeController01 {

    private final RestTemplate restTemplate = new RestTemplate();

    private final KafkaTemplate kafkaTemplate;

    @PostMapping(value = "three01")
    public double three(@RequestBody Map param) {
        log.debug("three org.example.controller.three.param: {}", param);

        double random = Math.random();
        log.debug("three org.example.controller.three.random: {}", random);
        if (random > 0.5) {
            log.debug("org.example.controller.three success");
        } else {
            kafkaTemplate.send("three-fail", 1L);
        }
        return random;
    }
}
