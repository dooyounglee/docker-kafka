package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OneController {

    private final KafkaTemplate kafkaTemplate;

    @GetMapping(value = "oneStart")
    public void start() {
        System.out.println("org.example.controller.start");

        double random = Math.random();
        System.out.println("org.example.controller.start.random: " + random);
        if (random > 0.5) {
            oneSucc();
        } else {
            kafkaTemplate.send("one-fail", 1L);
        }
    }

    private void oneSucc() {
        System.out.println("org.example.controller.oneSucc");

        double random = Math.random();
        System.out.println("org.example.controller.start.random: " + random);
        if (random > 0.5) {
            twoSucc();
        } else {
            kafkaTemplate.send("two-fail", 2L);
        }
    }

    private void twoSucc() {
        System.out.println("org.example.controller.twoSucc");

        double random = Math.random();
        System.out.println("org.example.controller.start.random: " + random);
        if (random > 0.5) {
            threeSucc();
        } else {
            kafkaTemplate.send("three-fail", 3L);
        }
    }

    private void threeSucc() {
        System.out.println("org.example.controller.threeSucc");

        double random = Math.random();
        System.out.println("org.example.controller.start.random: " + random);
        if (random > 0.5) {
            System.out.println("finally Succ");
        } else {
            kafkaTemplate.send("final-fail", 99L);
        }
    }
}
