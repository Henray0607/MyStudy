package review;

/**
 * LeetCode 581.最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class Code05_MinLengthForSort {
    public static int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int right = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }

        int min = Integer.MAX_VALUE;
        int left = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return Math.max(0, right - left + 1);
    }

    public static int findUnsortedSubarray1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < nums.length - 1 && nums[left + 1] >= nums[left]) {
            left++;
        }
        // 无须升序排序
        if (left == nums.length - 1) {
            return 0;
        }
        while (right > 0 && nums[right - 1] <= nums[right]) {
            right--;
        }
        // [0, l]递增，(l, r)无序，[r, n - 1]递增
        for (int i = left + 1; i < nums.length; i++) {
            while (left >= 0 && nums[left] > nums[i]) {
                left--;
            }
        }

        for (int i = right - 1; i >= 0; i--) {
            while (right < nums.length && nums[right] < nums[i]) {
                right++;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray1(nums));
    }

}
