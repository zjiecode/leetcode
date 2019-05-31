package com.zjiecode.leetcode;

/**
 * 说明：3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 作者：zjiecode
 * 时间：2019-05-29
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("cabcd"));
    }

    public int lengthOfLongestSubstring(String s) {
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
