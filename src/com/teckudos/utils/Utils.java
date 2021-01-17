package com.teckudos.utils;

import java.util.Arrays;

public class Utils {

    public static int mod = (int) (1E9 + 7);

    protected static void singleLinePrint(Object obj) {
        System.out.print(obj);
    }

    protected static void print(Object obj) {
        System.out.println(obj);
    }

    protected static void printArray(int[] array) {
        System.out.println(Arrays.toString((array)));
    }

    protected static void printObjectArray(Object[] array) {
        System.out.println(Arrays.toString((array)));
    }

    protected static void printMultiArray(int[][] array) {
        System.out.println(Arrays.deepToString((array)));
    }
}
