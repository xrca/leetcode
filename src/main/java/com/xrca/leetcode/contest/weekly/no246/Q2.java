package com.xrca.leetcode.contest.weekly.no246;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        //System.out.println(q2.numberOfRounds("12:01", "12:44"));
        //System.out.println(q2.numberOfRounds("00:00", "23:59"));
        //System.out.println(q2.numberOfRounds("20:00", "06:00"));
        //System.out.println(q2.numberOfRounds("00:01", "00:00"));
        System.out.println(q2.numberOfRounds("04:54", "18:51"));
        System.out.println(q2.numberOfRounds("23:46", "00:01"));
    }

    public int numberOfRounds(String startTime, String finishTime) {
        String[] startTimeArr = startTime.split(":");
        String[] finishTimeArr = finishTime.split(":");
        int startTimeHour = Integer.valueOf(startTimeArr[0]);
        int startTimeMinute = Integer.valueOf(startTimeArr[1]);
        int finishTimeHour = Integer.valueOf(finishTimeArr[0]);
        int finishTimeMinute = Integer.valueOf(finishTimeArr[1]);
        if (startTimeHour > finishTimeHour) {
            finishTimeHour = 24 + finishTimeHour;
        }
        if (startTimeHour == finishTimeHour && startTimeMinute >= finishTimeMinute) {
            finishTimeHour = 24 + finishTimeHour;
        }
        if (startTimeMinute % 15 != 0) {
            startTimeMinute = startTimeMinute + (15 - startTimeMinute % 15);
        }
        startTimeHour = startTimeHour + startTimeMinute / 60;
        startTimeMinute = startTimeMinute % 60;
        if (finishTimeMinute % 15 != 0) {
            finishTimeMinute = finishTimeMinute - finishTimeMinute % 15;
        }
        int hours = finishTimeHour - startTimeHour;
        int minutes = (finishTimeMinute - startTimeMinute + 60) % 60;
        if (finishTimeMinute < startTimeMinute) {
            hours--;
        }
        return hours * 4 + minutes / 15;
    }
}
