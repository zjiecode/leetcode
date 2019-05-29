package com.zjiecode.leetcode;

/**
 * 说明：整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 作者：zjiecode
 * 时间：2019-05-28
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            int v = values[i];
            if (num < v) {
                continue;
            }
            int mod = num / v;
            for (int j = 0; j < mod; j++) {
                roman.append(romans[i]);
            }
            num %= v;
        }
        return roman.toString();
    }


    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        IntegerToRoman integerToRoman = new IntegerToRoman();
        for (int i = 1; i < 2999; i++) {
            String s = integerToRoman.intToRoman(i);
            if (romanToInteger.romanToInt(s) != i) {
                System.out.println("error：" + s + "," + i);
            }
        }
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }

//    public String intToRoman(int num) {
//        StringBuilder roman = new StringBuilder();
//        for (int i = 3; i >= 1; i--) {
//            int rank = (int) Math.pow(10, i);
//            //1000 1000 10
//            num = deal(roman, num, rank);
//            //900 90 9
//            num = deal(roman, num, (int) (rank * 0.9f));
//            //500 50 5
//            num = deal(roman, num, (int) (rank * 0.5f));
//            //400 40 4
//            num = deal(roman, num, (int) (rank * 0.4f));
//        }
//        return roman.append(rideString(map(1), num)).toString();
//    }
//
//    private int deal(StringBuilder sb, int num, int rank) {
//        int tempRank = rank;
//        int mod = num / tempRank;
//        if (mod > 0) {
//            sb.append(rideString(map(tempRank), mod));
//            num %= tempRank;
//        }
//        return num;
//    }

    private String rideString(String c, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(c);
        }
        return result.toString();
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
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     */
    private String map(int num) {
        switch (num) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            case 900:
                return "CM";
            case 400:
                return "CD";
            case 90:
                return "XC";
            case 40:
                return "XL";
            case 9:
                return "IX";
            case 4:
                return "IV";
            default:
                throw new RuntimeException("转换错误:" + num);
        }
    }
}
