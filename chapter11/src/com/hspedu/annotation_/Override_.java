package com.hspedu.annotation_;

public class Override_ {
    public static void main(String[] args) {

    }
}
class Father { //父类
    public void fly() {
        System.out.println("Father fly...");
    }
    public void say(){}
}
class Son extends Father { //子类
    //老韩解读
    //1. @Override 注解放在了fly方法上,表示子类的fly方法重写了父类的fly方法
    //2. 这里如果没有重写  @Override 还是重写了父类fly
    //3. 如果你重写了 @Override 注解,编译器就会去检查该方法是否真的重写了父类的
    //   的方法,如果的确重写了,则编译通过,如果没有构成重写,则编译错误
    //4. 看看 @Override 的定义
    //   解读: 如果发现 @interface 表示一个 注解类
    /*
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {
        }
     */
    @Override //说明
    public void fly() {
        System.out.println("Son fly...");
    }
    @Override
    public void say(){

    }
}