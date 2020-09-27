package Week_01;

import java.util.Arrays;

public class RotateArray {

    // 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    // 示例 1:

    // 输入: [1,2,3,4,5,6,7] 和 k = 3
    // 输出: [5,6,7,1,2,3,4]
    // 解释:
    // 向右旋转 1 步: [7,1,2,3,4,5,6]
    // 向右旋转 2 步: [6,7,1,2,3,4,5]
    // 向右旋转 3 步: [5,6,7,1,2,3,4]

    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/rotate-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        // 分析: 每向右旋转1步: 数组的最后1位变为第1位，其余位置向后移动1位
        if (k == 0)
            return;
        for (int i = 0; i < k; i++) {
            // 声明一个 int 值是将要取代下一个位置的值
            int previousValue = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                // 临时保存 被替换的值
                int temp = nums[j];
                // 将旋转后的值 放在当前位置
                nums[j] = previousValue;
                // 保存下一个位置的值
                previousValue = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    // TODO 其他解法

}
