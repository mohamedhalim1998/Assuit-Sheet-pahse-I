package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class U {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(scanner.nextInt(), i);
        }
        Arrays.sort(arr);
        int[] nums = new int[k];
        int sum = 0;
        if(k == 1){
            System.out.println(arr[0].x);
            System.out.println(n);
            return;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i].i;
            sum += arr[i].x;
        }
        Arrays.sort(nums);
        StringBuilder out = new StringBuilder();
        out.append(sum).append('\n');
        out.append(nums[1]).append(' ');
        for (int i = 2; i < k; i++) {
            out.append(nums[i] - nums[i - 1]).append(' ');
        }
        out.append(n - nums[k-1]);
        System.out.println(out);
    }

    static private class Item implements Comparable<Item> {
        int x, i;

        public Item(int x, int i) {
            this.x = x;
            this.i = i;
        }

        @Override
        public int compareTo(Item item) {
            return Integer.compare(item.x, x);
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