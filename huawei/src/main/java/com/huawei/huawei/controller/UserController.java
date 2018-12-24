package com.huawei.huawei.controller;
import com.huawei.huawei.model.User;
import com.huawei.huawei.repository.UserRepository;
import com.huawei.huawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 保存用户
     * @param name
     * @return
     */
    @PostMapping("/save")
    public User save(@RequestParam String name)
    {
        User user = new User();
        user.setName(name);
        if(userRepository.save(user))
        {
            System.out.printf("用户对象：%s 保存成功！\n", user);
        }
        return user;
    }

    /**
     * 根据用户ID查询用户信息
     */
    @RequestMapping("/getUserByUserID")
    @ResponseBody
    public User getUserByUserID(int userId) {
//        User user = new User();
//        user.setID(userId);
//        user.setUserName("Tom");

        User user = userService.getUserByUserId(userId);
        return user;
    }


}
