package test;

import lab1.Variant9;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.annotations.AfterTest;
import java.io.IOException;
import java.util.*;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;



import java.io.Serializable;




public class TestVariant9 {

    ///////////////////////////////////////////////////////////////////////////////////////////
    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2, long p3) {
        assertEquals(new Variant9().forTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{5, 7, 110}, {7, 10, 294}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negForTest() {
        new Variant9().forTask(5, 3);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant9().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{5, 7, true}, {2, 10, false}};
    }
/////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int p2) {
        assertEquals(new Variant9().integerTask(p1), p2);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{954, 9}, {425, 4}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negIntegerTest() {
        new Variant9().integerTask(85);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(dataProvider = "minmaxProvider")
    public void minmaxTest(int p1, int[] p2, Variant9.Pair<Integer> p) {
        assertEquals(new Variant9().minmaxTask(p1, p2), p);
    }

    @DataProvider
    public Object[][] minmaxProvider() {
        Variant9.Pair pair1 = new Variant9.Pair(1, 3);
        Variant9.Pair pair2 = new Variant9.Pair(0, 3);
        return new Object[][]{{4, new int[]{1, 3, 1, 3}, pair1}, {4, new int[]{2, 0, 1, 2}, pair2}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negMinmaxTest() {
        new Variant9().minmaxTask(3, new int[]{1, 2, 3, 4, 5, 6});
    }


/////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p2) {
        assertEquals(new Variant9().whileTask(p1), p2);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{5, 2}, {54, 4}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negWhileTest() {
        new Variant9().whileTask(1);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] p1, int p2, Variant9.Massiv p) {
        Variant9.Massiv pair = new Variant9().arrayTask(p1, p2);
        assertArrayEquals(pair.array, p.array);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        Variant9.Massiv pair1 = new Variant9.Massiv(new int[]{2, 8, 4, 4, 2, 2}, 7);
        Variant9.Massiv pair2 = new Variant9.Massiv(new int[]{4, 8, 6, 6, 4, 4}, 7);
        return new Object[][]{{new int[]{1, 2, 2, 3, 1, 4, 5, 4, 8, 1, 2}, 11, pair1}, {new int[]{1, 4, 4, 3, 1, 6, 5, 6, 8, 1, 4}, 11, pair2}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negArrayTest() {
        new Variant9().minmaxTask(1, new int[]{1, 2, 3, 4, 5, 6});
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(double p1, double p2, Variant9.IfClass p) {
        assertEquals(new Variant9().ifTask(p1, p2), p);
    }

    @DataProvider
    public Object[][] ifProvider() {
        Variant9.IfClass pair1 = new Variant9.IfClass(2.4, 5.3);
        Variant9.IfClass pair2 = new Variant9.IfClass(4.1, 54.5);
        Variant9.IfClass pair3 = new Variant9.IfClass(3.3, 8.2);
        Variant9.IfClass pair4 = new Variant9.IfClass(1.1, 2.2);
        return new Object[][]{{5.3, 2.4, pair1}, {54.5, 4.1, pair2}, {8.2, 3.3, pair3}, {1.1, 2.2, pair4}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negIfTest() {
        new Variant9().ifTask(5, 5);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(dataProvider = "caseProvider")
    public void caseTest(int p1, int p2, Variant9.Pair p) {
        assertEquals(new Variant9().caseTask(p1, p2), p);
    }

    @DataProvider
    public Object[][] caseProvider() {
        Variant9.Pair pair1 = new Variant9.Pair(1, 10);
        Variant9.Pair pair2 = new Variant9.Pair(24, 5);
        return new Object[][]{{31, 9, pair1}, {23, 5, pair2}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negCaseTest() {
        new Variant9().caseTask(35, 12);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////
    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int [][] m,  Variant9.Array p) {
        Variant9.Array pair = new Variant9().matrixTask(m);
        assertArrayEquals(pair.mas, p.mas);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        Variant9.Array pair1 = new Variant9.Array(new int[][] { {67, 60, 31, 29, 64}, {23, 45, 25, 51, 68}, {63, 62, 76, 76, 51} }, 3);
        return new Object[][]{ {new int[][]{{67, 60, 31, 29, 64}, {44, 75, 26, 56, 80}, {23, 45, 25, 51, 68}, {67, 21, 34, 21, 73}, {63, 62, 76, 76, 51}}, pair1} };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negMatrixTest() {
        new Variant9().matrixTask(new int[][]{{1}});
    }


}