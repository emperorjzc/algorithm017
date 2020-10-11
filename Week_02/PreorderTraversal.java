package Week_02;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList();
        preorder(root, values);
        return values;
    }

    private static void preorder(TreeNode root, List<Integer> values) {
        // 前序遍历 根-左-右
        if (root != null) {
            values.add(root.val);
            preorder(root.left, values);
            preorder(root.right, values);
        } 

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List result = preorderTraversal(node);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
