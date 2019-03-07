package com.interviewbit.stacksnQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {


    public static void main(String ...args) {

        Subsets subsets = new Subsets();
        ArrayList<ArrayList<Integer>> arrayLists = subsets.subsets(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> subsetsV1(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            result.forEach(list -> {
                res.add(new ArrayList<>(list));
            });
            res.forEach(list -> list.add(num));
            result.addAll(res);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0)
            return output;
        Collections.sort(a);
        generate(a, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++)
        {
            temp.add(a.get(i));
            output.add(new ArrayList<Integer>(temp));
            generate(a, output, temp, i+1);
            temp.remove(temp.size() - 1);
            System.out.println(temp);
        }
    }


}
