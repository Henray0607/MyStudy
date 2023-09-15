package greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class Solution452 {
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) {
                count++;
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 7, 10};
        int[] s = {1, 3, 5, 9};
        System.out.println(findContentChildren(g, s));
    }
}
