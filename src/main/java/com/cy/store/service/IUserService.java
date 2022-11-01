package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * 用户
 * @author 啦啦啦
 */
public interface IUserService {
    /**
     * 用户注册
     * @param user 
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username 
     * @param password
     * @return
     */
    User login(String username,String password);
    
    /**
     * 修改密码
     * @param uid         
     * @param username
     * @param oldPassword
     * @param newPassword*/
    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 根据用户的uid查询用户数据
     * @param uid 用户uid
     * @return 用户数据
     */
    User getByUid(Integer uid);

    /**
     * uid通过控制层在session中获取然后传递给业务层,并在业务层封装到User对象中
     * */
    void changeInfo(Integer uid,User user);
    
    /**
     * 修改用户的头像
     * @param uid 用户uid
     * @param avatar 用户头像的路径
     * @param username 用户名称
     */
    void changeAvatar(Integer uid,String avatar,String username);

}
