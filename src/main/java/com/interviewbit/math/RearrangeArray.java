package com.interviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {
        ArrayList<Integer> copy = new ArrayList<>(a);
        for (int i = 0; i < a.size(); i++) {
            a.set(i, copy.get(copy.get(i)));
        }
    }


    public static void main(String ...args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(3);

        RearrangeArray rearrangeArray = new RearrangeArray();
        rearrangeArray.arrange(list);
        System.out.println(list);

    }
}
