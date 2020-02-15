package com.zjiecode.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 说明：102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 作者：zjiecode
 * 时间：2020-01-04
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){return result;}

        Queue<TreeNode> listA = new LinkedList<>();
        Queue<TreeNode> listB = new LinkedList<>();
        listA.add(root);
        do {
            List<Integer> line = new ArrayList<>();
            while (!listA.isEmpty()) {
                TreeNode node = listA.poll();
                if(node!=null){
                    line.add(node.val);
                    if(node.left!=null){
                        listB.add(node.left);
                    }
                    if(node.right!=null){
                        listB.add(node.right);
                    }
                }
            }
            result.add(line);
            Queue<TreeNode> temp = listA;
            listA = listB;
            listB = temp;
        }while(!listA.isEmpty() ||! listB.isEmpty());
        return result;
    }
}
