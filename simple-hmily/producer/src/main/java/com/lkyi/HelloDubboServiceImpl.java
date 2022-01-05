package com.lkyi;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService
public class HelloDubboServiceImpl implements HelloDubboService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public String hello(String msg) throws InterruptedException {
//        Thread.sleep(5000);
        logger.info("Accept msg: " + msg);
        return "Producer Accept msg " + msg;
    }

    public String confirm(String msg) {
        logger.info("confirm");
        return "confirm";
    }

    public String cancel(String msg) {
        logger.info("cancel");
        return "cancel";
    }
}
