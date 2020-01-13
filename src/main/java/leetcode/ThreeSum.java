package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> solution1(int[] arr) {
        if(arr == null || arr.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            if (arr[i] > 0) {
                return list;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = arr[left] + arr[i] + arr[right];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(arr[left]);
                    tmp.add(arr[i]);
                    tmp.add(arr[right]);
                    list.add(tmp);
                    while (left < right && arr[left] == arr[left + 1]) {left++;}
                    while (left < right && arr[right] == arr[right - 1]) {right--;}
                    left++;
                    right--;
                }else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum.solution1(arr);
        System.out.println(res.toString());
//        LeetCodeUtils.print2DArray(res);
    }
}
