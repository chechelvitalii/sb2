package com.sb2.controller;

import com.sb2.hystrix.QueryParams;
import com.sb2.hystrix.command.SafeCall;
import com.sb2.hystrix.service.DummyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController {
    @Autowired
    private DummyService dummyService;

    @RequestMapping("safePoint")
    public String safePoint(QueryParams params) {
        return new SafeCall(dummyService, params).execute();
    }

    @RequestMapping("unSafePoint")
    public String unSafePoint(QueryParams params) {
        return dummyService.doService(params);
    }


}
