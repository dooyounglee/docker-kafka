package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TwoService01 {

    public void twoFail() {
        log.debug("org.example.service.TwoService01.twoFail");
    }
}
