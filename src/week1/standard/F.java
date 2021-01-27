package week1.standard;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] arr = nextArray(scanner, n);
        long[] alter = new long[n + 9];
        for (long i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            alter[l - 1] += x;
            alter[r] -= x;
        }
        for (int i = 0; i < alter.length - 1; i++) {
            alter[i + 1] += alter[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] += alter[i];
        }
        printArrayInLine(arr);
    }

    public static void printArrayInLine(long[] arr) {
        for (long value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static long[] nextArray(Scanner scanner, int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
