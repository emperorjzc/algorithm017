# 深度优先搜索和广度优先搜索

## 搜索 - 遍历

- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
    - 深度优先：depth first search
    - 广度优先：breadth first search

## 深度优先搜索

### 代码模板

```

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }

```

## 广度优先搜索

- 一层一层的扩散（可以想象成水滴，滴到一层之后渗透完全才会到下一层）

### 代码模板

```

//Java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}


    

```

# 贪心算法

## 贪心算法 Greedy

### 定义

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

贪心算法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心算法一般不能得到我们所要求的答案。

一旦一个问题可以通过贪心算法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求不特别精确的问题。

### 贪心算法的缺陷

不能回退，有些情况下当下找到的最优并不一定是全局最优。

### 贪心算法与动态规划

贪心算法与动态规划的不同在于它对没个子问题的解决方案都作出选择，不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心算法：当下做局部最优判断
回溯：能够回退
动态规划：最优判断 + 回退

### 适用场景

简单来说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

### 关键点

- 怎么证明是可以用贪心法的
- 贪心的角度可能不一样，有些时候可以正常的去使用贪心法，有些时候你必须把问题是稍微转化一下，再进行谈心求解。

# 二分查找

## 二分查找

### 前提条件

1. 目标函数单调性（单调递增或递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

### 代码模板

```


public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}


```