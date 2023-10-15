package leetcode_weeklyCompetition;

import java.util.*;

/**
 * LeetCode:第 367 场周赛 100084. 最短且字典序最小的美丽子字符串
 * 给你一个二进制字符串 s 和一个正整数 k 。如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * 令 len 等于 最短 美丽子字符串的长度。返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c
 */
public class Solution100084 {
    public static String shortestBeautifulSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                num++;
            }
            if (num < k) {
                return "";
            }
        }

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if (ss.length() >= k) {
                    list.add(ss);
                }
            }
        }
        System.out.println(list);

        for (String str : list) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    count++;
                }
            }
            if (count == k) {
                map.put(str, str.length());
            }
        }
        System.out.println(map);

        int minLen = s.length();
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (minLen > val) {
                minLen = val;
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (minLen == map.get(key)) {
                result.add(key);
            }
        }
        System.out.println(result);

        String minStr = result.get(0);
        for (String temp : result) {
            if (minStr.compareTo(temp) > 0) {
                minStr = temp;
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        String s1 = "001110101101101111";
        int k1 = 14;
        System.out.println(shortestBeautifulSubstring(s1, k1));

        String s2 = "100011001";
        int k2 = 3;
        System.out.println(shortestBeautifulSubstring(s2, k2));

        String s3 = "000";
        int k3 = 1;
        System.out.println(shortestBeautifulSubstring(s3, k3));

        String s4 = "10100010";
        int k4 = 5;
        System.out.println(shortestBeautifulSubstring(s4, k4));
    }
}
