package com.suzen.module4;

public class Main {
    public static void main(String[] args) {
        // Create 2 sorted arrays A & B
        int[] arrA = {27, 24, 23, 15, 10, 8};
        int[] arrB = {84, 81, 35, 25, 14, 11, 8, 5, 2};

        Sorter.mergeArray(arrA, arrB);
    }
}
