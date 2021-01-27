package week1.standard;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < q; i++) {
            int z = scanner.nextInt();
            int x = scanner.nextInt();
            if (z == 1) {
                arr[x]++;
            } else {
                System.out.println(arr[x]);
            }
        }
    }
}
