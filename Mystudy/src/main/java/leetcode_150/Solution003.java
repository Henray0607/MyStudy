package leetcode_150;

import java.util.HashMap;
import java.util.Map;

public class Solution003 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
