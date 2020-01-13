package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeMaxPath {
    private int max = Integer.MIN_VALUE;
    public List<List<TreeNode>> getMaxPath(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> path = new Stack<TreeNode>();
        addMaxPath(root, res, path);
        return res;
    }

    private void addMaxPath(TreeNode root, List<List<TreeNode>> res, Stack<TreeNode> path) {
        path.push(root);
        if (root.left == null && root.right == null) {
            int size = path.size();
            if (max < size) {
                res.clear();
                res.add(new ArrayList<TreeNode>(path));
                max = size;
            } else if (max == size) {
                res.add(new ArrayList<TreeNode>(path));
            }
            path.pop();
            return;
        }
        if (root.left != null) {
            addMaxPath(root.left, res, path);
        }
        if (root.right != null) {
            addMaxPath(root.right, res, path);
        }
        path.pop();
    }

    public static void main(String[] args) {
        TreeMaxPath treeMaxPath = new TreeMaxPath();
        List<List<TreeNode>> res = treeMaxPath.getMaxPath(TreeNode.getInstance());
        System.out.println(res);

    }
}
