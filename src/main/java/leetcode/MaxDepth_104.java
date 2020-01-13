package leetcode;

import java.util.*;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res.size();
        }
        TreeNode cur;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                cur = queue.poll();
                integers.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(integers);
        }
        return  res.size();
    }


    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public static void main(String[] args) {
        MaxDepth_104 maxDepth_104 = new MaxDepth_104();
        TreeNode root = TreeNode.getInstance();
        System.out.println(maxDepth_104.maxDepth(root));
    }
}
