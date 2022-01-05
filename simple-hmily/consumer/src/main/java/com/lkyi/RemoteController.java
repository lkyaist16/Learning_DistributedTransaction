package com.lkyi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@DefaultProperties(defaultFallback = "fallBack")
public class RemoteController {

    @DubboReference
    private HelloDubboService helloDubboService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
//    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
//    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    @GetMapping("/helloDubbo")
    public String helloDubbo(String msg) throws InterruptedException {
        return helloDubboService.hello("from consumer");
    }

    public String fallBack() {
        return "fallback";
    }

    public String confirm() {
        logger.info("confirm");
        return "confirm";
    }

    public String cancel() {
        logger.info("cancel");
        return "cancel";
    }


}
