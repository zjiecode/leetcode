package com.zjiecode.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/submissions/
 * 说明：394. 字符串解码
 * 作者：zjiecode
 * 时间：2019-11-17
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("s200[a2[b]2[e]]c"));
    }

    public String decodeString(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        Stack<String> stack = new Stack();
        int length = s.length();
        String num = "";
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (isNumber(c)) {
                num += c;
            } else if (c.equals('[')) {
                if (num.length() > 0) {
                    stack.push(num);
                    num = "";
                }
                stack.push(c.toString());
            } else if (c.equals(']')) {
                String tempStr = "";
                String tempChar;
                while (!(tempChar = stack.pop()).equals("[")) {
                    tempStr = tempChar + tempStr;
                }
                int count = Integer.valueOf(stack.pop());
                stack.push(multi(tempStr, count));
            } else {
                stack.push(c.toString());
            }
        }
        String tempStr = "";
        while (!stack.isEmpty()) {
            tempStr = stack.pop() + tempStr;
        }
        return tempStr;
    }

    public String multi(String str, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public boolean isNumber(char c) {
        return c >= 48 && c < 58;
    }
}
