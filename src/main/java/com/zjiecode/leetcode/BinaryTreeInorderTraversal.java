package com.zjiecode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 作者：zjiecode
 * 时间：2020-01-04
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        find(list, root);
        return list;
    }

    public void find(List<Integer> list, TreeNode node) {
        if (node != null) {
            find(list, node.left);
            list.add(node.val);
            find(list, node.right);
            return;
        }
    }
}
