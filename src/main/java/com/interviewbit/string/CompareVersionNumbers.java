package com.interviewbit.string;

/**
 * Created by achaudhary on 2/14/19.
 */
/*
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:
0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

 */
public class CompareVersionNumbers {

    public static void main(String ...args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
//        int compareVersion = compareVersionNumbers.compareVersion("01", "1");
//        int compareVersion1 = compareVersionNumbers.compareVersion("13.0", "13.0.8");
//        int compareVersion2 = compareVersionNumbers.compareVersion("1.0", "1");
        int compareVersion3 = compareVersionNumbers.compareVersion("4444371174137455", "5.168");
        System.out.println(compareVersion3);
    }


    public int compareVersion(String A, String B) {
        A = removeLeadingZeroes(A);
        B = removeLeadingZeroes(B);
        A = pruneTrailingZeroOrDot(A);
        B = pruneTrailingZeroOrDot(B);
        return compareNumbers(A, B);
//        int compareTo = A.compareTo(B);
//        return compareTo > 0 ? 1 : (compareTo == 0 ? 0 : -1);
    }

    private int compareNumbers(String A, String B) {
        String[] splitA = A.split("\\.");
        String[] splitB = B.split("\\.");

        if(splitA.length == splitB.length) {
            int n = splitA.length;
            Integer compareTo = compareSubPart(A, B, splitA, splitB, n);
            if (compareTo != null) return compareTo;
        } else {
            int n = Math.min(A.length(), B.length());


        }

        return 1;
    }

    private Integer compareSubPart(String A, String B, String[] splitA, String[] splitB, int n) {
        for (int i = 0; i < n; i++) {
            String a = splitA[i];
            String b = splitB[i];
            a = removeLeadingZeroes(a);
            a = pruneTrailingZeroOrDot(a);
            b = removeLeadingZeroes(b);
            b = pruneTrailingZeroOrDot(b);
            if(a.length() != b.length()) {
                int compareTo = a.length() > b.length() ? 1 : (a.length() == b.length() ? 0 : -1);
                return compareTo;
            } else {
                int compareTo = A.compareTo(B);
                if(compareTo == 0) {
                    continue;
                }
                return compareTo > 0 ? 1 : -1;
            }
        }
        return -2;
    }

    private String removeLeadingZeroes(String A) {
        A = A.trim();
        int i = 0;
        while(i < A.length() && A.substring(i,i+1).equals("0") ) {
            i++;
        }
        A = A.substring(i);
        return A;
    }

    private String pruneTrailingZeroOrDot(String str) {
        String[] split = str.split("\\.");
        if(split.length < 1) {
            return str;
        }
        if(split.length == 1) {
            return split[0];
        }
        String lastPart = split[split.length-1];
        lastPart = removeLeadingZeroes(lastPart);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i]).append(".");
        }
        if(lastPart.length() > 0) {
            sb.append(lastPart);
        } else {
            sb.delete(sb.length() -1, sb.length());
        }
        return sb.toString();
    }


}
