package week1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int[] arr = new int[26];
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
            Character c = (char) Math.min('a' + i, map.getOrDefault(x, 'z'));
            map.put(x, c);
        }
        ArrayList<Integer> nextList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                nextList.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (nextList.size() == 0) {
            System.out.println(0);
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                out.append('a');
            }
            System.out.println(out);
            return;
        }
        int nextIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (s.charAt(i) == '?') {
                ArrayList<Integer> list = new ArrayList<>();
                if (i == 0) {
                    char next = nextIndex < nextList.size() ? s.charAt(nextList.get(nextIndex)) : 'a';
                    c = map.get(arr[next - 'a']);
                } else if (i == s.length() - 1) {
                    char prev = builder.charAt(i - 1);
                    c = map.get(arr[prev - 'a']);
                } else {
                    char prev = builder.charAt(i - 1);
                    char next = nextIndex < nextList.size() ? s.charAt(nextList.get(nextIndex)) : prev;
                    int min = Math.min(arr[prev - 'a'], arr[next - 'a']);
                    int max = Math.max(arr[prev - 'a'], arr[next - 'a']);
                    c = prev;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] >= min && arr[j] <= max) {
                            c = (char) ('a' + j);
                            break;
                        }
                    }
                }
            }
            if (nextIndex < nextList.size() && i == nextList.get(nextIndex)) {
                nextIndex++;
            }

            builder.append(c);
        }
        long sum = 0;
        for (int i = 0; i < builder.length() - 1; i++) {
            char c1 = builder.charAt(i);
            char c2 = builder.charAt(i + 1);
            sum += Math.abs(arr[c1 - 'a'] - arr[c2 - 'a']);
        }
        System.out.println(sum);
        System.out.println(builder);

    }

    private static char findMin(int[] arr, ArrayList<Integer> x) {
        for (int i = 0; i < arr.length; i++) {
            if (x.contains(arr[i])) {
                return (char) ('a' + i);
            }
        }
        return 'z';
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