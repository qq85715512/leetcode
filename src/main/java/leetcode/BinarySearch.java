package leetcode;

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        return recursion(arr, low, high, target);
    }

    private int recursion(int[] arr, int low, int high, int target) {
        int middle = (low + high) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (low >= high) {
            return -1;
        }
        return arr[middle] > target ? recursion(arr, low, middle - 1, target) : recursion(arr, middle + 1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,7,8,9,23,56,143};
        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.binarySearch(arr,  3));
    }
}
