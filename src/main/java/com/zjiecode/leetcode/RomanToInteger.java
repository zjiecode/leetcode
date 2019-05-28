package com.zjiecode.leetcode;

/**
 * 说明：罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 作者：zjiecode
 * 时间：2019-05-28
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            int v = map(s.charAt(i));
            if (i < len - 1 && map(s.charAt(i)) < map(s.charAt(i + 1))) {
                sum -= v;
            } else {
                sum += v;
            }
        }
        return sum;
    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    private int map(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("罗马字符错误");
        }
    }
}
