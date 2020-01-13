package leetcode;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        ReverseString_344 reverseString_344 = new ReverseString_344();
        reverseString_344.reverseString(s);
        System.out.println(s);
    }
}
