package com.interviewbit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullyJustifyTextV2 {

    public static void main(String... args) {
//        ArrayList<String> inputList = new ArrayList<>(Arrays.asList("This", "is", "an", "example", "of", "text", "justification."));
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList("What", "must", "be", "shall", "be."));
        FullyJustifyTextV2 fullyJustifyTextV2 = new FullyJustifyTextV2();
//        ArrayList<String> justifiedStringList = fullyJustifyTextV2.fullJustify(inputList, 16);
        ArrayList<String> justifiedStringList = fullyJustifyTextV2.fullJustify(inputList, 12);
        System.out.println(justifiedStringList);
    }

    public ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {

        int i = 0;
        int n = words.size();
        int cl = 0;
        int l = 0;
        int si = 0;
        String fs = "";
        ArrayList<String> result = new ArrayList<>();
        while(i < n) {
            cl += words.get(i).length() + 1;
            if(cl - 1 >= maxWidth) {
                if(cl -1 > maxWidth) {
                    i--;
                }
                fs = getJustifiedString(si, i, words, maxWidth);
                result.add(fs);
                si = i+1;
                cl = 0;
            }
            i++;
        }
        if(si < i) {
            fs = getLastLineJustifiedString(si,i -1, words, maxWidth);
            result.add(fs);
        }


        return result;
    }

    private String getLastLineJustifiedString(int si, int i, ArrayList<String> words, int maxWidth) {
        List<String> subList = words.subList(si, i+1);

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < subList.size(); j++) {
            sb.append(subList.get(j));
            sb.append(" ");
        }
        int cl = sb.length();

        int diff = maxWidth - cl;
        for (int j = 0; j < diff; j++) {
            sb.append(" ");
        }

        if(sb.length() > maxWidth) {
            sb.delete(maxWidth, sb.length());
        }

        return sb.toString();
    }

    private String getJustifiedString(int si, int i, ArrayList<String> words, int maxWidth) {
        List<String> subList = words.subList(si, i+1);
        int cl = 0, wc = 0;
        for (int j = 0; j < subList.size(); j++) {
            cl += subList.get(j).length() + 1;
            wc++;
        }
        cl--;
        int diff = maxWidth - cl;
        int spaces = wc - 1;
        StringBuffer sb = new StringBuffer();
        if(spaces == 0) {
            sb.append(subList.get(0));
            sb.append(getSpaces(maxWidth - subList.get(0).length(), 0, 0));
            return sb.toString() ;
        }
        int commonSpace = diff / spaces;
        int modSpace = diff % spaces;

        for (int j = 0; j < subList.size(); j++) {
            sb.append(subList.get(j));
            sb.append(getSpaces(commonSpace, modSpace, j));
        }
        if(sb.length() > maxWidth) {
            sb.delete(maxWidth, sb.length());
        }

        return sb.toString();
    }

    private String getSpaces(int commonSpace, int modSpace, int j) {
        StringBuffer sb = new StringBuffer();
        String oneSpace = " ";
        sb.append(oneSpace);
        for (int i = 0; i < commonSpace; i++) {
            sb.append(oneSpace);
        }
        if(j < modSpace) {
            for (int i = 0; i < modSpace; i++) {
                sb.append(oneSpace);
            }
        }

        return sb.toString();
    }
}
