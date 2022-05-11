package com.xrca.leetcode.contest.weekly.no242;

public class Q3 {

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.canReach("01101110", 2, 3));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.endsWith("1")) {
            return false;
        }
        return this.nextJump(s, 0, minJump, maxJump);
    }

    private boolean nextJump(String s, int nowIndex, int minJump, int maxJump) {
        int step = minJump + nowIndex;
        boolean result = false;
        for ( ; step <= maxJump + nowIndex && step < s.length(); step++) {
            if (s.charAt(step) == '0') {
                if (step == s.length() - 1) {
                    return true;
                }
                result = this.nextJump(s, step, minJump, maxJump);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
