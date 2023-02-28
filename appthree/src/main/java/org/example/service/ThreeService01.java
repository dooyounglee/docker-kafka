package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreeService01 {

    public void threeFail() {
        log.debug("org.example.service.ThreeService01.threeFail");
    }
}
