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