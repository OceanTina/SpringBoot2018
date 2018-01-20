package com.huawei.huawei.controller;
import com.huawei.huawei.model.User;
import com.huawei.huawei.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/person/save")
    public User save(@RequestParam String name)
    {
        User user = new User();
        user.setUserName(name);
        if(userRepository.save(user))
        {
            System.out.printf("用户对象：%s 保存成功！\n", user);
        }
        return user;
    }


}
