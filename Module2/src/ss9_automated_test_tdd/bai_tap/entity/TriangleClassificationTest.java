package ss9_automated_test_tdd.bai_tap.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleClassificationTest {
    @Test
    @DisplayName("Test equilateral triangle")
    void testEquilateralTriangle() {
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "tam giác đều";
        String result = new TriangleClassification().classify(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test isosceles triangle")
    void testIsocelesTriangle() {
        int a = 2;
        int b = 2;
        int c = 3;
        String expected = "tam giác cân";
        String result = new TriangleClassification().classify(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test regular triangle")
    void testRegularTriangle() {
        int a = 3;
        int b = 4;
        int c = 5;
        String expected = "tam giác thường";
        String result = new TriangleClassification().classify(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test not a triangle")
    void testNotATriangle() {
        int[] a = {8,-1,0};
        int[] b = {2,2,1};
        int[] c = {3,1,1};
        String expected = "không phải là tam giác";
        String result1 = new TriangleClassification().classify(a[0], b[0], c[0]);
        String result2 = new TriangleClassification().classify(a[1], b[1], c[1]);
        String result3 = new TriangleClassification().classify(a[2], b[2], c[2]);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
    }

}