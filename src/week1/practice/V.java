package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = scanner.nextArray(n);
        Operation[] operations = new Operation[m];
        for (int i = 0; i < m; i++) {
            operations[i] = new Operation(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        long[] opCount = new long[m + 9];
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            opCount[x]++;
            opCount[y + 1]--;
        }
        for (int i = 1; i < m + 1; i++) {
            opCount[i] = opCount[i - 1] + opCount[i];
        }
        long[] sums = new long[n + 9];
        for (int i = 0; i < m; i++) {
            Operation o = operations[i];
            long count = opCount[i + 1];
            sums[o.l] += (count * o.d);
            sums[o.r + 1] -= (count * o.d);
        }
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + sums[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] += sums[i + 1];
        }
        StringBuilder out = new StringBuilder();
        for (long i : arr) {
            out.append(i).append(' ');
        }
        System.out.println(out);
    }

    static class Operation {
        int l;
        int r;
        int d;

        public Operation(int l, int r, int d) {
            this.l = l;
            this.r = r;
            this.d = d;
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

        long[] nextArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}