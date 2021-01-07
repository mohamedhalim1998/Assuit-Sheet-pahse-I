package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        Arrays.sort(arr);
        /*
         * lower_bound x : mean find first element greater than or equal x, if not found print -1.
         * upper_bound x : mean find first element greater than x, if not found print -1.
         * binary_search x : mean find x in the array or not.if x in array print "found" otherwise print "not found".
         */
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            switch (s) {
                case "lower_bound": {
                    int x = scanner.nextInt();
                    int a = greater(arr, --x);
                    if (a == -1)
                        out.append("-1").append('\n');
                    else
                        out.append(arr[a]).append('\n');
                }
                break;
                case "upper_bound": {
                    int x = scanner.nextInt();
                    int a = greater(arr, x);
                    if (a == -1)
                        out.append("-1").append('\n');
                    else
                        out.append(arr[a]).append('\n');
                }
                break;

                case "binary_search": {
                    int x = scanner.nextInt();
                    int a = binarySearch(arr, x);
                    if (a == -1) {
                        out.append("not found\n");
                    } else {
                        out.append("found\n");
                    }
                }
                break;
            }
        }
        System.out.println(out);

    }


    static int greater(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
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