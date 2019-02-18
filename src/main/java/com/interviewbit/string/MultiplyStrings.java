package com.interviewbit.string;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public static void main(String ...args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String multiply = multiplyStrings.multiply("123", "232");
        System.out.println(multiply);
    }

    public String multiply(String A, String B) {

        if("0".equals(A) || "0".equals(B)) {
            return "0";
        }
        char [] charsA = A.toCharArray();
        char [] charsB = B.toCharArray();

        StringBuffer sb = new StringBuffer();
        int product = 0;
        int carry = 0;
        int sum = 0;
        List<String> list = new ArrayList<>();

        for (int i = charsB.length - 1; i >= 0; i--) {
            carry = 0;
            sum = 0;
            for (int j = charsA.length - 1; j >= 0; j--) {
                product = (charsB[i] - 48) * (charsA[j] - 48);
                sum = product + carry;
                carry = sum / 10;
                sum = sum % 10;
                sb.append(sum);
            }
            if(carry > 0) {
                sb.append(carry);
            }
            if(sb.length() > 0) {
                list.add(getStringAfterPaddinZeroes(sb, list.size()));
                sb.delete(0,sb.length());
            }
        }


        return removeLeadingZeroes(getSumOfNumbers(list));
    }

    String removeLeadingZeroes(String number) {
        if(number.length() == 1) {
            return number;
        }
        int i = 0;
        for (i = 0; i < number.length(); i++) {
            if(number.charAt(i) != '0') {
                break;
            }
        }
        return number.substring(i);
    }

    String getStringAfterPaddinZeroes(StringBuffer sb, int length) {
        String string = sb.reverse().toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        for (int i = 0; i < length; i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.toString();
    }

    String getSumOfNumbers(List<String> list) {
        String string = list.get(0);
        if(list.size() > 0) {
            for (int i = 1; i < list.size(); i++) {
                string = sumNumberStrings(string, list.get(i));
            }
        }
        return string;
    }

    String sumNumberStrings(String A, String B) {
        char [] charsA = A.toCharArray();
        char [] charsB = B.toCharArray();

        StringBuffer sb = new StringBuffer();
        int sum = 0;
        int carry = 0;
        int i,j;
        for (i = charsA.length - 1, j = charsB.length - 1; i >= 0 && j >= 0; i--,j--) {
            sum = (charsA[i] - 48) + (charsB[j] - 48) + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
        while(i >= 0) {
            sum = (charsA[i] - 48) + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            i--;
        }
        while(j >= 0) {
            sum = (charsB[j] - 48) + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            j--;
        }

        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
