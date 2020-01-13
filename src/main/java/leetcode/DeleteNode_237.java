package leetcode;

public class DeleteNode_237 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public void deleteNode(ListNode node) {
            while (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) {
                    node.next = null;
                } else {
                    node = node.next;
                }
            }
        }

        public static void main(String[] args) {
            ListNode node1 = new ListNode(4);
            ListNode node2 = new ListNode(5);
            ListNode node3 = new ListNode(1);
            ListNode node4 = new ListNode(9);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            LeetCodeUtils.printListNode(node1);

            node1.deleteNode(node2);
            LeetCodeUtils.printListNode(node1);
        }
    }
}
