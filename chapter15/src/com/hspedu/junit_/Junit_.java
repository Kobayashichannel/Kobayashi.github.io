package com.hspedu.junit_;

import org.junit.jupiter.api.Test;

public class Junit_ {
    public static void main(String[] args) {
        //传统方法
        //new Junit_().m1();
        //new Junit_().m2();
    }

    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
