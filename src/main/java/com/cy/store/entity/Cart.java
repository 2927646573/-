package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;

@Data
/** 购物车数据的实体类 */
public class Cart extends BaseEntity implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
}
