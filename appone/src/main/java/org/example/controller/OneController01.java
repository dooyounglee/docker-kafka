package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OneController01 {

    private final RestTemplate restTemplate = new RestTemplate();

    private final KafkaTemplate kafkaTemplate;

    @GetMapping(value = "one01")
    public void one() {
        log.debug("one org.example.controller.one");

        double random = Math.random();
        log.debug("one org.example.controller.one.random: {}", random);
        if (random > 0.5) {
            String query = "?a=1&b=2";
            Object result = restTemplate.getForObject("http://two:8080/two01" + query, Object.class);
            log.debug("org.example.controller.one.result: {}", result);
        } else {
            kafkaTemplate.send("one-fail", 1L);
        }
    }
}
