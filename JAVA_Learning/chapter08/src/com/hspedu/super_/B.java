package com.hspedu.super_;

public class B extends A {

    public int n1 = 888;

    //编写方法测试
    public void test(){
        //super的访问不限于父类,如果爷爷类和本类同名的成员,也可以使用super去访问爷爷类的成员
        // 如果是多个基类(上级类)中都有同名的成员, 使用super访问遵循就近原则。A->B->C

        System.out.println("super.n1=" + super.n1);
        super.cal();
    }

    //访问父类的属性 , 但不能访问父类的 private 属性 [案例]super.属性名
    public void hi(){
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3 );
    }
    public void cal() {
        System.out.println("B类的cal() 方法...");
    }
    public void sum() {
        System.out.println("B类的sum()");
        //希望调用父类-A 的cal方法
        //这时,因为子类B没有cal方法,因此我可以使用下面三种方法

        //找cal方法时(cal() 和 this.cal()) 顺序是:
        // (1)找cal方法时,顺序是,先找本类,如果有,并且可调用,则调用,
        // (2)如果没有,则找父类(如果有,并可以调用,则调用)
        // (3)如果父类没有,啧继续找父类的父类,整个规则,就是一样的,直到 Object类
        // 提示: 如果查到方法的过程中, 找到了, 但是不能访问,则报错, cannot access
        //       如果查到方法的过程中, 没有找到, 则提示方法不存在
        //cal();
        this.cal(); //等价 cal

        // 找cal方法(super.cal())的顺序是直接查找父类,其他的规则一样
        //super.cal();

        //演示访问属性的规则
        //n1 和 this.n1 查找的规则是
        //(1) 先找本类,如果有,则调用
        //(2) 如果没有,则找父类(如果有,并可以调用,则调用)
        //(3) 如果父类没有,啧继续找父类的父类,整个规则,就是一样的,直到 Object类
        // 提示: 如果查到方法的过程中, 找到了, 但是不能访问,则报错, cannot access
        //       如果查到属性的过程中, 没有找到, 则提示属性不存在
        System.out.println(n1);//888
        System.out.println(this.n1);//888

        // 找n1 (super.n1)的顺序是直接查找父类,其他的规则一样
        System.out.println(super.n1);//100

    }
    //访问父类的方法, 不能访问父类的private方法 super.方法名(参数列表);
    public void ok(){
        super.test100();
        super.test200();
        super.test300();
        //super.test400(); //不能访问父类private方法
    }
    //访问父类的构造器(这点前面用过):super(参数列表);只能放在构造器的第一句,只能出现一句!
    public B() {
        //super();
        //super("jack", 10);
        super("jack");
    }
}
