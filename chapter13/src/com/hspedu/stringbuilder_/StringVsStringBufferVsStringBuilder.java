package com.hspedu.stringbuilder_;

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {

        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) { //StringBuffer 拼接 20000次
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间: " + (endTime - startTime));




        StringBuilder builder = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间: " + (endTime - startTime));


        String text = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) { //String 拼接了20000次
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间: " + (endTime - startTime));
    }
}
