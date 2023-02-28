package org.example.kafka;

import lombok.RequiredArgsConstructor;
import org.example.service.OneService01;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class oneConsumer {

    private final OneService01 oneService01;

    @KafkaListener(topics = "one-fail", groupId = "group-01")
    public void one() {
        oneService01.oneFail();
    }
}
