package com.test.test1;

import org.junit.Test;

import java.lang.reflect.RecordComponent;

import static org.junit.Assert.*;

public class OverallTest {
    @Test
    public void test1() {
        Student student = new Student(1001, "jack", "jack@gmail.com", 10);
        Product product = new Product(1001, "test1", 100);

        Overall overall = new Overall(1, "test1" , student, product);
        System.out.println(overall);
    }

    @Test
    public void test2() {
        Student student = new Student(1001, "jack", "jack@gmail.com", 10);
        Product product = new Product(1001, "test1", 100);
        Overall overall = new Overall(1, "test1" , student, product);

        System.out.println(overall.getClass());

        Boolean test = overall.getClass().isRecord();
        if(test) {
            RecordComponent[] recordComponents = overall.getClass().getRecordComponents();
            for (RecordComponent recordComponent : recordComponents) System.out.println(recordComponent);
        }
    }
}