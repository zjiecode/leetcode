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
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcbbcd"));
    }

    /**
     * 滑动窗口，从最左边开始，遇到重复字符，就把窗口的开始调整到重复的第一个字符右边，继续开始扫描
     */
    public int lengthOfLongestSubstring(String s) {
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
    public int lengthOfLongestSubstring2(String s) {
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
