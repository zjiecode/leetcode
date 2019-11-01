package com.zjiecode.leetcode;

/**
 * 说明：14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 作者：zjiecode
 * 时间：2019-11-01
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<=0){
            return "";
        }
        int length = strs.length;
        int minStrLen = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            minStrLen = strs[i].length() < minStrLen ? strs[i].length() : minStrLen;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char c = 0;
        for (int i = 0; i < minStrLen; i++) {
            for (int j = 0; j < length; j++) {
                char tempC = strs[j].charAt(i);
                if (c == 0) {
                    c = tempC;
                } else if (c == tempC) {
                    continue;
                } else {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
            c = 0;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String prefix = new LongestCommonPrefix().longestCommonPrefix(new String[]{
        });
        System.out.println(prefix);
    }
}
