package com.huawei.huawei.dao.mapper;

import com.huawei.huawei.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserByUserId(@Param("id") int id);

//    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
//    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);
}
