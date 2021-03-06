package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int q = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            switch (s) {
                case "push":
                    int x = scanner.nextInt();
                    queue.add(x);
                    break;
                case "pop":
                    queue.poll();
                    break;
                case "back":
                    out.append(queue.peekLast()).append('\n');
                    break;
                default:
                    out.append(queue.peekFirst()).append('\n');
            }
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