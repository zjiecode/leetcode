package com.zjiecode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * 作者：zjiecode
 * 时间：2019-05-31
 */
public class TwoSum {
    /**
     * 使用hash，记录一个值对应的下标，计算一个差以后，反差下标。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer index = map.get(left);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not two sum is:" + target);
    }

    /**
     * 暴力求解
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("not two sum is:" + target);
    }
}
