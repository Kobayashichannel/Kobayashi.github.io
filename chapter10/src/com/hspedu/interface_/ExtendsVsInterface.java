package com.hspedu.interface_;

import jdk.nashorn.internal.ir.CallNode;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

//接口
interface Fishable {
    void swimming();
}
interface Birdable {
    void flying();
}

//猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }
    public void climbing() {
        System.out.println(name + "会爬树...");
    }

    public String getName() {
        return name;
    }
}

//继承
//小结: 当子类继承了父类,就自动的拥有了父类的功能
//      如果子类需要拓展功能,可以通过实现接口的方式拓展
//      可以理解 实现接口 是对 java 单继承机制的一种补充
class LittleMonkey extends Monkey implements Fishable,Birdable{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " 通过学习,可以像鱼儿一样游泳...");
    }

    @Override
    public void flying() {
        System.out.println(getName() + " 通过学习,可以像鸟儿一样飞翔...");
    }
}
