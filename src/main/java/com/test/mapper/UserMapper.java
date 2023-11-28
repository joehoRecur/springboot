package com.test.mapper;

import com.test.entity.Role;
import com.test.entity.User;
import com.test.pojo.UserRequest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select users.username roles.name from users join roles on role_id = roles.id")
//@Select("SELECT u.id, u.username, r.name FROM users u JOIN roles r ON u.role_id = r.id WHERE u.role_id = FOR JSON AUTO")
//    @Result(column = "role_id", property = "role", javaType = Role.class, one = @One(select = "com.test.mapper.RoleMapper.selectRole"))
    List<User> selectUsers();

    @Select("select * from users where id = #{id}")
//    @Result(column = "role_id", property = "role", javaType = Role.class, one = @One(select = "com.test.mapper.RoleMapper.selectRole"))
    User selectUser(Integer id);

    @Select("select * from users where username like #{key}")
//    @Result(column = "role_id", property = "role", javaType = Role.class, one = @One(select = "com.test.mapper.RoleMapper.selectRole"))
    List<User> searchUsers(String key);

    @Insert("insert into users(username, password, age, create_time, update_time, role_id) values(#{username}, #{password}, #{age}, #{createTime}, #{updateTime}, #{role_id})")
    @Result(column = "role_id", property = "role", javaType = Role.class, one = @One(select = "com.test.mapper.RoleMapper.selectRole"))
    User insertUser(User user);

    User updateUser(User user);
}
