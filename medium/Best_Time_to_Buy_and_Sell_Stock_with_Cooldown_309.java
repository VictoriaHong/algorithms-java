// Best Time to Buy and Sell Stock with Cooldown
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int n = prices.length;
        int[] sell = new int[n];
        int[] cd = new int[n];
        
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        cd[0] = 0;
        cd[1] = 0;
        for (int i = 2; i < n; i++) {
            sell[i] = Math.max(cd[i - 2] + prices[i] - prices[i - 1], sell[i - 1] + prices[i] - prices[i - 1]);
            cd[i] = Math.max(sell[i - 1], cd[i - 1]); // 保证cd是非递减的
        }
        
        return Math.max(sell[n - 1], cd[n - 1]);
    }
}
/*
#.... i-2    i-1     i ...
1.    cd     buy    sell (卖掉前一天买的) sell[i] = cd[i - 2] + p[i] - p[i - 1]
2     x      x      sell (卖掉非前一天买的) sell[i] = sell[i - 1] + p[i] - p[i - 1]
3.    x      sell   cd (前一天买了，必须cd) cd[i] = sell[i - 1]
4.    x      cd     cd (在一次卖掉后一直cd) cd[i] = cd[i - 1] = ...
5.    sell   cd     buy (在前一次卖掉后cd一次再买入) -> maxprofit = sell[i - 2]
6.    x      cd     buy (在一次卖掉后一直cd突然再买入) -> maxprofit = cd[i - 1] = ...

5 6 在前面都有包含
*/

