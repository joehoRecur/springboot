package com.test.mapper;

import com.test.entity.Role;
import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from roles where id = #{id}")
    Role selectRole(Long id);
}
