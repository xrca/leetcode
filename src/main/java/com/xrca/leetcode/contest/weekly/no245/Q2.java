package com.xrca.leetcode.contest.weekly.no245;

import java.util.regex.Pattern;

public class Q2 {
    public static void main(String[] args) {
        /*

        "qobftgcueho"
"obue"
[5,3,0,6,4,9,10,7,2,8]

         */
        Q2 q = new Q2();
        System.out.println(q.maximumRemovals("qobftgcueho", "obue", new int[]{5,3,0,6,4,9,10,7,2,8}));
        //q.maximumRemovals("abcbddddd", "abcd", new int[]{3,2,1,4,5,6});

       // System.out.println(Pattern.matches(".*ab.*", "aabc"));
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        StringBuffer sb = new StringBuffer(s);
        StringBuffer pBuffer = new StringBuffer();
        pBuffer.append(".*");
        for (char c : p.toCharArray()) {
            pBuffer.append(c).append(".*?");
        }
        int index = 0;
        for ( ; index < removable.length; index++) {
            sb.deleteCharAt(removable[index]);
            if (!Pattern.matches(pBuffer.toString(), sb.toString())) {
                break;
            }
        }
        return index;
    }
}
