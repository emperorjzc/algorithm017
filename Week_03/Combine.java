package Week_03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine {
    // 77. 组合
    // 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    // 示例:

    // 输入: n = 4, k = 2
    // 输出:
    // [
    // [2,4],
    // [3,4],
    // [2,3],
    // [1,2],
    // [1,3],
    // [1,4],
    // ]

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combines = new ArrayList<>();
        if (k < 1 || n < k)
            return combines;
        Deque<Integer> path = new ArrayDeque<>();
        doCombine(n, k, 1, combines, path);
        return combines;
    }

    private void doCombine(int n, int k, int begin, List<List<Integer>> combines, Deque<Integer> path) {

        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            combines.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        for (int j = begin; j <= n; j++) {
            // 向路径变量里添加一个数
            path.addLast(j);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            doCombine(n, k, j + 1, combines, path);
            // 递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

}
