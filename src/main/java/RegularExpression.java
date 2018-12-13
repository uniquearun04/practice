import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by achaudhary on 6/11/18.
 */
public class RegularExpression {


    public static void main(String ...args) {

        String string = "aa";
        String pattern = "a";

        List<String> stringList = new ArrayList<String>();
        List<String> patternList = new ArrayList<String>();

//        stringList.add("aaa");patternList.add("a*a");
//        stringList.add("aa");patternList.add("a");
//        stringList.add("aa");patternList.add("a*");
//        stringList.add("ab");patternList.add(".*");
//        stringList.add("aab");patternList.add("c*a*b");
//        stringList.add("mississippi");patternList.add("mis*is*p*.");
//        stringList.add("mississippi");patternList.add("mis*is*ip*.");
//        stringList.add("aaa");patternList.add(".a");
        stringList.add("aaa");patternList.add("ab*a*c*a");

        RegularExpression regularExpression = new RegularExpression();

        for (int i = 0; i < stringList.size(); i++) {
            string = stringList.get(i);
            pattern = patternList.get(i);

            boolean matches = regularExpression.isMatch(string, pattern);
            System.out.println("string: "+ string+", pattern: "+pattern +", isMatch: "+matches);
        }


    }

    private static char PERIOD = '.';
    private static char STAR = '*';
    private static char QUESTION = '?';
    private static char PLUS = '+';

    private static Set<Character> specialCharSet = new HashSet<Character>();

    static {
        specialCharSet.add(PERIOD);
        specialCharSet.add(STAR);
        specialCharSet.add(QUESTION);
        specialCharSet.add(PLUS);
    }

    public boolean isMatch(String string, String pattern) {
        int stringIndex = string.length() - 1;
        int patternIndex = pattern.length() - 1;
        while(patternIndex >= 0 && stringIndex >= 0) {

            char pc = pattern.charAt(patternIndex);
            if(!specialCharSet.contains(pc)) {
                char sc = string.charAt(stringIndex);
                if(sc == pc) {
                    patternIndex--;
                    stringIndex--;
                    continue;
                } else {
                    return false;
                }
            } else {
                 if(pc == STAR) {
                     if(patternIndex - 1 >= 0) {
                         char ppc = pattern.charAt(patternIndex - 1);
                         if(ppc == PERIOD) {
                             while(stringIndex >= 0) {
                                 stringIndex--;
                             }
                         } else {
                             while (stringIndex >= 0) {
                                 char sc = string.charAt(stringIndex);
                                 if(ppc == sc) {
                                     stringIndex--;
                                 } else {
                                     break;
                                 }
                             }
                         }
                        patternIndex -= 2;
                     }
                 } else if(pc == PERIOD) {
                     stringIndex--;
                     patternIndex--;
                 }
            }
        }

        while(patternIndex >= 0) {
            char pc = pattern.charAt(patternIndex);
            if(pc == STAR) {
                if(patternIndex - 1 >= 0) {
                    char ppc = pattern.charAt(patternIndex -1);
                    if(!specialCharSet.contains(ppc)) {
                        patternIndex -= 2;
                        continue;
                    }
                    break;
                }
                break;
            }
            break;
        }
        String subStr = string.substring(0, stringIndex + 1);
        String patStr = pattern.substring(0, patternIndex + 1);
        if(subStr.equals(patStr)) {
            stringIndex -= subStr.length();
            patternIndex -= patStr.length();
        }

        return stringIndex == patternIndex;
    }
}
