package com.hspedu.list_;

import java.util.ArrayList;
@SuppressWarnings({"all"})
public class ArrayListDetail {
    public static void main(String[] args) {

        //ArrayList 是线程不安全的, 可以看源码  没有synchronized
        /*
        public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);

    }
}
