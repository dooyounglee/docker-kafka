package org.example.kafka;

import lombok.RequiredArgsConstructor;
import org.example.service.TwoService01;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TwoConsumer01 {

    private final TwoService01 twoService01;

    @KafkaListener(topics = "two-fail", groupId = "group-01")
    public void one() {
        twoService01.twoFail();
    }
}
