package com.test.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    public String username;
    public String password;
    public Integer age;
    public Integer roleId;
}
