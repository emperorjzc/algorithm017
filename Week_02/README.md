## 哈希表、映射

### 哈希表

比如Java中的 HashMap、HashSet

#### 实现 

哈希表（Hash table），也就散列表，是根据关键码值（key value）而直接进行访问的数据结构。
它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
这个映射函数叫做散列函数（Hash Function），存放记录的数组叫做哈希表（或散列表）。

### 映射

映射函数（Hash Function）

#### 实现

这里列举的是一个简单的哈希函数：把每一个字符它的ASCII码加在一起，然后再mod上一个数，最后mod出来的数是 9 ,就放在9这个位置。
#### 特性

- 哈希函数选的好的话，可以让数值尽量的分散而不会发生所谓的碰撞

- 哈希碰撞：不同的要存储的数据，经过哈希函数之后会得到一个相同的值，比如上图中的429
    - 解决：常用的方式是增加一个维度，这个位置不止存一个数了，而是存多个数，比如拉链式解决冲突法，此时查询的时间复杂度会由O(1)变为O(N)

## 树、二叉树、二叉搜索树

### 树

#### 组成

- 结点
    - 根结点
    - 子结点
- 层

#### 示例代码

```
public class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
```
#### 树和图的差别

-  有环的 树 称为 图

### 简单理解
- Liked List 是特殊化的 Tree
- Tree 是特殊化的 Graph

### 二叉树

#### 组成

- 根结点：熟的最顶端的结点
- 子结点：除根结点之外，并且本身下面还连接有结点的结点
- 叶子结点：一棵树当中没有子结点（即度为0）的结点称为叶子结点

#### 满二叉树

- 高度为h，由2^h - 1个结点构成的二叉树称为满二叉树。
- 满二叉树是一个三角形，最后一层全部是叶子结点，其他各层是非叶子结点。

#### 完全二叉树

- 完全二叉树是由满二叉树而引出来的，完全二叉树的结点数是任意的，形状 类似一个缺失的三角形，但所缺失的部分一定是右下角某个连续的部分，最后那一行可能不是完整的。
- 设二叉树的深度为 h, 结点数的范围 2^(h - 1) -1 < N < 2^h - 1, 除第 h层外，其它各层(1 ~ h-1) 的结点数都达到最大个数(即1~h-1层为一个满二叉树), 第h层所有的结点都连续集中在最左边。
- 堆一般都用完全二叉树来实现

疑惑: 所缺失的部分一定是 右下角？为什么一定是右下角？第h层所有的结点都连续集中在最左边？为什么？

#### 为什么会出现树

解决问题：下棋、斐波那契数列

#### 遍历

- 为什么要遍历？
    - 查找元素
    - 基于他的树结构，写循环比较麻烦，写递归比较简单
- 遍历方式
    - 前序(Pre-order): 根-左-右
    - 中序(In-order): 左-根-右
    - 后序(Post-order): 左-右-根
    
#### 遍历代码

```

def preorder(selft, root):
    
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
        
def inorder(self, root):
    
    if root:
        self.inorder(root.lef)
        self.traverse_path.append(root.val)
        self.inorder(root.right)

def postorder(self, root):
    
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)

```

### 二叉搜索树

二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一颗空树或者具有下列性质的二叉树：

1. 左子树上所有节点的值均小于他的根节点的值；
2. 右子树上所有节点的值均大于它的根节点的值；
3. 以此类推：左、右子树也分别为二叉查找树。（这就是 重复性！）

中序遍历：升序排列

#### 二叉搜索树常见操作

1. 查询：时间复杂度O(log(n))
2. 插入新节点（创建）
3. 删除

#### 二叉树的生成规则

？？？