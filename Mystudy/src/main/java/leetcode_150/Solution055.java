package leetcode_150;

public class Solution055 {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int idx = nums.length - 1;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] >= idx - i) {
                idx = i;
            }
        }
        return idx <= 0;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
