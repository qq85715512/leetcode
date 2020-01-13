package leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeVisit {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Node cur = root;
        Stack<Node> stack = new Stack<Node>();
        while (cur != null && cur.children != null) {
            res.add(cur.val);
            int len = cur.children.size();
            for (int i = len - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
            cur = stack.isEmpty() ? null : stack.pop();
        }

        return res;
    }

    // TODO
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedBlockingQueue<Node>();
        Node cur = root;
        List<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(cur.val);
        res.add(tmp1);
        while (cur != null && cur.children != null) {
            if (cur.children != null) {
                List<Integer> tmp2 = new ArrayList<Integer>();
                for (Node node : cur.children) {
                    queue.add(node);
                    tmp2.add(node.val);
                }
                res.add(tmp2);
            }
            cur = queue.isEmpty() ? null : queue.poll();
        }
        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
