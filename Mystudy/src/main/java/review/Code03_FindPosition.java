package review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 美团面试题
 * 小团在地图上放了3个定位装置，想依赖他们进行定位!地图是一个n*n的棋盘，有3个定位装置(x1,y1),(x2,y2),(x3,y3)，每个值均在[1,n]内。
 * 小团在(a,b)位置放了一个信标,每个定位装置会告诉小团它到信标的曼哈顿距离，也就是对于每个点，小团知道|xi-a|+|yi-b|，求信标位置，信标不唯一，输出字典序最小的。
 * 输入n，然后是3个定位装置坐标，最后是3个定位装置到信标的曼哈顿记录。输出最小字典序的信标位置。
 * 1 <= 所有数据值 <= 50000
 */
public class Code03_FindPosition {
    public static int[] find(int n, int[] arrA, int[] arrB, int[] arrC, int aDistance, int bDistance, int cDistance) {
        int[] x1 = null;
        int r1 = Integer.MAX_VALUE;
        int[] x2 = null;
        int r2 = 0;
        int[] x3 = null;
        int r3 = 0;

        // 寻找圆心最小的点
        if (aDistance < r1) {
            x1 = arrA;
            r1 = aDistance;
            x2 = arrB;
            r2 = bDistance;
            x3 = arrC;
            r3 = cDistance;
        }
        if (bDistance < r1) {
            x1 = arrB;
            r1 = bDistance;
            x2 = arrA;
            r2 = aDistance;
            x3 = arrC;
            r3 = cDistance;
        }
        if (cDistance < r1) {
            x1 = arrC;
            r1 = cDistance;
            x2 = arrA;
            r2 = aDistance;
            x3 = arrB;
            r3 = bDistance;
        }

        // 最小：x1 r1     x2 r2; x3 r3
        int[] cur = {x1[0] - r1, x1[1]};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(cur);

        HashSet<String> visited = new HashSet<>();
        visited.add(cur[0] + "_" + cur[1]);

        ArrayList<int[]> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            // cur x1为圆心，r1为半径的圆周上
            cur = queue.poll();
            if (cur[0] >= 1 && cur[0] <= n && cur[1] >= 1 && cur[1] <= n
                    && distance(cur[0], cur[1], x2) == r2
                    && distance(cur[0], cur[1], x3) == r3) {
                result.add(cur);
            }
            if (result.size() == 2) {
                break;
            }

            // 八个方向遍历
            add(cur[0] - 1, cur[1] - 1, x1, r1, queue, visited);
            add(cur[0] - 1, cur[1], x1, r1, queue, visited);
            add(cur[0] - 1, cur[1] + 1, x1, r1, queue, visited);
            add(cur[0], cur[1] - 1, x1, r1, queue, visited);
            add(cur[0], cur[1] + 1, x1, r1, queue, visited);
            add(cur[0] + 1, cur[1] - 1, x1, r1, queue, visited);
            add(cur[0] + 1, cur[1], x1, r1, queue, visited);
            add(cur[0] + 1, cur[1] + 1, x1, r1, queue, visited);
        }

        // 若信标不唯一，输出字典序最小的
        if (result.size() == 1 || result.get(0)[1] < result.get(1)[0]
                || (result.get(0)[0] == result.get(1)[0] && result.get(0)[1] < result.get(1)[1])) {
            return result.get(0);
        } else {
            return result.get(1);
        }
    }

    public static void add(int x, int y, int[] c, int r, Queue<int[]> queue, HashSet<String> visited) {
        String key = x + "_" + y;
        if (distance(x, y, c) == r && !visited.contains(key)) {
            queue.add(new int[]{x, y});
            visited.add(key);
        }
    }

    public static int distance(int x, int y, int[] c) {
        return Math.abs(x - c[0]) + Math.abs(y - c[1]);
    }
}
