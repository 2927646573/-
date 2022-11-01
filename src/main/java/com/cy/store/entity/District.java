package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;

@Data
/** 省/市/区数据的实体类 */
public class District implements Serializable {
    private Integer id;
    private String parent;
    private String code;
    private String name;

}
