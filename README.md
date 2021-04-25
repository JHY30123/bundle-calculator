# Bundle Calculator

## Question Description
Social media Influencers have been basing the price of their social media post on a single post basis. So If a brand required 10 posts (for example spread over a period) then they would be charged 10x the cost of a single post. One company has decided to allow social media influencers to sell posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

The company currently allows the influencer to monitize the following submission formats:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## Task

Given a brands order, you are required to determine the cost and bundle breakdown for each submission format. For simplicity, each order should contain the minimal number of bundles.

### Input:
Each order has a series of lines with each line containing the number of items followed by the submission format code
An example input:
```
10 IMG
15 FLAC
13 VID
```

### Output:
A successfully passing test(s) that demonstrates the following output: (The format of the output is not important)
```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```



## Requirements

* `Gradle` and `Lombok` has to be used in this code test
* Using `stream` and `lambda expression` when you can
* Use `log` instead of `system.out.println`
* Unit test is required

## 解题思路
问题的关键点在于如何处理“剩余”物品，例如在礼包选择为3， 5条的情况下， 用户需要上传4条内容，平台会卖3条让用户保留1条信息留至下次上传还是用户必须选择可将4条内容全部覆盖的5条内容的礼包。一开始的时候我觉得是前者，但是很容易发现这类问题为“无约束下求最值”的问题，此类问题没有求解的必要，换言之即用户选择一条都不买自然为花销最少的方案。
通过再次阅读题意可知用户必须通过选购捆绑包来全部上传内容。因而问题则成为了“逆完全背包问题”， 即`至少选择k个物品使得总价值最小`。因而思路可完全仿照完全背包问题解决。

通过计算可知f[i][j]的状态转移方程不会改变，只需在比较过程求解最小值即可。

在本次项目中的挑战为:
1. 完全背包问题的数组项目起始点为1，但java数组下标必须为0开始。
   
    关于这个问题我最开始的解决方案为reindex数组，但后面发现reindex会破坏代码的逻辑结构。因而换了一种方法，即通过在数组的初始位置a[0]插入**正无穷**(double.POSITIVE_INFINATE)来实现。之所以选用正无穷而非*INTEGER.MAX_NUM*则在于防止误操作来改变插入值的特性。

2. 如何在求得最优解的同时记录选择方案？

    最开始的想法为辗转相除法，即`目标值/bundleValueMax`求得其最高位所需购买个数。再通过 `(目标值 % bundleValueMax)/bundleValueMiddle`来获取次高位礼包所需购买个数。但后来发现这种方法在特定情况下会得出错误结论。
例如测试用例`2040 VID`。因而目前的想法为在求解的过程中维护一个状态数组？这种做饭**增加了算法复杂度**，因而探讨一下其他方法的可行性。
   
   在之后对价格数组的分析中可得知，最后一位是包含有其选组的信息。因而通过比较其与上面一排的对应位的价格，可知是否选取了当前的pack。因而可得到一个O(n)的算法来解析选取的具体方案状态。








