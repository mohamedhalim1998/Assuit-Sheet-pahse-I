package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[] s = scanner.next().toCharArray();
        Char[] arr = new Char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Char(i, s[i]);
        }
        Arrays.sort(arr);
        HashSet<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < k; i++) {
            toRemove.add(arr[i].i);
        }
        for (int i = 0; i < n; i++) {
            if(!toRemove.contains(i)){
                System.out.print(s[i]);
            }
        }

    }

    private static class Char implements Comparable<Char> {
        int i;
        char c;

        public Char(int i, char c) {
            this.i = i;
            this.c = c;
        }

        @Override
        public int compareTo(Char a) {
            return Character.compare(c, a.c);
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