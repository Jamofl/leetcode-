/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]


提示：

1 <= n <= 8
通过次数220,842提交次数287,750
 */
package BackTrack回溯;

import java.util.*;
public class Q22括号生成 {
    public List<String> generateParenthesis(int n) {

        LinkedList<String> ans = new LinkedList<>();
        String path = "";

        dfs(n, n, ans, path);
        return ans;
    }

    /**
     * 可以加(的情况 : left > 0 即可
     * 可以加)的情况 : right > 0
     *               && left < right(即剩余的左括号数量小于右括号 说明消耗的左括号更多 此时才可以append右括号)
     * @param left
     * @param right
     * @param ans
     * @param path
     */
    private void dfs(int left, int right, LinkedList<String> ans, String path){
        if (left == 0 && right == 0){
            ans.add(path);
            return;
        }

        if (left > 0){
            dfs(left - 1, right, ans, path + "("); // 生成了新的字符串，不需要回溯，直接dfs即可
        }
        if (right > 0 && left < right){
            dfs(left, right - 1, ans, path + ")");
        }
    }

    public static void main(String[] args){
        Q22括号生成 q = new Q22括号生成();
        List<String> l = q.generateParenthesis(3);
        System.out.println(l);
    }
}
