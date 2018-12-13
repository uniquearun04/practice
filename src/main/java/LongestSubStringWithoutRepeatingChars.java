import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by achaudhary on 6/8/18.
 */
public class LongestSubStringWithoutRepeatingChars {

    public static void main(String ...args) {

        String str = "asljlj";
        LongestSubStringWithoutRepeatingChars longestSubStringWithoutRepeatingChars = new LongestSubStringWithoutRepeatingChars();

        int len = longestSubStringWithoutRepeatingChars.lengthOfLongestSubstring(str);
        System.out.println("Longest substring len: "+ len);
    }

    public int lengthOfLongestSubstring(String s) {

        int len = 0;
        int maxLen = 0;

        HashMap<Character, Integer> characterIndexMap = new HashMap<Character, Integer>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(characterIndexMap.containsKey(c)) {
                if(sb.length() > maxLen) {
                    maxLen = sb.length();
                }
                sb.delete(0, characterIndexMap.get(c) + 1);
                characterIndexMap.clear();
                for (int j = 0; j < sb.length(); j++) {
                    characterIndexMap.put(sb.charAt(j), j);
                }
            }
            sb.append(c);
            len = sb.length();
            characterIndexMap.put(c, len - 1);
        }
        if(len > maxLen) {
            maxLen = len;
        }
        System.out.println(sb.toString());
        return maxLen;
    }
}
