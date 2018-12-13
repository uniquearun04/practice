/**
 * Created by achaudhary on 6/8/18.
 */
public class MedianOfTwoSortedArray {


    public static void main(String ...args) {

        int A[] = {1,2};
        int B[] = {3,4};

        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        double median = medianOfTwoSortedArray.findMedianSortedArrays(A, B);
        System.out.println(median);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int mergedArry[] = mergeArrays(nums1, nums2);
        double median = 0.0;
        int mid = mergedArry.length / 2;
        if(mergedArry.length % 2 == 1) {
            median = mergedArry[mid];
        } else {
            median = (mergedArry[mid] + mergedArry[mid - 1]) / 2.0;
        }
        return median;
    }

    private int[] mergeArrays( int A[], int B[]) {
        int C[] = new int[A.length + B.length];

        for(int i = 0, j = 0, k = 0; i < C.length; i++) {
            if(j < A.length && k < B.length) {
                if(A[j] < B[k]) {
                    C[i] = A[j];
                    j++;
                } else {
                    C[i] = B[k];
                    k++;
                }
            } else if(j < A.length) {
                C[i] = A[j];
                j++;
            } else if(k < B.length) {
                C[i] = B[k];
                k++;
            }
        }
        return C;
    }
}
