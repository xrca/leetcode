import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author xrca
 */
public class Question0003 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asjrgapa"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] charArr = s.toCharArray();
        int max = 0, curr = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < charArr.length; i++) {
            for (int j = i; j < charArr.length; j++) {
                if (set.add(charArr[j])) {
                    curr++;
                } else {
                    break;
                }
            }
            if (max < curr) {
                max = curr;
            }
            curr = 0;
            set.clear();
        }
        return max > curr ? max : curr;
    }
}