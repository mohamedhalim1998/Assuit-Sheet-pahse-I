package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class O {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int[] freq = new int[100009];
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            freq[scanner.nextInt()]++;
        }
        StringBuilder out = new StringBuilder();
        int max = 100009;
        int min = 0;
        int end = max;
        int start = -1;
        while (n > 0) {
            for (int i = min; i < max; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    out.append(i).append(' ');
                    n--;
                    if (freq[i] > 0) {
                        end = i + 1;
                        if (start == -1) {
                            start = i;
                        }
                    }
                }
            }
            out.append('\n');
            min = Math.max(start, 0);
            start = -1;
            max = end;
            end = 100009;

        }
        System.out.println(out);
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