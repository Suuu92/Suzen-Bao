package com.suzen.module2;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(6);
        Circle c3 = new Circle(7.2);
        Circle c4 = new Circle(20.32);

        Triangle t1 = new Triangle(7,9);
        Triangle t2 = new Triangle(2.1,9.5);
        Triangle t3 = new Triangle(3,4,5);
        Triangle t4 = new Triangle(9,10,11);
        Triangle t5 = new Triangle(2.1,3.4,4.8);

        TwoDShape[] list = {c1, c2, c3, c4, t1, t2, t3, t4, t5};

        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
}
