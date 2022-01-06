package com.lkyi;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public String preOrder(String msg) throws InterruptedException {
        logger.info("创建预下单");
        return "Create pre order";
    }

    public String confirm(String msg) {
        logger.info("完成订单");
        return "Complete order";
    }

    public String cancel(String msg) {
        logger.info("更新预下单状态为失败");
        return "Update pre order status Failed";
    }
}
