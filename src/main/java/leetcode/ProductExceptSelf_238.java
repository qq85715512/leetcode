package leetcode;

import java.util.ArrayList;

public class ProductExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int n = nums.length;
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
                continue;
            }
            product *= nums[i];
        }
        if (zeros.size() == 1) {
            int[] res = new int[n];
            res[zeros.get(0)] = product;
            return res;
        }
        if (zeros.size() > 1) {
            return new int[n];
        }
        int cur = nums[0];
        int next;
        nums[0] = product;
        for (int i = 1; i < n; i++) {
            next = nums[i];
            nums[i] = nums[i - 1] * cur / next;
            cur = next;
        }
        return nums;
    }

    public int[] productExceptSelf2(int[] nums) {
        int left = 1;
        int right = 1;
        int n = nums.length;
        int [] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int j = n - 1; j >=0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }
    public static void main(String[] args) {
        ProductExceptSelf_238 roductExceptSelf_238 = new ProductExceptSelf_238();
        int [] res = roductExceptSelf_238.productExceptSelf(LeetCodeUtils.intArr);
        LeetCodeUtils.printArray(res);
    }
}
