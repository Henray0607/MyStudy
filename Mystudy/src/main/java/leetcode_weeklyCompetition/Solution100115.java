package leetcode_weeklyCompetition;

/**
 * 第 370 场周赛: 100115. 找到冠军 I
 *
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。
 * 对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队强 ；否则，j 队比 i 队强 。
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军，返回这场比赛中将会成为冠军的队伍。
 *
 * 【分析】i 击败 j 当且仅当 grid[i][j] == 1，要找到一个 i，使得第 i 行所有除 i 位置外的所有数应当均为 1，因此这些数的和为 n−1
 */
public class Solution100115 {
    public static int findChampion(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            int cnt = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (i != j && grid[i][j] == 1) {
                    cnt += 1;
                }
            }
            if (cnt == grid.length - 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {0, 0}};
        System.out.println(findChampion(grid));
        int[][] grid2 = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(findChampion(grid2));
        int[][] grid3 = {{0, 0, 0}, {1, 0, 1}, {1, 0, 0}};
        System.out.println(findChampion(grid3));
    }
}
