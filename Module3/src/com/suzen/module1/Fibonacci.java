package com.suzen.module1;

public class Fibonacci {
    /**
     * Computer Fibonacci Sequence: 1, 1, 2, 3, 5, 8, 13, 21, ...
     * @param n the position of the desired number in the sequence; requires n > 0.
     * @return the nth number in the sequence.
     * Formula: F(n) = F(n-1) + F(n-2).
     *      For example, fibonacciNum(3) = 2, fibonacciNum(6) = 8.
     */
    public static int fibonacciNum(int n) {
        //base case
        if (n <= 2) {
            return 1;
        }
        //F(n) = F(n-1) + F(n-2)
        else {
            return fibonacciNum(n - 1) + fibonacciNum(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacciNum(6));
    }
}
