package week1.standard;

import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (char c : alphabet.toUpperCase().toCharArray()) {
            if (map.containsKey(c)) {
                System.out.println(c + " " + map.get(c));
            }
        }
        for (char c : alphabet.toCharArray()) {
            if (map.containsKey(c)) {
                System.out.println(c + " " + map.get(c));
            }
        }

    }
}
