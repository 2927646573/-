package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

public interface OrderMapper {
    /**
     * 插入订单数据
     *
     * @param order 订单数据
     * @return 受影响的行数
     */
//    @Insert("insert into t_order (uid, recv_name, recv_phone, recv_province, recv_city, recv_area, recv_address,total_price,status, order_time, pay_time, created_user, created_time, modified_user,modified_time) values (#{uid}, #{recvName}, #{recvPhone}, #{recvProvince}, #{recvCity}, #{recvArea},#{recvAddress}, #{totalPrice}, #{status}, #{orderTime}, #{payTime}, #{createdUser}, #{createdTime}, #{modifiedUser}, #{modifiedTime})")
    Integer insertOrder(Order order);

    /**    * 插入某一个订单中商品数据 
     *
     * @param orderItem 订单中商品数据
     * @return 受影响的行数
 
     */
//    @Insert("insert into t_order_item (oid, pid, title, image, price, num, created_user,created_time, modified_user, modified_time) values (#{oid}, #{pid}, #{title}, #{image}, #{price}, #{num}, #{createdUser}, #{createdTime}, #{modifiedUser}, #{modifiedTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "oid")
    Integer insertOrderItem(OrderItem orderItem);
}
