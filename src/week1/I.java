package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class I {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[1000 + 9];
        /*
        pop_back : remove the last number in the array
        front : print the first element in the array
        back : print the last element in the array
        sort l r : where (1≤l,r≤|week1.A|) sort all elements of week1.A fron l to r.
        reverse l r : where (1≤l,r≤|week1.A|) reverse all elements of week1.A fron l to r.
        print pos : where (1≤pos≤|week1.A|) print the element in the index pos
        push_back x : where (1≤x≤109) add x in the end of the array.
         */
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int index = n - 1;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            if (s.equals("pop_back")) {
                index--;
            } else if (s.equals("front")) {
                out.append(arr[0]).append('\n');
            } else if (s.equals("back")) {
                out.append(arr[index]).append('\n');
            } else if (s.equals("sort")) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int[] sort = new int[r - l + 1];
                for (int k = 0, j = l - 1; j < r; j++, k++) {
                    sort[k] = arr[j];
                }
                Arrays.sort(sort);
                for (int k = 0, j = l - 1; j < r; j++, k++) {
                    arr[j] = sort[k];
                }
            } else if (s.equals("reverse")) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                for (int j = l - 1, k = r - 1; j < k; j++, k--) {
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            } else if (s.equals("print")) {
                int pos = scanner.nextInt();
                out.append(arr[--pos]).append('\n');
            } else {
                int x = scanner.nextInt();
                arr[++index] = x;
            }
        }
        System.out.println(out);
    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
