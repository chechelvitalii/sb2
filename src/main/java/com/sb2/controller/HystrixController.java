package com.sb2.controller;

import com.sb2.service.ExternalService;
import com.sb2.service.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController {
    @Autowired
    private ExternalService externalService;

    @RequestMapping("safePoint")
    public void safePoint(QueryParams params) {
        System.out.println(params);
    }

    @RequestMapping("unSafePoint")
    public void unSafePoint() {

    }
}
