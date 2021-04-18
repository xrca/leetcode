package com.xrca.geektime.week6;

import java.util.LinkedList;
import java.util.List;

// 动物收容所 https://leetcode-cn.com/problems/animal-shelter-lcci/
public class Q2 {

    public static void main(String[] args) {

    }
}


class AnimalShelf {
    private List<int[]> animals;

    public AnimalShelf() {
        animals = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        animals.add(animal);
    }

    public int[] dequeueAny() {
        if (animals.size() == 0) {
            return new int[]{-1, -1};
        }
        return animals.remove(0);
    }

    public int[] dequeueDog() {
        return this.dequeueByType(1);
    }

    public int[] dequeueCat() {
        return this.dequeueByType(0);
    }

    private int[] dequeueByType(int type) {
        for (int i = 0; i < animals.size(); i++) {
            int[] animal = animals.get(i);
            if (animal[1] == type) {
                animals.remove(i);
                return animal;
            }
        }
        return new int[]{-1, -1};
    }
}