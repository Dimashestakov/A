package main.java;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        System.out.println(isSumInRange(5, 6));

        // Задача 2
        printNumberType(-7);
        printNumberType(0);
        printNumberType(42);

        // Задача 3
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
        System.out.println(isNegative(7));

        // Задача 4
        printStringNTimes("Hello", 3);
        printStringNTimes("Java", 5);

        // Задача 5
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2021));
        System.out.println(isLeapYear(2000));

        // Задача 6
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        swapZerosAndOnes(binaryArray);

        // Задача 7
        int[] filledArray = fillArrayWithNumbers(100);

        // Задача 8
        int[] arrayToMultiply = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyElementsByCondition(arrayToMultiply, 6);

        // Задача 9
        int[][] squareArray = createAndFillSquareArray(5);

        // Задача 10
        int[] initializedArray = createInitializedArray(10, 42);
    }

    // Задача 1
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задача 2
    public static void printNumberType(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    // Задача 3
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // Задача 4
    public static void printStringNTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    // Задача 5
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Задача 6
    public static void swapZerosAndOnes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    // Задача 7
    public static int[] fillArrayWithNumbers(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Задача 8
    public static void multiplyElementsByCondition(int[] array, int condition) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < condition) {
                array[i] *= 2;
            }
        }
    }

    // Задача 9
    public static int[][] createAndFillSquareArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
        }
        return array;
    }

    // Задача 10
    public static int[] createInitializedArray(int length, int initialValue) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
