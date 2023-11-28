package com.test.test1;

import java.util.Optional;

public record Student(Integer id, String name, String email, Integer age) {
    public String concat() {
        return String.format("Name:%s, age:%d, email:%s", this.name, this.age, this.email);
    }

    public static String nameToUppercase(String name) {
        return Optional.ofNullable(name).orElse("no name").toUpperCase();
    }

    public Student {
        if(id < 0) throw new RuntimeException("custom error");
    }

    public Student(Integer id, String name) {
        this(id, name, null, null);
    }
}
