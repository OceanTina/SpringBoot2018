package com.huawei.huawei.service;

import com.huawei.huawei.dao.mapper.UserMapper;
import com.huawei.huawei.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByUserId(int userId) {
        User user = userMapper.selectUserByUserId(userId);
        return user;
    }
}
