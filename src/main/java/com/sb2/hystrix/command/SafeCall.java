package com.sb2.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.sb2.hystrix.QueryParams;
import com.sb2.hystrix.service.DummyService;

public class SafeCall extends HystrixCommand<String> {
    private static final int requestTimeOut = 2000;

    private DummyService dummyService;
    private QueryParams queryParams;

    public SafeCall(DummyService dummyService, QueryParams queryParams) {
        super(HystrixCommandGroupKey.Factory.asKey("FirstCommandGroup"), requestTimeOut);
        this.dummyService = dummyService;
        this.queryParams = queryParams;
    }

    @Override
    protected String run() throws Exception {
        return dummyService.doService(queryParams);
    }

    @Override
    protected String getFallback() {
        return "Yohoho FALL_BACK in progress";
    }
}
