package com.test.test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void test1() {
        Product product1 = new Product(1001, "test1", 100);
        product1.print();
    }

    @Test
    public void test2() {
        record InnerRecord(Integer id, String name) {

        }

        InnerRecord innerRecord = new InnerRecord(1001, "test1");

        System.out.println(innerRecord);
    }
}