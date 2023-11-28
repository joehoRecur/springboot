package com.test.test1;

import java.util.StringJoiner;

public record Product(Integer id, String name, Integer quantity) implements ProductInterface {
    @Override
    public void print() {
        StringJoiner stringJoiner = new StringJoiner("->");
        String result = stringJoiner.add(id.toString()).add(name).add(quantity.toString()).toString();
        System.out.println("result: " + result);
    }
}
