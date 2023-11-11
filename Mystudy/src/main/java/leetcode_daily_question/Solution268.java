package leetcode_daily_question;

import java.util.Arrays;

public class Solution268 {
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int cur = 0;
        for (int i : nums) {
            cur += i;
        }
        return sum - cur;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber2(nums));
    }
}
