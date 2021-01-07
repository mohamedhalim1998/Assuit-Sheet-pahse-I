package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        char[] arr = new char[2000 + 9];
        String a = scanner.next();
        for (int i = 0; i < n; i++) {
            arr[i] = a.charAt(i);
        }
        int index = n - 1;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            switch (s) {
                case "pop_back":
                    if (index > 0)
                        index--;
                    break;
                case "front":
                    if (index >= 0)
                        out.append(arr[0]).append('\n');
                    break;
                case "back":
                    if (index >= 0)
                        out.append(arr[index]).append('\n');
                    break;
                case "sort": {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    char[] sort = new char[r - l + 1];
                    for (int k = 0, j = l - 1; j < r; j++, k++) {
                        sort[k] = arr[j];
                    }
                    Arrays.sort(sort);
                    for (int k = 0, j = l - 1; j < r; j++, k++) {
                        arr[j] = sort[k];
                    }
                    break;
                }
                case "reverse": {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    for (int j = l - 1, k = r - 1; j < k; j++, k--) {
                        char temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                    break;
                }
                case "print":
                    int pos = scanner.nextInt();
                    out.append(arr[--pos]).append('\n');
                    break;
                case "substr": {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    for (int j = l - 1; j < r; j++) {
                        out.append(arr[j]);
                    }
                    out.append('\n');
                    break;
                }
                case "push_back":
                    char x = scanner.next().charAt(0);
                    arr[++index] = x;
                    break;
            }
        }
        System.out.println(out);
//        StringBuilder builder = new StringBuilder(scanner.next());
//        StringBuilder out = new StringBuilder();
//        for(int i = 0 ;i < q; i++) {
//            String s = scanner.next();
//            switch (s) {
//                case "pop_back":
//                    builder.deleteCharAt(builder.length() - 1);
//                    break;
//                case "front":
//                    out.append(builder.charAt(0)).append('\n');
//                    break;
//                case "back":
//                    out.append(builder.charAt(builder.length() - 1)).append('\n');
//                    break;
//                case "sort": {
//                    int l = scanner.nextInt();
//                    int r = scanner.nextInt();
//                    char[] sub = builder.subSequence(l - 1, r).toString().toCharArray();
//                    Arrays.sort(sub);
//                    builder.replace(l - 1, r, String.valueOf(sub));
//                    break;
//                }
//                case "reverse": {
//                    int l = scanner.nextInt();
//                    int r = scanner.nextInt();
//                    builder.replace(l - 1, r, new StringBuilder(builder.subSequence(l - 1, r)).reverse().toString());
//                    break;
//                }
//                case "print":
//                    int pos = scanner.nextInt();
//                    out.append(builder.charAt(--pos)).append('\n');
//                    break;
//                case "substr":
//                    int l = scanner.nextInt();
//                    int r = scanner.nextInt();
//                    out.append(builder.subSequence(l-1,r)).append('\n');
//                    break;
//                default:
//                    String x = scanner.next();
//                    builder.append(x);
//                    break;
//            }
//        }
//        System.out.println(out);
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