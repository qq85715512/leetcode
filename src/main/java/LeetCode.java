import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode {

    /**
     * 暴力解法，遍历数组，从该元素向左边，找出左侧最大值
     * 从该元素向右边遍历，找出右侧最大值
     * （min(左侧最大值，右侧最大值) - 减去当前值）即该元素能装下的水量
     * 累积求和即可
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int size = height.length;
        int ans = 0;
        if(size == 0) {
            return ans;
        }
        for(int i = 1; i < size; i++) {
            int leftMax = 0, rightMax = 0;
            for(int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j = i; j < size; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    /**
     * 动态规划，构建数组用于存储每个元素对应的左侧或右侧的最大值，
     * 构建左侧最大值数组leftMax：从左向右遍历，若该元素大于左侧最大值leftMax[i-1]，则在leftMax中相应的位置插入该值否则插入旧的最大值leftMax[i-1]
     * 构建右侧最大值数组rightMax：从右向左遍历，若该元素大于右侧侧最大值rightMax[i+1]，则在rightMax中相应的位置插入该值否则插入旧的最大值rightMax[i+1]
     * 遍历数组，累积求和min(leftMax[i]), rightMax[i]) - 当前值
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        if(size == 0) {
            return ans;
        }
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for(int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i -1], height[i]);
        }
        for(int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for(int i = 0; i < size; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int ans = 0;
        int size = height.length;
        if(size == 0) {
            return ans;
        }
        int low = 0, high = size - 1;
        int leftMax = height[0];
        int rightMax = height[size - 1];
        while(low < high) {
            if(height[low] < height[high]) {
                if(height[low] > leftMax) {
                    leftMax = height[low];
                } else {
                    ans += leftMax - height[low];
                }
                low++;
            } else {
                if(height[high] > rightMax) {
                    rightMax = height[high];
                } else {
                    ans += rightMax - height[high];
                }
                high--;
            }
        }
        return ans;
    }

    public String convert(String s, int numRows) {
        String ans = null;
        if(s == null || "".equals(s)) {
            return s;
        }
        char[] arr = s.toCharArray();
        int size = arr.length;
        char[] tmp = new char[size];
        int start = 0;
        for(int i = 0; i < numRows; i++) {
            int idx = i;
            int cnt = 1;
            int x = 2 * numRows - (i + 1) * 2;
            int y = 2 * i;
            while(idx < size) {
                tmp[start++] = arr[idx];
                cnt++;
                int b = cnt % 2;
                if(i == 0){
                    idx += x;
                } else if (i == numRows - 1) {
                    idx += y;
                } else {
                    idx += b == 1 ? y : x;
                }
            }
        }
        ans = new String(tmp);
        return ans;
    }

    public int reverse(int x) {
        boolean flag = x < 0 ? true : false;
        String s = Integer.toString(x);
        s = flag ? s.substring(1) : s;
        char[] arr = s.toCharArray();
        int size = arr.length;
        int i = size - 1;
        for (; i >= 0; i--) {
            if(arr[i] != '0') {
                break;
            }
        }

        StringBuffer sb = new StringBuffer(flag ? "-" : "");
        for(int j = i; j >= 0; j--) {
            sb.append(arr[j]);
        }
        String rst = sb.toString();
        int ans;
        try {
            ans = Integer.parseInt(rst);
        } catch (Exception e) {
            ans = 0;
        }
        return ans;
    }


    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || "".equals(str)) {
            return 0;
        }
        int ans;
        int size = str.length();
        int m = 0;
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher;
        for(int i = 0; i < size; i++) {
            matcher = pattern.matcher(String.valueOf(str.charAt(i)));
            if(matcher.find()){
                m = i;
                break;
            } else if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                m = i;
                break;
            } else {
                return 0;
            }
        }
        int j = m + 1;
        for(;j < size; j++){
            matcher = pattern.matcher(String.valueOf(str.charAt(j)));
            if(!matcher.find()){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        if(m - 1 >= 0 && (str.charAt(m-1) == '+' || str.charAt(m-1) == '-')) {
            sb.append(str.charAt(m-1));
        }
        String tmp = str.substring(m, j);
        sb.append(tmp);
        String s = sb.toString();
        try{
            ans = Integer.parseInt(s);
        } catch (Exception e) {
            if("".equals(tmp) || "+".equals(tmp) || "-".equals(tmp)){
                ans = 0;
            }else if(s.charAt(0) == '-'){
                ans = Integer.MIN_VALUE;
            }else {
                ans = Integer.MAX_VALUE;
            }
        }
        return ans;
    }


    public boolean isPalindrome(int x) {
        boolean flag = true;
        String s = Integer.toString(x);
        int size = s.length();
        int low = 0;
        int high = size - 1;
        while(low <= high) {
            if(s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public int maxArea1(int[] height) {
        int size = height.length;
        int ans = 0;

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++) {
                int gap = j - i;
                ans = Math.max(Math.min(height[i], height[j]) * gap, ans);
            }
        }
        return ans;
    }

    public int maxArea2(int[] height) {
        int size = height.length;
        int ans = 0;

        int low = 0;
        int high = size - 1;
        int gap;
        while(low < high) {
            gap = high - low;
            ans = Math.max(ans, Math.min(height[low], height[high]) * gap);
            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }
        return ans;
    }


    public int[][] huixing(int [] arr, int m, int n) {
        int[][] ans = new int[m][n];
        int size = m * n;
        int colMax = n;
        int rowMax = m;
        int colMin = 0;
        int rowMin = 1;
        int col = 0, row = 0;
        int idx = 0;
        while(idx < size){
            while (col < colMax && idx < size) {
                ans[row][col++] = arr[idx++];
            }
            row++;
            col--;
            colMax--;
            while(row < rowMax && idx < size) {
                ans[row++][col] = arr[idx++];
            }
            row--;
            col--;
            rowMax--;
            while(col >= colMin && idx < size) {
                ans[row][col--] = arr[idx++];
            }
            row--;
            col++;
            colMin++;
            while(row >= rowMin && idx < size) {
                ans[row--][col] = arr[idx++];
            }
            row++;
            col++;
            rowMin++;
        }
        for (int [] a: ans) {
            for(int b : a) {
                System.out.print(b);
                System.out.print(" ");
            }
            System.out.println();
        }
        return ans;
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String ans;
        int size = strs.length;
        int idxOfMinLen = 0;
        int ansLen = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++) {
            if(strs[i].length() < ansLen) {
                ansLen = strs[i].length();
                idxOfMinLen = i;
            }
        }
        ans = strs[idxOfMinLen];
        String tmp;
        for(int i = 0; i < size; i++) {
            if(ans == ""){
                return ans;
            }
            tmp = strs[i];
            while(!tmp.startsWith(ans)){
                ans = ans.substring(0, ansLen--);
            }
        }
        return ans;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
            ans.add(stack.peek().val);
            cur = cur.right;
        }
        return ans;
    }
    static String arrow = " -> ";
    public void hanruo(String a, String b, String c, int num){

        if(num == 1) {
            System.out.println(a + arrow + c);
            return;
        }
        hanruo(a, c, b, num - 1);
        System.out.println(a + arrow + c);
        hanruo(b, a, c, num - 1);

    }
    public static void main(String[] args) {
        LeetCode lc = new LeetCode();
//        System.out.println(lc.convert("A" , 1));
//        System.out.println(lc.reverse(1111119999));

//        System.out.println(lc.myAtoi("words and 987"));
//        System.out.println(new StringBuffer().toString());
        int m = 5, n = 4;
        int [] arr = new int[m * n];
        for(int i = 0; i < m * n; i ++) {
            arr[i] = i + 1;
        }
//        lc.huixing(arr, m, n);
//        System.out.println(lc.longestCommonPrefix(new String[]{"123", "12", "1"}));
        lc.hanruo("A", "B", "C", 3);
    }

}
