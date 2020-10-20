# 递归

## 定义

- 递归 - 循环，递归类似于循环，递归和循环没有明显的边界
- 通过函数体来进行的循环

## 实现

### 递归模板

1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层状态

```

public void recur(int level, int param) {
    // terminator
    if(level > MAX_LEVEL) {
        // process result 
        return;
    }
    
    // process current logic 
    process(level, param);
    
    // drill down
    recur(level: level + 1, newParam);
    
    // restore current status

}

```

## 现实类比

### 盗梦空间

- 向下进入到不同梦境中；向上又回到原来一层
- 通过声音同步回到上一层；
- 每一层的环境和周围的人都是一份拷贝、主角等几个人穿越到不同层级的梦境（发生和携带变化）

## 思维要点

1. 不要人肉递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）（分析并拆解问题，找到重复子问题）
3. 数学归纳法思维（当n 成立时 n+1 依然成立）（通过数学归纳法思维，整理出递归逻辑代码）

## 适合场景

- 树的面试题解法一般都是递归
    - 结点的定义
    - 重复性（自相似性）

## 分治

分治，就是把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题，知道最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。

### 代码模板

```
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator
  if problem is None:
    print_result
return
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  ...
  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, ...)
  # revert the current level states
```

## 回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程
中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将
取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问
题的答案。
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
情况:
- 找到一个可能存在的正确的答案;
- 在尝试了所有可能的分步方法后宣告该问题没有答案。 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。