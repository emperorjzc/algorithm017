## Trie 树的基本实现和特性

字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。
典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
它的优点是：最大限度地减少无所谓的字符串比较，查询效率比哈希表高。

### 应用场景

谷歌搜索引擎
典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

### 字典树的数据结构



### 字典树的核心思想

- Trie 树的核心思想是空间换时间
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### 字典树的基本性质

1. 结点本身不存完整单词；
2. 从根结点到某一结点，路径上经过的字符串连接起来，为该结点对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同。

### Tire 树代码模板

```

//Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}


```
### 知识点

复习树 -- 二叉树、二叉搜索树、


## Trie 树实战题目解析：单词搜索2



## 并查集的基本实现、特性和实战题目解析

### 代码模板

```

// Java
class UnionFind { 
private int count = 0; 
private int[] parent; 
public UnionFind(int n) { 
count = n; 
parent = new int[n]; 
for (int i = 0; i < n; i++) { 
parent[i] = i;
}
} 
public int find(int p) { 
while (p != parent[p]) { 
parent[p] = parent[parent[p]]; 
p = parent[p]; 
}
return p; 
}
public void union(int p, int q) { 
int rootP = find(p); 
int rootQ = find(q); 
if (rootP == rootQ) return; 
parent[rootP] = rootQ; 
count--;
}
}


```

## 剪枝的实现和特性

### 初级搜索

1. 朴素搜索
2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）
3. 搜索方向：
    1. DFS: depth first search 深度优先搜索
    2. BFS: breadth first search 广度优先搜索
    
    双向搜索 -- 从起点和终点分别做一个广度优先，然后在中间相遇，这样的话时间更快
    启发式搜索 -- 不再用栈或者用队列这种先入先出先入后出的形式，而是用一个优先队列放在这里面，而优先队列它是按照结点优先级，也就是有些结点更可能会达到我们需要的结果的话，就先把它从队列里面拿出来进行搜索，我们就叫它启发式搜索，也叫做 A* 算法或者叫做优先级搜索

### 思路

当做一个搜索问题时，脑海里有要有一个搜索的状态树。

### 剪枝

在检查状态树时，如果发现这个分支是已经处理过的，那么我们就把它暂存咋缓存里面，整个分支的话就可以剪掉不需要再手动进行计算，有些时候是分支不够好，所谓的叫做比较差的分支或者是次优的分支，我们也可以把它剪掉。

### 关于回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

- 找到一个可能存在的正确的答案
- 在尝试了所有可能的分步方法后宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。


## 启发式搜索的实现、特性

### 代码模板

```

# Python
def AstarSearch(graph, start, end):

pq = collections.priority_queue() # 优先级 —> 估价函数
pq.append([start]) 
visited.add(start)

while pq: 
node = pq.pop() # can we add more intelligence here ?
visited.add(node)

process(node) 
nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
pq.push(unvisited)

```
### 估价函数

启发式函数：h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n)会返回一个非负实数，也可以认为是从结点n的牧宝结点路径的估价成本。

启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。