//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1175 👎 0

package leetcode.editor.cn;

import sun.security.util.Length;

public class P198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198_HouseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划：
         * 有n间房屋时，等于 偷第n间和前n-2间  与 偷前n-1间房屋  之间的最大收益
         * dp[0] = nums[0];
         * dp[1] = max(num[0], num[1]);
         * ...
         * dp[i] = max( nums[i] + dp[i-2], dp[i-1] );
         *
         * @param nums
         * @return
         */
        /*public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[len - 1];
        }*/

        /**
         * 动态规划 + 滚动数组
         * f1 = num[0];
         * f2 = Math.max(nums[0], nums[1]);
         *
         * f3 -> fn 都以f2存储
         * temp =f2;
         * f2 = Math.max(nums[i] + f1, f2);
         * f1 = temp;
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int f1 = nums[0];
            int f2 = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                int temp = f2;
                f2 = Math.max(nums[i] + f1, f2);
                f1 = temp;
            }
            return f2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
