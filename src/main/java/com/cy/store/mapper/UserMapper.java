package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @author 啦啦啦
 */
public interface UserMapper {

    //    注册
    @Insert("insert into t_user(username,password,salt,phone,email,gender,avatar,is_delete,created_user,created_time,modified_user,modified_time) values (#{username},#{password},#{salt},#{phone},#{email},#{gender},#{avatar},#{isDelete},#{createdUser},#{createdTime},#{modifiedUser},#{modifiedTime})")
    Integer insert(User user);

    //    判断用户名是否存在
    @Select("select * from t_user where username=#{username}")
    User findByUsername(String username);


    //  根据用户的uid修改用户password值
    @Update("update t_user set password = #{password},modified_user=#{modifiedUser},modified_time=#{modifiedTime} WHERE uid=#{uid}")
    Integer updatePasswordByUid(@Param("uid") Integer uid, @Param("password") String password, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

    //  在执行修改密码之前，还应检查用户数据是否存在或者用户数据是否被标记为"已删除"   
    @Select("select * from t_user where uid=#{uid}")
    User findByUid(Integer uid);

    //   修改用户信息
    @Update("update t_user set phone=#{phone},email=#{email},gender=#{gender},modified_user=#{modifiedUser},modified_time=#{modifiedTime} where uid=#{uid}")
//    Integer updateInfoByUid(@Param("uid") Integer uid, @Param("phone") String phone, @Param("email") String email, @Param("gender") Integer gender, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);
    Integer updateInfoByUid(User user);

    //    根据用户uid修改用户的头像
    @Update("update t_user set avatar=#{avatar},modified_user=#{modifiedUser},modified_time=#{modifiedTime} WHERE uid=#{uid}")
    Integer updateAvatarByUid(@Param("uid") Integer uid, @Param("avatar") String avatar, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

}
