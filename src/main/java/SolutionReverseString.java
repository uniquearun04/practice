import java.io.IOException;

/**
 * Created by achaudhary on 6/2/18.
 */
public class SolutionReverseString {

    public static void main(String ...args) throws IOException {
        String start = "XXRXLXRXXX";
        String end = "XXRLXXXXXR";

        boolean canTransform = canTransform(start, end);
        System.out.println("can transform: "+canTransform);
    }
    public static boolean canTransform(String start, String end) {
        int l = start.length();
        int m = end.length();
        if(l != m) return false;

        int slc = 0;
        int src = 0;
        int sxc = 0;
        int elc = 0;
        int erc = 0;
        int exc = 0;
        for(int i = 0; i < l; i++) {
            if(start.charAt(i) == 'L') slc += 1;
            if(start.charAt(i) == 'R') src += 1;
            if(start.charAt(i) == 'X') sxc += 1;
            if(end.charAt(i) == 'L') elc += 1;
            if(end.charAt(i) == 'R') erc += 1;
            if(end.charAt(i) == 'X') exc += 1;
        }

        if(slc != elc || src != erc || sxc != exc) {
            return false;
        }
        if(!start.replace("X","").equals(end.replace("X",""))){
            return false;
        }

        for(int i = 0, t = 0; i < l; i++) {
            if(start.charAt(i) == 'L') {
                while(end.charAt(t) != 'L') t++;
                if(t > i) return false;
                t++;
            }
            if(start.charAt(i) == 'R') {
                while(end.charAt(t) != 'R') t++;
                if(t < i) return false;
                t++;
            }
        }

        return true;
    }
}