package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long[] arr = scanner.nextArray(n);
        long sum = 0;
        HashMap<Long, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            set.put(arr[i], set.getOrDefault(arr[i], 0) + 1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            long remain = sum - arr[i];
            if ((remain % 2 == 0 && arr[i] != remain / 2 && set.containsKey(remain / 2))
                    || (remain % 2 == 0 && set.getOrDefault(remain / 2, 0) > 1)) {
                list.add(i + 1);
            }
        }
        System.out.println(list.size());
        for (int i : list) {
            System.out.print(i + " ");
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