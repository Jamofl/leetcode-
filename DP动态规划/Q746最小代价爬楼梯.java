/*
746. 使用最小花费爬楼梯
数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。

每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。

请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。



示例 1：

输入：cost = [10, 15, 20]
输出：15
解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 示例 2：

输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出：6
解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。


提示：

cost 的长度范围是 [2, 1000]。
cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 */
package DP动态规划;

public class Q746最小代价爬楼梯 {


    // 时间O(n)  空间O(n)
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] re = new int[n + 1];
        re[0] = 0;
        re[1] = 0;
        for (int i = 2; i <= n; i ++){
            re[i] = Math.min(re[i - 1] + cost[i - 1], re[i - 2] + cost[i - 2]);
        }
        return re[n];
    }

    // 使用滚动数组进行优化
    // 时间O(n)  空间O(1)
    public int minCostClimbingStairsOpt(int[] cost) {
        int n = cost.length;
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 2; i <= n; i ++){
            third = Math.min(second + cost[i - 1], first + cost[i - 2]);
            first = second;
            second = third;
        }
        return second;
    }
}
