package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int[] leftSum = new int[s.length() + 1];
        int[] ceilSum = new int[s.length() + 1];
        int[] rightSum = new int[s.length() + 1];
        int i = 1;
        for (char c : s.toCharArray()) {
            rightSum[i] = rightSum[i - 1];
            leftSum[i] = leftSum[i - 1];
            ceilSum[i] = ceilSum[i - 1];

            switch (c) {
                case '\\':
                    rightSum[i]++;
                    break;
                case '/':
                    leftSum[i]++;
                    break;
                case '_':
                    ceilSum[i]++;
                    break;
            }
            i++;
        }
        int[] sums = new int[501];
        for (int j = 1; j <= 500; j++) {
            sums[j] = sums[j - 1] + j;
        }
        StringBuilder out = new StringBuilder();
        int q = scanner.nextInt();
        for (int j = 0; j < q; j++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int left = leftSum[r] - leftSum[l - 1];
            int right = rightSum[r] - rightSum[l - 1];
            int ceil = ceilSum[r] - ceilSum[l - 1];
            int min = Math.min(left, right);
            ceil = lessSearch(sums, ceil +1) + 1;
            min = lessSearch(sums, min + 1);
            min = Math.min(ceil, min);
            if (min != -1)
                out.append(min).append('\n');
            else
                out.append(0).append('\n');
        }
        System.out.println(out);
    }

    static int lessSearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
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