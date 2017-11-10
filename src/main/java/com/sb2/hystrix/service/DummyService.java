package com.sb2.hystrix.service;

import com.sb2.hystrix.QueryParams;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DummyService {
    public String doService(QueryParams params) {
        try {
            Thread.sleep(params.getDuration());
        } catch (InterruptedException e) {
            log.error("Oppsss", e);
        }
        return "OK with duration: " + params.getDuration();
    }
}
