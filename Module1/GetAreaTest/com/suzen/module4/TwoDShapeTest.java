package com.suzen.module4;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoDShapeTest {
    // Partition
    /*
    radius is positive
    radius is very small
    radius is very big
    radius has no decimal places
    radius has 1 decimal place
    radius has multiple decimal places
     */

    /**
     * Partitioned the inputs as follows:
     * requires radius -> positive
     * radius approx. = 0
     * radius approx. = infinity
     * radius -> integer
     * radius -> decimal number
     */

    @Test
    public void testCircleArea(){
        // radius = 0.0001
        // radius = 999999.99
        // radius = 367
        // radius = 23.6
        // radius = 4.97
        // radius = 60.472
        assertEquals(Math.pow(0.0001,2) * Math.PI, new Circle(0.0001, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.pow(999999.999,2) * Math.PI, new Circle(999999.999, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.pow(367,2) * Math.PI, new Circle(367, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.pow(23.6,2) * Math.PI, new Circle(23.6, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.pow(4.97,2) * Math.PI, new Circle(4.97, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.pow(60.472,2) * Math.PI, new Circle(60.472, Colour.NONE).getArea(), 1e-10);
    }

    // Partition
    /*
    Using width & height parameters:
    Requires width and height are positive
    width is very small
    width is very big
    height is very small
    width is very big
    width and height are both small
    width and height are both big

    Using 3 sides parameters:
    Requires sides are positive, the sum of the lengths of any two sides is always greater than the length of the third side
    side1 is very small
    side2 is very small
    side3 is very small
    side1 is very big
    side2 is very big
    side3 is very big
    two sides are small
    three sides are all small
    two sides are big
    three sides are all big
     */

    /**
     * Partitioned the inputs as follows:
     * requires width and height -> positive
     * width approx. = 0
     * width approx. = infinity
     * height approx. = 0
     * height approx. = infinity
     * width and height approx. = 0
     * width and height approx. = infinity
     *
     * requires side1, side2 and side3 -> positive, side1 + side2 > side3, side1 + side3 > side2, side2 + side3 > side1
     * side1 approx. = 0
     * side2 approx. = 0
     * side3 approx. = 0
     * side1 approx. = infinity
     * side2 approx. = infinity
     * side3 approx. = infinity
     * 2 of side1/2/3 approx. = 0
     * side1, side2 and side 3 approx. = 0
     * 2 of side1/2/3 approx. = infinity
     * side1, side2 and side 3 approx. = infinity
     */

    @Test
    public void testTriangleArea(){
        // width = 0.0001, height = 90.3
        // width = 999999.99, height = 207.82
        // height = 0.0001, width = 78.8
        // height = 999999.99, height = 43
        // width = 0.001, height = 0.0001
        // width = 9999, height = 9999
        assertEquals(0.5 * 0.0001 * 90.3, new Triangle(0.0001, 90.3, Colour.NONE).getArea(), 1e-10);
        assertEquals(0.5 * 999999.99 * 207.82, new Triangle(999999.99, 207.82, Colour.NONE).getArea(), 1e-10);
        assertEquals(0.5 * 78.8 * 0.0001, new Triangle(78.8, 0.0001, Colour.NONE).getArea(), 1e-10);
        assertEquals(0.5 * 43 * 999999.99, new Triangle(43, 999999.99, Colour.NONE).getArea(), 1e-10);
        assertEquals(0.5 * 0.001 * 0.0001, new Triangle(0.001, 0.0001, Colour.NONE).getArea(), 1e-10);
        assertEquals(0.5 * 9999 * 9999, new Triangle(9999, 9999, Colour.NONE).getArea(), 1e-10);

        // side1 = 0.01, side2 = 0.1, side3 = 0.1
        // side2 = 0.01, side1 = 0.1, side3 = 0.1
        // side3 = 0.01, side1 = 10, side2 = 10
        // side1 = 999, side2 = 900, side3 = 100
        // side2 = 999, side1 = 900, side3 = 100
        // side3 = 999, side1 = 900, side2 = 100
        // side1 = 0.01, side3 = 0.01, side2 = 0.019
        // side1 = 0.0001, side2 = 0.0001, side3 = 0.0001
        // side2 = 999, side3 = 999, side1 = 50
        // side1 = 900, side2 = 900, side3 = 900
        assertEquals(Math.sqrt(0.5*(0.01 + 0.1 + 0.1) * (-0.5*0.01+0.5*0.1+0.5*0.1) * (0.5*0.01-0.5*0.1+0.5*0.1) * (0.5*0.01+0.5*0.1-0.5*0.1)),
                new Triangle(0.01, 0.1, 0.1, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.sqrt((0.1 + 0.01 + 0.1)/2 * (-0.5*0.1+0.5*0.01+0.5*0.1) * (0.5*0.1-0.5*0.01+0.5*0.1) * (0.5*0.1+0.5*0.01-0.5*0.1)),
                new Triangle(0.1, 0.01, 0.1, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.sqrt((10 + 10 + 0.01)/2 * (-0.5*10+0.5*10+0.5*0.01) * (0.5*0.01) * (0.5*10+0.5*10-0.5*0.01)),
                new Triangle(10, 10, 0.01, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.sqrt((999 + 900 + 100)/2 * (-0.5*999+0.5*900+0.5*100) * (0.5*999-0.5*900+0.5*100) * (0.5*999+0.5*900-0.5*100)),
                new Triangle(999, 900, 100, Colour.NONE).getArea(), 2.00);
        assertEquals(Math.sqrt((900 + 999 + 100)/2 * (-0.5*900+0.5*999+0.5*100) * (0.5*900-0.5*999+0.5*100) * (0.5*900+0.5*999-0.5*100)),
                new Triangle(900, 999, 100, Colour.NONE).getArea(), 2.00);
        assertEquals(Math.sqrt((900 + 100 + 999)/2 * (-0.5*900+0.5*100+0.5*999) * (0.5*900-0.5*100+0.5*999) * (0.5*900+0.5*100-0.5*999)),
                new Triangle(900, 100, 999, Colour.NONE).getArea(), 2.00);
        assertEquals(Math.sqrt((0.01 + 0.019 + 0.01)/2 * (-0.5*0.01+0.5*0.019+0.5*0.01) * (0.5*0.01-0.5*0.019+0.5*0.01) * (0.5*0.01+0.5*0.019-0.5*0.01)),
                new Triangle(0.01, 0.019, 0.01, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.sqrt((0.0001 + 0.0001 + 0.0001)/2 * (-0.5*0.0001+0.5*0.0001+0.5*0.0001) * (0.5*0.0001) * (0.5*0.0001+0.5*0.0001-0.5*0.0001)),
                new Triangle(0.0001, 0.0001, 0.0001, Colour.NONE).getArea(), 1e-10);
        assertEquals(Math.sqrt((50 + 999 + 999)/2 * (-0.5*50+0.5*999+0.5*999) * (0.5*50-0.5*999+0.5*999) * (0.5*50+0.5*999-0.5*999)),
                new Triangle(50, 999, 999, Colour.NONE).getArea(), 2.00);
        assertEquals(Math.sqrt((900 + 900 + 900)/2 * (-0.5*900+0.5*900+0.5*900) * (0.5*900) * (0.5*900+0.5*900-0.5*900)),
                new Triangle(900, 900, 900, Colour.NONE).getArea(), 2.00);
    }
}