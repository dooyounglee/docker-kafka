package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TwoController01 {

    private final RestTemplate restTemplate = new RestTemplate();

    private final KafkaTemplate kafkaTemplate;

    @GetMapping(value = "two01")
    public double two(@RequestParam(name = "a") int a,
                      @RequestParam(name = "b") int b) {
        log.debug("two org.example.controller.two.a: {}", a);
        log.debug("two org.example.controller.two.b: {}", b);

        double random = Math.random();
        log.debug("two org.example.controller.two.random: {}", random);
        if (random > 0.5) {
            Map<String, Object> param = new HashMap<>();
            param.put("aa", 3);
            param.put("bb", 4);
            Object result = restTemplate.postForObject("http://three:8080/three01", param, Object.class);
            log.debug("org.example.controller.two.result: {}", result);
        } else {
            kafkaTemplate.send("two-fail", 1L);
        }
        return random;
    }
}
