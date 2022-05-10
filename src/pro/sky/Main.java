package pro.sky;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Task5();
        Task6();
        Task7();
        Task8();
        Task9();
    }

    public static void Task5() {
        int[][] a = createMatrixTask5(3);
        printMatrixTask5(a);
    }

    public static int[][] createMatrixTask5(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ((i != j) && ((i + j) != (size - 1))) ? 0 : 1;
            }
        }
        return matrix;
    }

    public static void printMatrixTask5(int[][] matrix) {
        for (int[] matrixLine : matrix) {
            for (int i : matrixLine) {
                System.out.print("\t" + i);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void Task6() {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[(arr1.length - 1) - i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println();
    }

    public static void Task7() {
        int[] arr3 = {5, 8, 2, 3, 9};
        System.out.println(Arrays.toString(arr3));
        int n = arr3.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            temp = arr3[n - i - 1];
            arr3[n - i - 1] = arr3[i];
            arr3[i] = temp;
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println();
    }

    public static void Task8() {
        //Method1
        int[] arrayForSum1 = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        ArrayList<Integer> tempList = findPairs1(arrayForSum1, -2);
        for (int i : tempList) {
            System.out.print(i + " ");
        }
        System.out.println();
        //Method2
        findPairs2(arrayForSum1, -2);
    }

    ////Method1 - ArrayList<Integer>
    public static ArrayList<Integer> findPairs1(int[] array, int sum) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if (array[i] + array[j] == sum) {
                tempList.add(array[i]);
                tempList.add(array[j]);
                break;
            }
            if (array[i] + array[j] > sum) {
                j--;
            }
            if (array[i] + array[j] < sum) {
                i++;
            }
        }
        return tempList;
    }

    //Method2 - O(nlog(n)) using Sort
    static void findPairs2(int[] a, int sum) {
        Arrays.sort(a);
        for (int i = 0; i < a.length / 2; i++) {
            int complement = sum - a[i];
            int foundAtIndex = Arrays.binarySearch(a, complement);
            if (foundAtIndex > 0 && foundAtIndex != i) { //to avoid situation where binarySearch would find the original and not the complement like "5"
                System.out.println(a[i] + ", " + (sum - a[i]));
            }
        }
    }

    public static void Task9() {
        int[] arrayForSum = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        findPairs3(arrayForSum, -2);
    }

    public static void findPairs3(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int s = array[first] + array[last];
            if (s == sum) {
                System.out.println(array[first] + " и " + array[last]);
                first++;
                last--;
            } else {
                if (s < sum) {
                    first++;
                } else {
                    last--;
                }
            }
        }
    }
}