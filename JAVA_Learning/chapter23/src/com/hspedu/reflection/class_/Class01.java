package com.hspedu.reflection.class_;

/**
 * 演示class类
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1. Class也是类,因此也继承Object类
        //Class
        //2. Class类对象不是new出来的,而是系统创建的
        //(1) 传统new对象
        /*
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式,刚才老师没有debug到 ClassLoader类的 loadClass,原因是,没有注销Cat cat = new Cat();
        /*
            ClassLoader类,仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.hspedu.Cat");

        //3. 对于某个类的Class类对象,在内存中只有一份,因此类只加载一次
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        Class cls3 = Class.forName("com.hspedu.Dog");
        System.out.println(cls3.hashCode());

    }
}
