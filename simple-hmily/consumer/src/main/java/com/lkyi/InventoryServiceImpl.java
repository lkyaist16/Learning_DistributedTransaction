package com.lkyi;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService
public class InventoryServiceImpl implements InventoryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public String frozenInventory(String msg) throws InterruptedException {
        logger.info("冻结库存+1");
        return "Frozen inventory +1";
    }

    public String confirm(String msg) {
        logger.info("库存-1，冻结库存-1");
        return "Inventory reduction 1, Frozen inventory -1";
    }

    public String cancel(String msg) {
        logger.info("恢复冻结库存");
        return "Restore frozen inventory";
    }
}
