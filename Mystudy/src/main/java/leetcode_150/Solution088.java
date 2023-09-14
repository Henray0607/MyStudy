package leetcode_150;

import java.util.Arrays;

public class Solution088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int m1 = m - 1;
        int n1 = n - 1;
        while (n1 >= 0) {
            if (m1 < 0 || nums1[m1] <= nums2[n1]) {
                nums1[tail--] = nums2[n1--];
            } else {
                nums1[tail--] = nums1[m1--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
