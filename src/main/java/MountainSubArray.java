import java.io.IOException;

/**
 * Created by achaudhary on 6/8/18.
 */
public class MountainSubArray {

    public static void main(String ...args) throws IOException {

        MountainSubArray mountainSubArray = new MountainSubArray();

//        int A[] = {2,1,4,7,3,2,5,4,3,2,1,0,-1,0};
//        int A[] = {875,884,239,731,723,685};
        int A[] = {1,2,0,2,0,2};
//        int A[] = {0,1,2,3,4,5,6,7,8,9};
        //[875,884,239,731,723,685]

        int mountainLength = mountainSubArray.longestMountain(A);
        System.out.println("lenght of highest mountain: "+ mountainLength);
    }


    public int longestMountain(int[] A) {
        int prevDiff = 0;
        int diff = 0;
        int maxLen = 0;
        int curLen = 0;
        boolean peak = false;

        for(int i = 1; i < A.length; i++) {
            diff = A[i] - A[i-1];
            if(diff > 0) {
                if(prevDiff < 0 && curLen > 0) {
                    if(curLen > maxLen) {
                        maxLen = curLen;
                    }
                    curLen = 0;
                }
                curLen ++;
            } else if(diff == 0) {
                if(curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = 0;
            } else if(diff < 0) {
                if(curLen > 0) {
                    curLen ++;
                    if( prevDiff > 0) {
                        peak = true;
                    }
                }
            }
            prevDiff = diff;
        }
        if(curLen > maxLen) {
            maxLen = curLen;
        }
        maxLen ++;
        return peak ? (maxLen < 3 ? 0 : maxLen) : 0;
    }
}
