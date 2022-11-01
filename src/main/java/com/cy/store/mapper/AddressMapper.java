package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * 收货地址持久层的接口
 */
public interface AddressMapper {
    /**
     * 插入用户的收货地址数据
     *
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    @Insert("insert into t_address (uid, name, province_name, province_code, city_name, city_code, area_name, area_code, zip,address, phone, tel,tag, is_default, created_user, created_time, modified_user, modified_time) values (#{uid}, #{name}, #{provinceName}, #{provinceCode}, #{cityName}, #{cityCode}, #{areaName}, #{areaCode}, #{zip}, #{address}, #{phone}, #{tel}, #{tag}, #{isDefault}, #{createdUser},#{createdTime}, #{modifiedUser}, #{modifiedTime})")
    Integer insert(Address address);

    /**
     * 根据用户的uid统计收货地址数量
     *
     * @param uid 用户的uid
     * @return 当前用户的收货地址总数
     */
    @Select("select count(*) from t_address where uid=#{uid}")
    Integer countByUid(Integer uid);

    /**
     * 根据用户的uid查询用户的收货地址数据
     *
     * @param uid 用户uid
     * @return 收货地址数据
     */
    @Select("select * from t_address where uid=#{uid} order by is_default DESC,created_time DESC")
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址数据
     *
     * @param aid 收货地址aid
     * @return 收货地址数据, 如果没有找到则返回null值
     */
    @Select("select * from t_address where aid=#{aid}")
    Address findByAid(Integer aid);

    /**
     * 根据用户uid修改用户的收货地址统一设置为非默认
     *
     * @param uid 用户uid
     * @return 受影响的行数
     */
    @Update("update t_address set is_default=0 where uid=#{uid}")
    Integer updateNonDefault(Integer uid);


    /**
     * 将用户选中的这条记录设置为默认收货地址
     *
     * @param aid
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    @Update("update t_address set is_default=1,modified_user=#{modifiedUser},modified_time=#{modifiedTime} where aid=#{aid}")
    Integer updateDefaultByAid(@Param("aid") Integer aid, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     */
    @Delete("delete from t_address where aid=#{aid}")
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询用户最后一次被修改的收货地址数据
     * @param uid 用户id
     * @return 收货地址数据
     */
    @Select("select * from t_address where uid=#{uid} order by modified_time DESC limit 0,1")
    Address findLastModified(Integer uid);

}
