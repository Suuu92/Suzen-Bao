package com.suzen.module4;

public class Sorter {
    public static void mergeArray (int[] arrA, int[] arrB) {
        // Create the merged array C
        int[] arrC = new int [arrA.length + arrB.length];

        // Use 3 integers to track the index position for each array separately
        int i = 0;
        int j = 0;
        int k = 0;

        while ( i < arrA.length && j < arrB.length) {
            if (arrA[i] >= arrB[j]) {
                // arrA has a bigger number, add that number into arrC
                // The index of arrA increases by 1 so that the next number of arrA can be compared for next round
                arrC[k] = arrA[i];
                i++;
            }
            else {
                // arrB has a bigger number, add that number into arrC
                // The index of arrB increases by 1 so that the next number of arrB can be compared for next round
                arrC[k] = arrB[j];
                j++;
            }
            // The index of arrC increases by 1 for each round
            k++;
        }

        // After adding all numbers of one array, just add the rest of the other array's numbers to arrC
        while (i < arrA.length) {
            arrC[k] = arrA[i];
            i++;
            k++;
        }
        while (j < arrB.length) {
            arrC[k] = arrB[j];
            j++;
            k++;
        }

        // Print out the merged arrC
        for (int c = 0; c < arrC.length; c++) {
            System.out.println(arrC[c]);
        }
    }
}
