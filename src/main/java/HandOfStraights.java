import java.util.Arrays;

/**
 * Created by achaudhary on 6/8/18.
 */
public class HandOfStraights {

    public static void main(String ...args) {

        int[] hand = {1,2,3,6,2,3,4,7,8};
        int W = 3;
//        int[] hand = {1,2,1,4};
//        int W = 4;

//        int[] hand = {5,1};
//        int W = 2;

//        int[] hand = {0,0};
//        int W = 2;


        HandOfStraights handOfStraights = new HandOfStraights();
        boolean returnVal = handOfStraights.isNStraightHand(hand, W);
        System.out.println(returnVal);
    }


    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) {
            return false;
        }
        int negVal = -100;
        int numGroups = hand.length / W;
        Arrays.sort(hand);
        int sortedHand[] = new int[hand.length];
        for (int i = 0; i < numGroups; i++) {
            for (int j = 0, k = 0; j < hand.length && k < W; j++) {
                int index = i * W + k;
                if(k == 0 && hand[j] != negVal) {
                    sortedHand[index] = hand[j];
                    hand[j] = negVal;
                    k++;
                } else {
                    if(hand[j] != 0) {
                        if(hand[j] == sortedHand[index -1] + 1) {
                            sortedHand[index] = hand[j];
                            hand[j] = negVal;
                            k++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <  hand.length; i++) {
            if(hand[i] != negVal) {
                return false;
            }
        }

        return true;
    }
}
