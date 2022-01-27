package com.lkyi;

import org.dromara.hmily.annotation.Hmily;

public interface OrderService {

    /**
     * 冻结库存
     * @param msg
     * @return
     * @throws InterruptedException
     */
    @Hmily
    public String preOrder(String msg) throws InterruptedException;

}
