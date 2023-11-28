package com.test.test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void test1() {
        Student student1 = new Student(1001, "jack", "jack@gmail.com", 10);
        Student student2 = new Student(1002, "joe", "joe@gmail.com", 11);
        System.out.println("test1:" + student1);

        Integer id1 = student1.id();
        System.out.println(id1);

        System.out.println(student1 == student2);
    }

    @Test
    public void test2() {
        Student student1 = new Student(1001, "jack", "jack@gmail.com", 10);
        System.out.println(student1.concat());
    }

    @Test
    public void test3() {
        System.out.println(Student.nameToUppercase("Jack"));
    }

    @Test
    public void test4() {
        Student student1 = new Student(1001, "jack");
        System.out.println(student1);

        Student student2 = new Student(-1, "joe");
        System.out.println(student2);
    }
}