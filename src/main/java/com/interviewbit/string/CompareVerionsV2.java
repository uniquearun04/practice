package com.interviewbit.string;

import java.math.BigInteger;

/**
 * Created by achaudhary on 2/14/19.
 */
public class CompareVerionsV2 {

    public static void main(String ...args) {
        CompareVerionsV2 compareVersionNumbers = new CompareVerionsV2();
//        int compareVersion = compareVersionNumbers.compareVersion("01", "1");
//        int compareVersion1 = compareVersionNumbers.compareVersion("13.0", "13.0.8");
//        int compareVersion2 = compareVersionNumbers.compareVersion("1.0", "1");
        int compareVersion3 = compareVersionNumbers.compareVersion("4444371174137455", "5.168");
        System.out.println(compareVersion3);
    }

    public int compareVersion(String A, String B) {
        String[] splitA = A.split("\\.");
        String[] splitB = B.split("\\.");
        int i = 0, j = 0;
        for (; i < splitA.length && j < splitB.length ; i++, j++) {

        }
        return 2;
    }

    public int compareVersionV0(String A, String B) {
        String[] a = A.split("\\."), b = B.split("\\.");
        int i=0, j=0;
        for(; i<a.length && j<b.length; i++, j++) {
            BigInteger c = new BigInteger(a[i]), d = new BigInteger(b[j]);
            if(c.compareTo(d)==1) return 1;
            if(c.compareTo(d)==-1) return -1;
            //System.out.println(i+" "+j);
        }
        if(i==a.length && j==b.length) return 0;
        else if(i<a.length) {
            while(i<a.length)
                if(new BigInteger(a[i++]).compareTo(BigInteger.ZERO)!=0)
                    return 1;
            return 0;
        }
        else {
            while(j<b.length)
                if(new BigInteger(b[j++]).compareTo(BigInteger.ZERO)!=0)
                    return -1;
            return 0;
        }
    }
}
