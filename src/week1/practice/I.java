package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] stones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stones[i + 1] = scanner.nextInt();
        }
        int[] sortedStones = Arrays.copyOf(stones, n + 1);
        Arrays.sort(sortedStones);
        long[] sortedSums = new long[n + 1];
        long[] sums = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + stones[i];
            sortedSums[i] = sortedSums[i - 1] + sortedStones[i];
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (type == 1) {
                System.out.println(sums[r] - sums[l - 1]);
            } else {
                System.out.println(sortedSums[r] - sortedSums[l - 1]);

            }
        }
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

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