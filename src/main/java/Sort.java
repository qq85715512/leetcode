import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {5, 1, 2, 4, 6};

//        sort.quickSort(arr, 0, 5);
//        sort.mergeSort(arr, 0, 5);
//        sort.mergeSortIteration(arr);
//        print(arr);
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
//        sort.layerVisit(treeNode);
        sort.deepVisit(treeNode);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
    }

    public void layerVisit(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        TreeNode cur = treeNode;
        Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        while(cur != null) {
            System.out.println(cur.val);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            cur = queue.poll();
        }
    }

    public void deepVisit(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        TreeNode cur = treeNode;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null) {
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            cur = stack.isEmpty()? null : stack.pop();
        }
    }

    public void mergeSortIteration(int[] arr) {
        int k = 1;
        int size = arr.length;
        while (k < size) {
            splitSort(arr, k, size);
            k *= 2;
        }
    }

    private void splitSort(int[] arr, int interval, int size) {
        int i = 0;
        int low;
        int mid;
        int high;
        while(i < size - 2 * interval + 1) {
            low = i;
//            mid = i + interval - 1;
            high = i + 2 * interval - 1;
            mid = (low + high) / 2;
            merge(arr, low, mid, high);
            i += 2 * interval;
        }
        if(i < size - interval) {
            low = i;
            mid = i + interval - 1;
            high = size - 1;
            merge(arr, low, mid, high);
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int idx = 0;
        while (left <= mid && right <= high) {
            tmp[idx++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            tmp[idx++] = arr[left++];
        }
        while (right <= high) {
            tmp[idx++] = arr[right++];
        }
        for(int i = 0; i < tmp.length; i++){
            arr[low + i] = tmp[i];
        }
    }


    /**
     * 快排
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = getPivot(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int getPivot(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low< high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static int cal(int[] arr) {
        int sum = 0;
        int len = arr.length;

        for(int i = 0; i < len; i++) {
            int j = i + 1;
            for(; j < len; j ++) {
                if(arr[j] >= arr[i]) {
                    break;
                }
            }
            if (j >= len) {
                continue;
            }
            int min_num = Math.min(arr[i], arr[j]);
            int sum_tmp = 0;
            for (int k = i; k < j; k++) {
                sum_tmp += min_num - arr[k];
            }
            sum += sum_tmp;
            i = j - 1;
        }
        return sum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int middle = (l1 + l2) / 2;
        int flag = (l1 + l2) % 2;

        int[] arr = new int[l1 + l2];

        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        while(idx1 < l1 && idx2 < l2) {
            arr[i++] = nums1[idx1] < nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
        }
        while (idx1 < l1) {
            arr[i++] = nums1[idx1++];
        }
        while (idx2 < l2) {
            arr[i++] = nums2[idx2++];
        }
        double rst = 0;
        if (flag == 0) {
            rst = (arr[middle -1 ] + arr[middle]) / 2.0;
        } else {
            rst = arr[middle];
        }

        return rst;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int low = 0;
        int high = 0;
        int max = 0;
        for (int i = 0; i < len; i ++) {
            int tmp = 1;
            int il = i - 1;
            int ir = i + 1;
            while(il >= 0 && ir < len) {
                if(s.charAt(il) == s.charAt(ir)) {
                    tmp += 2;
                    il --;
                    ir ++;
                } else {
                    break;
                }
            }
            if (tmp > max) {
                max = tmp;
                low = il + 1;
                high = ir;
            } else {
                continue;
            }
        }

        for (int i = 0; i < len - 1; i ++) {
            if(s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            int tmp = 2;
            int il = i - 1;
            int ir = i + 2;
            while(il >= 0 && ir < len) {
                if(s.charAt(il) == s.charAt(ir)) {
                    tmp += 2;
                    il --;
                    ir ++;
                } else {
                    break;
                }
            }
            if (tmp > max) {
                max = tmp;
                low = il + 1;
                high = ir;
            } else {
                continue;
            }
        }
        return s.substring(low, high);
    }


}
