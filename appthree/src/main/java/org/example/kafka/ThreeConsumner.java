package org.example.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.ThreeService01;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class ThreeConsumner {

    private final ThreeService01 threeService01;

    @KafkaListener(topics = "three-fail", groupId = "group-01")
    public void three() {
        threeService01.threeFail();
    }
}
