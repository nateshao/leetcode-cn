package com.nateshao;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    /**
     * 思路
     * 标签：数学
     * 本题如果不考虑溢出问题，是非常简单的。解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。
     * 由于字符串转换的效率较低且使用较多库函数，所以解题方案不考虑该方法，而是通过数学计算来解决。
     * 通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
     * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
     * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
     * 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     * 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
     * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
     * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


}
