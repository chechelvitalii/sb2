package com.sb2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ThreadLocalController {
    ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    @RequestMapping("threadLocal")
    public int getValue(@RequestParam int part) throws InterruptedException {
        integerThreadLocal.set(part);
        Thread.sleep(10000);
        return getDif();
    }

    private int getDif() {
        int year = LocalDateTime.now().getYear();
        return year - integerThreadLocal.get();
    }
}
