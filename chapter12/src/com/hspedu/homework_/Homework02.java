package com.hspedu.homework_;

public class Homework02 {
    public static void main(String[] args) {
        //args.length = 0
        //这里发生的是 ArrayIndexOutOfBoundsException

        if (args[4].equals("john")) { //可能发生 NullPointerException
            System.out.println("AA");
        } else {
            System.out.println("BB");
        }
        Object o = args[2]; //String -> Object
        Integer i = (Integer)o; //错误，这里一定会发生 ClassCastException
    }
}
