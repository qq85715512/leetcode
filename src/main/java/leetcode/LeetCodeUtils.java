package leetcode;

public class LeetCodeUtils {
    public static int[] intArr = {1,2,3,4,0,0};


    public static void print2DArray(int[][] arr){
        for(int[] inner : arr) {
            for (int ele : inner) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }


    public static void printArray(int[] arr){
        for (int ele : arr) {
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    public static void printListNode(DeleteNode_237.ListNode node) {
        while(node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }



}
