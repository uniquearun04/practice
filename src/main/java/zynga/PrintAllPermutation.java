package zynga;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutation {


    /* [ 1 2 3 ]
1
2
3
1,2
1,3
2,1
2,3
3,1
3,2
1,2,3
1,3,2
.
.
.
.
  */


    public static void main(String ...args) {
        int [] A = {1,2,3,4};
        PrintAllPermutation printAllPermutation = new PrintAllPermutation();
        int [] B = {1,2,3,4};
        printAllPermutation.printAllPurmutations(B);
        int [] C = {1,2,3,4,5};
        printAllPermutation.printAllPurmutations(C);
        int [] D = {1,2,3,4,5,6};
        printAllPermutation.printAllPurmutations(D);

    }


    public void printAllPurmutations(int [] A) {
        int n = A.length;

        List<String> finalList = new ArrayList<>();

        List<String> currentList = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            currentList.add(A[i]+"");
        }

        List<String> tempList = new ArrayList<>();
        while(!currentList.isEmpty()) {
            if(currentList.get(0).length() == n) {
                finalList.addAll(currentList);
                break;
            }
            String currentNum;
            for(int i = 0; i < currentList.size(); i++) {
                currentNum = currentList.get(i);
                List<String> remainingDigits = getRemainingDigits(currentNum, A);
                for(int j = 0; j < remainingDigits.size(); j++) {
                    tempList.add(currentNum+remainingDigits.get(j));
                }
            }
            finalList.addAll(currentList);
            currentList.clear();
            currentList.addAll(tempList);
            tempList.clear();
        }

        for(int i = 0; i < finalList.size(); i++) {
            System.out.println(finalList.get(i));
        }
    }

    private List<String> getRemainingDigits(String currentNum, int []A) {
        List<String> rmainingDigits = new ArrayList<>();
        List<Integer> currentDigits = new ArrayList<>();
        for(int i = 0; i < currentNum.length(); i++) {
            currentDigits.add(Integer.parseInt(currentNum.substring(i,i+1)));
        }
        for(int i = 0; i < A.length; i++) {
            int cd = A[i];
            boolean found = false;
            for(int j = 0; j < currentDigits.size(); j++) {
                int num = currentDigits.get(j);
                if(num == cd) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                rmainingDigits.add(""+cd);
            }
        }
        return rmainingDigits;
    }
}
