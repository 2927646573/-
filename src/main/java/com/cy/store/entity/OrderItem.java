package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;

@Data
//@Table(name = "t_order_item")
/** 订单中的商品数据 */
public class OrderItem extends BaseEntity implements Serializable {
//    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;
}
