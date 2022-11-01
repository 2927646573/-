package com.cy.store;

import com.cy.store.entity.Order;
import com.cy.store.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create() {
        Integer[] cids = {2,3};
        Order order = orderService.create(8, cids, 11, "zhangsan");
        System.out.println(order);
    }
}

