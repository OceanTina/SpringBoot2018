package com.huawei.huawei.repository;

import com.huawei.huawei.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository implements UserRepositoryInf{
    //采用内存型存储方式，考虑到高并发的情况
    private final ConcurrentMap<Integer, User> map = new ConcurrentHashMap<>();
    //自增长的
    private final static AtomicInteger idGenerator =
            new AtomicInteger();
    //保存数据,保存用户对象，如果成功则返还true
    public boolean save(User user)
    {
        boolean success = false;
        //ID从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setID(id);

        success =  map.put(id, user) == null;

        return success;
    }



    //返回所有用户信息

    public Collection<User> getAll()
    {
        return map.values();
    }
}
