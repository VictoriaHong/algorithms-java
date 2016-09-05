# Algorithms Practice

### Index

#### Sort

349. [Intersection of Two Arrays](https://github.com/VictoriaHong/algorithms-java/blob/master/category_sort/n349.java)

350. [Intersection of Two Arrays II](https://github.com/VictoriaHong/algorithms-java/blob/master/category_sort/n350.java)



### Notes

- Questions you should ask before implementing an algorithm

    - What's the size of the data set?
    - What's the range of value of each element?
    - Is the input array sorted? Does the order matter?
    - Is duplicated element allowed in input or output?
    - Integers? Nagtive?
    - String? all lowercase? UTF-8 encode?

- [Bitset](https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html)

- [Java 8 map enhancements](https://blog.jooq.org/2014/02/14/java-8-friday-goodies-map-enhancements/)

    [map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#compute-K-java.util.function.BiFunction-)

    [map.computeIfPresent](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#computeIfPresent-K-java.util.function.BiFunction-)

- [External sorting, 九路归并算法](https://www.wikiwand.com/zh/%E5%A4%96%E6%8E%92%E5%BA%8F) 

- Dynamic programming

    存在一种方向感。

    - When?
        - 求max, min
        - 是否存在？yes,no
        - 共有多少种方案？num of possible paths?

    - When not?
        - 求具体方案, give a solution
        - 输入是集合，不是序列, no order

    - How?
        - 矩阵型（坐标）1d, 2d
        - 分割型：如果限制了切割的子字符串的个数为k，2d，f[i][j]为前i个字符切成j个单词是否可行；没有限制，1d。
        - 区间型：i-j 2d
        - 两个序列：2d

- 图的遍历

    - 最常见 bfs: 求两点间最短距离，求方案总数
    - dfs + bfs: 求具体最短距离方案，bfs负责找到起点的距离，dfs从终点逆推搜索全部方案

- [总结: Subsets, Permutations, Combination Sum, Palindrome Partioning](https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning)
