package com.cy.store;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private UserMapper userMapper;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("zhangsan");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    
//    @Test
//    public void login() {
//        User user = userService.login("上杉绘梨衣", "123456");
//        System.out.println(user);
//    }
    
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(10,"321","zhangsan", new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(10));
    }

    @Test
    public void changePassword() {
        userService.changePassword(11,"管理员","123456","123");
    }
    
//    @Test
//    public void updateInfoByUid() {
//        userMapper.updateInfoByUid(11,"13333688","1454@qq.com",1,"zhangsan", new Date());
//    }
    
    @Test
    public void getByUid() {
        //err是为了让输出信息为红色
        System.err.println(userService.getByUid(11).getUsername());
    }

    @Test
    public void changeInfo() {
        User user = new User();
        //这四个属性值在真实开发中都是在控制层就已经自动封装在User对象中了
        //而uid需要由控制层传给业务层并在业务层封装到user中
        user.setPhone("123456789");
        user.setEmail("123@qq.com");
        user.setUsername("mxy");
        user.setGender(0);
        userService.changeInfo(11,user);
    }
    
    @Test
    public void updateAvatarByUid() {
        userMapper.updateAvatarByUid(11,"abc","mxy",new Date());
    }
    
    @Test
    public void changeAvatar() {
        userService.changeAvatar(11,"222","mmm");
    }

}

