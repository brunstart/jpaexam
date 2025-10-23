package org.example.jpa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test {
    private String name;

    public static void main(String[] args) {
        Test test = new Test();
        test.setName("test");
        test.getName();

        System.out.println(test.getName());
    }
}
