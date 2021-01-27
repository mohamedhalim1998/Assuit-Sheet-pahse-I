package week1.standard;

import java.util.HashSet;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        for (int i = -m; i <= m; i++) {
            if(!set.contains(i)){
                System.out.println(i);
                break;
            }
        }

    }
}
