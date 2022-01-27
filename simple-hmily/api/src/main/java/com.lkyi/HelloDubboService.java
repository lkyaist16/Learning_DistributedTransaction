package com.lkyi;

import org.dromara.hmily.annotation.Hmily;

public interface HelloDubboService {
    @Hmily
    public String hello(String msg) throws InterruptedException;
}
