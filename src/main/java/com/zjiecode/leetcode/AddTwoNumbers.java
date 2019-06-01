package com.zjiecode.leetcode;

/**
 * 说明：2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 作者：zjiecode
 * 时间：2019-05-31
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(null, l1, l2, false);
    }

    /**
     * 递归求解
     */
    private ListNode addTwoNumbers(ListNode result, ListNode l1, ListNode l2, boolean up) {
        Integer v = null;
        if (l1 != null && l2 != null) {
            v = l1.val + l2.val;
        } else if (l1 != null) {
            v = l1.val;
        } else if (l2 != null) {
            v = l2.val;
        }
        if (v != null) {
            if (up) {
                v++;
            }
            ListNode node = new ListNode(v % 10);
            if (result == null) {
                result = node;
            } else {
                result.next = node;
            }
            addTwoNumbers(node, l1 == null ? null : l1.next, l2 == null ? null : l2.next, v > 9);
            return result;
        }
        if (up) {
            //最高位还有进位
            result.next = new ListNode(1);
        }
        return result;
    }

    /**
     * 直接遍历2个链表
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        boolean upOne = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (upOne) {
                sum++;
            }
            if (sum > 9) {
                upOne = true;
                sum = sum % 10;
            } else {
                upOne = false;
            }
            if (head == null) {
                head = new ListNode(sum);
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            if (upOne) {
                l2.val++;
            }
            if (l2.val > 9) {
                upOne = true;
                l2.val = l2.val % 10;
            } else {
                upOne = false;
            }
            node.next = l2;
            node = l2;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (upOne) {
                l1.val++;
            }
            if (l1.val > 9) {
                upOne = true;
                l1.val = l1.val % 10;
            } else {
                upOne = false;
            }
            node.next = l1;
            node = l1;
            l1 = l1.next;
        }
        if (upOne) {
            node.next = new ListNode(1);
        }
        return head;
    }
}
