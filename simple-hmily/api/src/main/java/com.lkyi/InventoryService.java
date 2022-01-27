package com.lkyi;

import org.dromara.hmily.annotation.Hmily;

public interface InventoryService {

    /**
     * 冻结库存
     * @param msg
     * @return
     * @throws InterruptedException
     */
    @Hmily
    public String frozenInventory(String msg) throws InterruptedException;

}
