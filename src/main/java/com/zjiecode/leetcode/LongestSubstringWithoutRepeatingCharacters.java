package com.zjiecode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 作者：zjiecode
 * 时间：2019-05-29
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("a"));
    }

    /**
     * 滑动窗口，从最左边开始，遇到重复字符，就把窗口的开始调整到重复的第一个字符右边，继续开始扫描
     * 当已知字符范围的时候，可以用数组代替map，见小查找时间
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[128];
        int max = 0;
        for (int i = 0, w = 0; i < s.length(); i++) {
            //w为滑动窗口左边的边界
            w = Math.max(map[s.charAt(i)], w);
            //求出当前窗口长度
            max = Math.max(max, i - w + 1);
            //储存当前字符位置，下次遇到这个字符，窗口就从字符右边开始
            map[s.charAt(i)] = i + 1;

        }
        return max;
    }

    /**
     * 滑动窗口，从最左边开始，遇到重复字符，就把窗口的开始调整到重复的第一个字符右边，继续开始扫描
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null) {
                startIndex = Math.max(startIndex, index + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - startIndex + 1);

        }
        return max;
    }

    /**
     * 暴力求解
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int maxSubStrLen = 0;
        boolean b = false;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                b = false;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        int l = j - i;
                        maxSubStrLen = maxSubStrLen > l ? maxSubStrLen : l;
                        b = true;
                        break;
                    }
                }
                if (b) {
                    break;
                }
                int l = j - i + 1;
                maxSubStrLen = maxSubStrLen > l ? maxSubStrLen : l;
            }
        }
        return maxSubStrLen;
    }

}
