package com.hspedu.reader_;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\a.java";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取,效率高
        //说明
        //1. line = bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时, 表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流, 这里注意, 只需要关闭 BufferedReader , 因为底层会自动的去关闭 节点流
        //FileReader.
        bufferedReader.close();
    }
}
