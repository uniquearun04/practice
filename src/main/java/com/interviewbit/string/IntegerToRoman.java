package com.interviewbit.string;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

    public String intToRoman(int A) {
        List<Entry> entryList = new ArrayList<>();
        entryList.add(new Entry(1000, "M"));
        entryList.add(new Entry(900, "CM"));
        entryList.add(new Entry(500, "D"));
        entryList.add(new Entry(400, "CD"));
        entryList.add(new Entry(100, "C"));
        entryList.add(new Entry(90, "XC"));
        entryList.add(new Entry(50, "L"));
        entryList.add(new Entry(40, "XL"));
        entryList.add(new Entry(10, "X"));
        entryList.add(new Entry(9, "IX"));
        entryList.add(new Entry(5, "V"));
        entryList.add(new Entry(4, "IV"));
        entryList.add(new Entry(1, "I"));

        int q = 0;
        Entry entry;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < entryList.size(); i++ ) {
            entry = entryList.get(i);
            q = A / entry.key;
            A = A % entry.key;
            for(int j = 0; j < q; j++) {
                sb.append(entry.val);
            }
        }
        return sb.toString();

    }

    private static class Entry{
        int key;
        String val;
        public Entry(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }
}
