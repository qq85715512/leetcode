package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        res.add(empty);
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> res_tmp = new ArrayList<List<Integer>>();
            for (List<Integer> e : res) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(e);
                tmp.add(nums[i]);
                res_tmp.add(tmp);
            }
            res.addAll(res_tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        System.out.println((subsets_78.subsets(new int[]{1,2,3})));
    }
}
