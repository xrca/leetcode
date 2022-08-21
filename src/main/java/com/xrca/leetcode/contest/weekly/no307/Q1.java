package com.xrca.leetcode.contest.weekly.no307;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(minNumberOfHours(5, 3, new int[]{1,4,3,2}, new int[]{2,6,3,1}));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int length = energy.length;
        int needEnergy = initialEnergy;
        int needExperience = initialExperience;
        int hours = 0;
        for (int i = 0; i < length; i++) {
            if (needEnergy <= energy[i]) {
                int temp = energy[i] - needEnergy + 1;
                needEnergy = needEnergy + temp;
                hours = hours + temp;
            }
            needEnergy = needEnergy - energy[i];
            if (needExperience <= experience[i]) {
                int temp = experience[i] - needExperience + 1;
                needExperience = needExperience + temp;
                hours = hours + temp;
            }
            needExperience = needExperience + experience[i];
        }
        return hours;
    }
}
