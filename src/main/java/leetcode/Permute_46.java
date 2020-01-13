package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<Integer>();
        dfs(nums, len, 0,used, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if (len == depth) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth + 1, used, path, res);
                used[i] = false;
                path.remove(depth);
            }
        }
    }

    public static void main(String[] args) {
        Permute_46 permute_46 = new Permute_46();
        int[] arr = {1, 2, 3};
        System.out.println(permute_46.permute(arr));
    }
}
