package lab1;

import java.io.Serializable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class Variant9 {


    /**
     *
     * @param a first integer value
     * @param b second integer value
     * @return the sum of the squares of all integers from A to B inclusive
     */
    public int forTask(int a, int b){
        int r = 0;
        assert a < b: "B should be greater than A";

        if (a % 1 == 0 && b % 1 == 0 )
        for(int i = a; i<=b; i++){
            r += Math.pow(i, 2);
        }
        return r;
    }




    public static class IfClass{
        public double a;
        public double b;

        public IfClass(double a, double b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IfClass p = (IfClass) o;
            return a == p.a && b == p.b;
        }
    }

    /**
     *
     * @param a first floating point variable
     * @param b second floating point variable
     * @return Redistribute the values ​​of these variables so that the smaller of the values ​​is in A, and the larger in B.
     */
    public IfClass ifTask(double a, double b) {
        assert a != b : "Numbers are equal";
        if(a < b) {
            return new IfClass(a, b);
        }else{
            double c = a;
            a = b;
            b = c;
            return new IfClass(a, b);
        }
    }



    /**
     *
     * @param a integer number
     * @param b integer number
     * @return Check the truth of the statement: "At least one of the numbers A and B is odd."
     */
    public boolean booleanTask(int a, int b){
        if((a % 2) != 0 || (b % 2) != 0){
            return true;
        } else {
            return false;
        }
    }



    /**
     *
     * @param n three-digit number
     * @return Using one integer division operation, print the first digit of the given number (hundreds).
     */
    public int integerTask(int n){
        assert n > 99 && n < 999: "The number must contain three digits.";
        return n/100;
    }


    public static class Pair<T> {
        private  T a;
        private  T b;

        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }

        public T first() {
            return a;
        }
        public T second() {
            return b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return a == p.a && b == p.b;
        }


    }
    /**
     *
     * @param n integer number
     * @param mas a set of n integers.
     * @return the numbers of the first and last minimum element from the given set and print them in the specified order.
     */
    public Pair<Integer> minmaxTask(int n, int[] mas){
        assert n == mas.length: "n must be equal to the length of the array.";
        int maxIndex1 = 0, maxIndex2 = 0, max = 0;
        for(int i = 0; i < n; i++){
            if(max < mas[i]){
                max = mas[i];
                maxIndex1 = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(max == mas[i]){
                maxIndex2 = i;
            }
        }
        Pair rez = new Pair<Integer>(maxIndex1, maxIndex2);
        return rez;

    }



    /**
     *
     * @param n integer number
     * @return the smallest integer K for which the inequality 3^k > n holds.
     */
    public int whileTask(int n){
        assert n > 1 :"n must be greater than 1";
        int k = 0;
        while( n > Math.pow(3,k)) {
            k++;
        }
        return k;

    }


    public static class Massiv{
        public int[] array;
        public int k;

        public Massiv(int[] array, int k){
        this.array = array;
        this.k = k;
        }
        @Override
        public int hashCode() {
            return Objects.hash(array, k);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Massiv massiv = (Massiv) o;
            return k == massiv.k &&
                    Arrays.equals(array, massiv.array);
        }
        }

    /**
     *
     * @param mas an integer array of size n
     * @param n array size
     * @return
     */
    public Massiv arrayTask(int[] mas, int n){
        assert n > 1 :"n must be greater than 1";
        int[] array = new int[6];
        int k = 0;
        for (int i = n-1; i>=0;i--) {
            if (mas[i]%2==0) {
                array[k] = mas[i];
                k++;

            }
        }
        return new Massiv(array, k);

    }

    public static class Array {
        public int[][] mas;
        public int k;

        public Array(int [][] mas, int k) {
            this.mas = mas;
            this.k = k;
        }

        public int hashCode() {
            return Objects.hash(mas, k);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Array p = (Array) o;
            return mas == p.mas && k == p.k;
        }
    }

    /**
     *
     * @param m matrix
     * @return its elements, located in lines with even numbers (2, 4,…). Display elements line by line, do not use the conditional operator.
     */
    public static Array matrixTask(int[][] m) {
        assert m.length != 1: "Numbers must be integer.";
        int [][] b = new int [3][5];
        int i, j;
        int k = 0;
        for (i = 0; i < m.length; i += 2) {
            for (j = 0; j < m.length; j++) {
                b[k][j] = m[i][j];
            }
            k++;
        }
        return new Array(b, k);
    }

    /**
     *
     * @param d integer number
     * @param m integer number
     * @return the d and m values ​​for the date following the specified date.
     */
    public Pair<Integer> caseTask(int d, int m){
        assert d < 31 || m < 12: "Numbers must be integer.";
        d += 1;
        switch (m) {
            case 1, 3, 7, 5, 8, 10 : if (d > 31) {
                d = 1;
                m += 1;
                break;
            }
            case 4, 6, 9, 11 : if (d > 30) {
                d = 1;
                m += 1;
                break;
            }
            case 2 :if (d > 28) {
                d = 1;
                m += 1;
                break;
            }
            case 12 : if( d > 31) {
                d = 1;
                m = 1;
                break;
            }
        }
        return new Pair<Integer>(d, m);
     }

    public static void main(String[] args) {

        //for
        //System.out.println(new Variant9().forTask(5, 7));

        //if
        //IfClass pair = new Variant9().ifTask(5.3, 2.4);
        //System.out.println("a = " + pair.a);
        //System.out.println("b = " + pair.b);


        //boolean booleanTask
        //System.out.println(new Variant9().booleanTask(1,2));


        //integer
        //System.out.println(new Variant9().integerTask(746));

        //minmax
        //int n = 6;
        //int mas[] = {4, 2, 2, 3, 1, 4};
        //Pair<Integer> pair = new Variant9().minmaxTask(6, mas);
        //System.out.println("First -> " + pair.first());
        //System.out.println("Second -> " + pair.second());


        //while
        //System.out.println(new Variant9().whileTask(54));
        //

        //array
        //
/*
        int n = 11;
        int mas[] = {1, 2, 2, 3, 1, 4, 5, 4, 8, 1, 2};
        Massiv array = new Variant9().arrayTask(mas, n);
        mas = (int[]) array.array;
        n = (int) array.k;
        for (int i = 1; i <= n; i++) {
            System.out.println(mas[i]);
        }
        System.out.println();
        System.out.println(n);

*/

        //matrix
/*
        int[][] m = new int[][]{{67, 60, 31, 29, 64}, {44, 75, 26, 56, 80}, {23, 45, 25, 51, 68}, {67, 21, 34, 21, 73}, {63, 62, 76, 76, 51}};
        Array matrix = new Variant9().matrixTask(m);
        int [][] mas = (int[][]) matrix.mas;
        int n = (int) matrix.k;
        System.out.println();
        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println(n);

*/
        //case
        /*
        Pair<Integer> pair = new Variant9().caseTask(23, 5);
        System.out.println("Day -> " + pair.first());
        System.out.println("Month -> " + pair.second());
        */


    }


}



