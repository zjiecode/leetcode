package com.zjiecode.leetcode;

/**
 * 说明：771. 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * 作者：zjiecode
 * 时间：2019-11-30
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        byte[] a = new byte[58];
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            a[J.charAt(i)-65] = 1;
        }
        for (int i = 0; i < S.length(); i++) {
            if (a[S.charAt(i)-65] == 1) {
                count++;
            }
        }
        return count;
    }
}
