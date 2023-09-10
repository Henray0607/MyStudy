package review;

/**
 * 神策面试题
 * 给定一个数据arr，表示连续n天的股价，数组下标表示第几天
 * 指标X: 任意两天的股价之和 - 此两天间隔的天数
 * 返回arr中最大的指标X
 * 例：第3天，价格是10；第9天，价格是30；那么第3天和第9天指标X: 10+30-(9-3)=34
 * 分析：arr[i]+arr[j]-(j-i)=arr[i]+i+(arr[j]-j)
 */
public class Code01_MaxXFromStock {
    public static int maxX(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int res = 0;
        int preBest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, preBest + arr[i] - i);
            preBest = Math.max(preBest, arr[i] + i);
        }
        return res;
    }
}
