package com.hspedu.homework.Homework5;

public class Worker extends Employee { //子类
    //属性
    //工人,农民,服务生只有基本工资 sal
    public Worker(String name, double sal) {
        super(name, sal);
    }

    //方法

    @Override
    public void printSal() {
        System.out.println("工人 ");
        super.printSal();//使用了父类的printSal()方法
    }
}
