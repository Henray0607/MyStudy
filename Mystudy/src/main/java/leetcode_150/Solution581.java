package leetcode_150;

public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 求左边有序序列的最右边界，右边有序序列的最左边界
        while (left < nums.length - 1 && nums[left + 1] >= nums[left]) {
            left++;
        }
        // 整体有序，无须升序排序
        if (left == nums.length - 1) {
            return 0;
        }
        while (right > 0 && nums[right - 1] <= nums[right]) {
            right--;
        }

        // [0, l]递增，(l, r)无序，[r, n - 1]递增

        // 左侧递增序列的每一个数都得小于等于右侧的序列
        for (int i = left + 1; i < nums.length; i++) {
            while (left >= 0 && nums[left] > nums[i]) {
                left--;
            }
        }

        // 右侧递增序列的每一个数都得大于等于左侧的序列
        for (int i = right - 1; i >= 0; i--) {
            while (right < nums.length && nums[right] < nums[i]) {
                right++;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 2};
        System.out.println(findUnsortedSubarray(nums));
    }
}
