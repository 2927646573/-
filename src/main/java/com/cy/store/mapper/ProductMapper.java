package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    @Select("select * from t_product where status=1 order by priority desc LIMIT 0,4")
    List<Product> findHotList();
    
    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    @Select("select * from t_product where id=#{id}")
    Product findById(Integer id);
    
    
}

