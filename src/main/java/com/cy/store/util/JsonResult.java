package com.cy.store.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述信息
    private String message;
    
    private E data;
    
    public JsonResult() {
    }

    //将状态码传给构造方法初始化对象
    public JsonResult(Integer state) {
        this.state = state;
    }


    //将状态码和数据传给构造方法初始化对象
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    //如果有异常,直接将异常传递给构造方法初始化对象
    public JsonResult(Throwable e) {
        this.message=e.getMessage();
    }
    
}

