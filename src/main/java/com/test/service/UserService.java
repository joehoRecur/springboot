package com.test.service;

import com.test.entity.Role;
import com.test.entity.User;
import com.test.mapper.UserMapper;
import com.test.pojo.UserRequest;
import com.test.repository.RoleRepository;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserMapper userMapper;
    public UserService() {}

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        if(id == null) return null;

        return userRepository.findById(id).orElse(null);
    }

    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.username);
        user.setPassword(userRequest.password);
        user.setAge(userRequest.age);
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreateTime(localDateTime);
        user.setUpdateTime(localDateTime);
        user.setRoleId(userRequest.roleId);

        return userRepository.save(user);
    }

    public User saveUser(Integer id, String username, String password, Integer age, Integer roleId) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(username != null) user.setUsername(username);
            if(password != null) user.setPassword(password);
            if(age != null) user.setAge(age);
            if(roleId != null) user.setRoleId(roleId);
            user.setUpdateTime(LocalDateTime.now());
            return userRepository.saveAndFlush(user);
        }
        return null;
    }

    public Boolean deleteUser(Integer id) {
        if(id == null) return false;

        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean deleteUsers() {
        userRepository.deleteAll();
        return true;
    }

    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    public User selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    public List<User> searchUsers(String key) {
        key = "%" + key + "%";
        return userMapper.searchUsers(key);
    }

    public User insertUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.username);
        user.setPassword(userRequest.password);
        user.setAge(userRequest.age);
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreateTime(localDateTime);
        user.setUpdateTime(localDateTime);
        user.setRoleId(userRequest.roleId);
        userRepository.save(user);
        return userMapper.insertUser(user);
    }

    public User updateUser(Integer id, String username, String password, Integer age, Integer roleID) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setRoleId(roleID);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);
        return user;
    }
}
