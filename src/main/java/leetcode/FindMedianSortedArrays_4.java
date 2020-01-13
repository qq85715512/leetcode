package leetcode;

public class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1 == null ? 0 : nums1.length;
        int j = nums2 == null ? 0 : nums2.length;
        int len = i + j;
        int[] tmp = new int[len];
        int m = 0, n = 0;
        int k = 0;
        while (nums1 != null && nums2 != null && m < i && n < j) {
            tmp[k++] = nums1[m] < nums2[n] ? nums1[m++] : nums2[n++];
        }
        while (nums1 != null && m < i) {
            tmp[k++] = nums1[m++];
        }
        while (nums2 != null && n < j) {
            tmp[k++] = nums2[n++];
        }
        return len % 2 == 0 ? (tmp[(len - 1) / 2] + tmp[len / 2]) / 2.0 : tmp[len / 2];
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2};
        int[] n2 = {2, 3};
        FindMedianSortedArrays_4 findMedianSortedArrays_4 = new FindMedianSortedArrays_4();
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(n1, n2));
    }
}
