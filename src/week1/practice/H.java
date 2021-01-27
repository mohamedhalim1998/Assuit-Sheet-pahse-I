package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(intervals);
        StringBuilder out = new StringBuilder();
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < n; i++) {
            Interval c = stack.peek();
            if (c.r < intervals[i].l) {
                stack.push(intervals[i]);
            } else if (c.r < intervals[i].r) {
                c.r = intervals[i].r;
                stack.pop();
                stack.push(c);
            }
        }
        for (Interval i : stack) {
            out.append(i.l).append(" ").append(i.r).append('\n');
        }
        System.out.println(out);
    }

    private static class Interval implements Comparable<Interval> {
        int l, r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Interval interval) {
            return Integer.compare(l, interval.l);
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