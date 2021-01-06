package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Grade[] grades = new Grade[n];
        for (int i = 0; i < n; i++) {
            grades[i] = new Grade(scanner.next(), new int[]{
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt()

            });
        }
        Arrays.sort(grades);
        for(Grade g : grades){
            System.out.println(g);
        }
    }

    static class Grade implements Comparable<Grade> {
        String name;
        int[] grades = new int[4];
        int total;

        public Grade(String name, int[] grades) {
            this.name = name;
            this.grades = grades;
            this.total = 0;
            for (int i : grades) {
                total += i;
            }
        }

        @Override
        public int compareTo(Grade grade) {
            if (total != grade.total) {
                return Integer.compare(grade.total, total);
            } else {
                return name.compareTo(grade.name);
            }
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(name).append(' ').append(total).append(' ');
            for (int value : grades) {
                s.append(value).append(" ");
            }
            return s.toString();
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