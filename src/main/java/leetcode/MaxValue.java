package leetcode;

public class MaxValue {
    public int getMaxValue(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int length = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = i > max ? i : max;
        }
        int tmp = 0;
        for(int i = 0; i < length; i++) {
            tmp += arr[i];
            if(tmp < 0) {
                tmp = 0;
            } else{
                max = tmp > max ? tmp :max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        int[] arr = {-1,11,10,-10,3,4,-1,4};
        System.out.println(maxValue.getMaxValue(arr));
    }
}
