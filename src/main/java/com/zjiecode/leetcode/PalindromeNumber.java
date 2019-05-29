package com.zjiecode.leetcode;

/**
 * 说明：9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * 作者：zjiecode
 * 时间：2019-05-29
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int input = x;
        int reverseNum = 0;
        while (x > 0) {
            int mod = x % 10;
            reverseNum = reverseNum * 10 + mod;
            x /= 10;
        }
        return reverseNum == input;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
//        System.out.println(palindromeNumber.isPalindrome(5));
        for (int i = 0; i < 1000000; i++) {
            if (palindromeNumber.isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}
