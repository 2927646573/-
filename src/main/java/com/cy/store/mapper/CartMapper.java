package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.entity.vo.CartVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface CartMapper {

    /**
     * 插入购物车数据
     *
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    @Insert("insert into t_cart(uid,pid,price,num,created_user,created_time,modified_user,modified_time) values (#{uid},#{pid},#{price},#{num},#{createdUser},#{createdTime},#{modifiedUser},#{modifiedTime})")
    Integer insert(Cart cart);

    /**
     * 修改购物车数据中商品的数量
     *
     * @param cid          购物车数据的id
     * @param num          新的数量
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    @Update("update t_cart set num=#{num} where cid=#{cid}")
    Integer updateNumByCid(@Param("cid") Integer cid, @Param("num") Integer num, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和商品id查询购物车中的数据
     *
     * @param uid 用户id
     * @param pid 商品id
     * @return 匹配的购物车数据，如果该用户的购物车中并没有该商品，则返回null
     */
    @Select("select * from t_cart where uid=#{uid} and pid=#{pid}")
    Cart findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    @Select("select cid,uid,pid,t_cart.price,t_cart.num,title,t_product.price as realPrice,image from t_cart left join t_product on t_cart.pid = t_product.id where uid = #{uid} order by t_cart.created_time desc")
    List<CartVO> findVOByUid(Integer uid);
    
    /**
     * 查询商品数据
     * @param cid 
     * @return
     */
    @Select("select * from t_cart where cid=#{cid}")
    Cart findByCid(@Param("cid") Integer cid);

    /**
     * 查询购物车数据表，显示购物车中的数据信息
     * @return
     * @param cids
     */
    @Select({
            "<script>",
            "select",
            "cid,uid,pid,t_cart.price,t_cart.num,title,t_product.price as realPrice,image",
            "from t_cart left join t_product on t_cart.pid = t_product.id",
            "where cid in",
            "<foreach collection='cids' item='cid' open='(' separator=',' close=')'>",
            "#{cid}",
            "</foreach>",
            "order by t_cart.created_time desc",
            "</script>"
    })
    List<CartVO> findVOByCids(@Param("cids") Integer[] cids);
}

