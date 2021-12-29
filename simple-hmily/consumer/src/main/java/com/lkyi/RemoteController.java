package com.lkyi;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "fallBack")
public class RemoteController {

    @DubboReference
    private HelloDubboService helloDubboService;

//    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
//    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    @GetMapping("/helloDubbo")
    public String helloDubbo(String msg) throws InterruptedException {
        return helloDubboService.hello("from consumer");
    }

    public String fallBack() {
        return "fallback";
    }

}
