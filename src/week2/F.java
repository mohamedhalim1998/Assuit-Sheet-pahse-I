package week2;

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int q = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        /*
         * push_back x : where (1≤x≤109) add x at the end of the deque.
         * push_front x : where (1≤x≤109) add x at the begin of the deque.
         * pop_front : remove the first element in the deque.
         * pop_back : remove the last element in the deque.
         * front : print the first element in the deque.
         * back : print the last element in the deque.
         * print x : where (1≤x≤|dq|) print the element in index x of the deque.
         */
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            switch (s) {
                case "push_back":
                    int x = scanner.nextInt();
                    queue.add(x);
                    break;
                case "push_front":
                    x = scanner.nextInt();
                    queue.addFirst(x);
                    break;
                case "pop_back":
                    queue.removeLast();
                    break;
                case "pop_front":
                    queue.removeFirst();
                    break;
                case "print":
                    x = scanner.nextInt();
                    out.append(queue.get(x - 1)).append('\n');
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