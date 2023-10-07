package leetcode_daily_question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * LeetCode 901.股票价格跨度
 */
public class StockSpanner {
    Deque<Integer> deque;
    HashMap<Integer, Integer> map;

    public StockSpanner() {
        deque = new ArrayDeque<>();
        map = new HashMap<>();
    }

    public int next(int price) {
        int count = 0;
        while (!deque.isEmpty() && price >= deque.getLast()) {
            Integer num = deque.pollLast();
            if (map.containsKey(num)) {
                count += map.get(num);
                map.remove(num);
            } else {
                count++;
            }
        }
        deque.addLast(price);

        if (count > 0) {
            map.put(price, count + 1);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
