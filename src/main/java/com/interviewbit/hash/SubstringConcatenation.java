package com.interviewbit.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstringV0(String A, final List<String> B) {
        if(B.size() == 0) return new ArrayList<Integer>();
        int n = A.length();
        int m = B.size();
        int x = B.get(0).length();
        if(m*x > n) return  new ArrayList<Integer>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < m; i++){
            if(map.containsKey(B.get(i))){
                map.put(B.get(i), map.get(B.get(i)) + 1);
            }else{
                map.put(B.get(i),1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer> ();

        int start=0;
        int end = 0;

        StringBuilder sb = new StringBuilder();
        while(end < n){
            sb.append(A.charAt(end));
            if(end - start == m*x-1){
                String str = sb.toString();
                //       System.out.println(str);

                int count = 0;
                int lo=0;
                int hi=0;
                HashMap<String, Integer> cur = (HashMap<String, Integer>)map.clone();

                while(hi < str.length() && count < m){
                    StringBuilder word = new StringBuilder();

                    while(hi-lo < x){
                        word.append(str.charAt(hi));
                        hi++;
                    }

                    lo = hi;
                    //     System.out.println(word.toString());
                    if(cur.containsKey(word.toString()) && cur.get(word.toString()) > 0){
                        cur.put(word.toString(), cur.get(word.toString())-1);
                        count++;
                    }else{
                        break;
                    }
                }

                if(count == m) res.add(start);

                start++;
                sb.deleteCharAt(0);
            }
            end++;
        }

        return res;
    }


    public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        int n = B.size();
        int b = B.get(0).length();
        int w = n * b;
        int startIndex = 0;
        int endIndex = w;
        String substring;
        boolean found = true;
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();

        Map<String, Integer> stringVsCountMap = getStringVsCountMap(B);

        for(startIndex = 0, endIndex = w; endIndex <= A.length(); startIndex++, endIndex++) {
            substring = A.substring(startIndex, endIndex);
            List<String> expectedWords = getExpectedStrings(b, substring);

            if(expectedWords.containsAll(B) && B.containsAll(expectedWords)) {
                result.add(startIndex);
            }

        }
        return result;
    }

    private int getHashSum(List<String> list) {
        int sum = 0;
        list.forEach(word -> {
//            sum
        });


        return sum;
    }

    private Map<String, Integer> getStringVsCountMap(List<String> words) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        words.forEach(word -> {
            if(stringIntegerMap.containsKey(word)) {
                stringIntegerMap.put(word, stringIntegerMap.get(word) + 1);
            } else {
                stringIntegerMap.put(word, 1);
            }
        });
        return stringIntegerMap;
    }

    private List<String> getExpectedStrings(int b, String substring) {
        List<String> expectedWords = new ArrayList<>();
        for(int i = 0; i < substring.length(); i+=b) {
            String str = substring.substring(i,i+b);
            expectedWords.add(str);
        }
        return expectedWords;
    }
}
