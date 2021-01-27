package week1.practice;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N {
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] pre = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int next = 1;

        for (int i = 0; i < n; i++) {
            while (set.contains(next) || arr[i] == next) {
                next++;
            }
            set.add(arr[i]);
            pre[i] = next;
        }
        int[] post = new int[n];
        set = new HashSet<>();
        next = 1;
        for (int i = n - 1; i >= 0; i--) {
            while (set.contains(next) || arr[i] == next) {
                next++;
            }
            set.add(arr[i]);
            post[i] = next;
        }
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int min = Math.min(pre[r - 1], post[l - 1]);
            out.append(min).append('\n');
        }
    }

    //FileReader("mex.in")
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("mex.in"));
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