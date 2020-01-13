package leetcode;

import java.util.Stack;

public class ReverseWords_557 {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        if (s == null || s.equals("")) {
            return  "";
        }
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<Character>();
        for (char c : chars) {
            if (c == ' ') {
                while (!characters.isEmpty()) {
                    sb.append(characters.pop());
                }
                sb.append(c);
            } else {
                characters.push(c);
            }
        }
        while (!characters.isEmpty()) {
            sb.append(characters.pop());
        }
        return sb.toString();
    }


    public String reverseWords1(String s) {
        StringBuffer sb = new StringBuffer();
        if (s == null || s.equals("")) {
            return  "";
        }
        Stack<Character> characters = new Stack<Character>();
        String[] strings = s.split(" ");
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                characters.push(string.charAt(i));
            }
            while (!characters.isEmpty()) {
                sb.append(characters.pop());
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        ReverseWords_557 reverseWords_557 = new ReverseWords_557();
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords_557.reverseWords(s));
        System.out.println(reverseWords_557.reverseWords1(s));
    }
}
