package Week_01;

public class RemoveDuplicates {

    // 给定数组 nums = [1,1,2],

    // 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    // 你不需要考虑数组中超出新长度后面的元素。

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 5 };
        System.out.println("size==>" + removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 先声明一个指针代表数组中 要对比的不重复数的开始
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                // 指针 +1 代表下一个不重复数值的存储位置
                index++;
                nums[index] = nums[i];
            }

        }
        // 指针 index 是数组底标，返回大小时应 +1
        return index + 1;
    }
}
