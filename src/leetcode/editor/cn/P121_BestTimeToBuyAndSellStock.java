//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1304 👎 0

package leetcode.editor.cn;

public class P121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();
//        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[0]));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * pay：准备买入的股票价格
         * max：最大收益
         * 如果后一天的股票价格 < 当前准备买入的股票价格，就把更低价格的股票作为准备买入的股票
         * 否则 Math.max(最大收益max,  当前收益); 当前收益 = 后一天股票价格 - 当前准备买入的股票价格
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if(prices.length == 0) {
                return 0;
            }
            int max = 0, pay = prices[0];
            for (int p : prices) {
                if (p <= pay) {
                    pay = p;
                } else {
                    max = Math.max(max, p - pay);
                }
            }
            return max;
        }

        /*public int maxProfit(int[] prices) {
            int maxProfit = 0, pay = Integer.MAX_VALUE;
            for (int p : prices) {
                if (p <= pay) {
                    pay = p;
                } else {
                    maxProfit = Math.max(maxProfit, p - pay);
                }
            }
            return maxProfit;
        }*/

        /*public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
            return max;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

