package com.zjiecode.leetcode;

/**
 * https://leetcode-cn.com/problems/design-hashset/
 * 说明：705. 设计哈希集合
 * 作者：zjiecode
 * 时间：2019-11-24
 */
public class DesignHashset {
    class Node {
        public int value;
        public Node nextNode;
    }

    private Node[] mNodes;
    private static final int ARRAY_SIZE = 1000;

    public DesignHashset() {
        mNodes = new Node[ARRAY_SIZE];
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        int index = hash(key);
        Node node = new Node();
        node.value = key;
        if (mNodes[index] == null) {
            mNodes[index] = node;
        } else {
            node.nextNode=mNodes[index];
            mNodes[index] = node;
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node tempNode = mNodes[index];
        if (tempNode == null) {
            return;
        } else {
            if (tempNode.value == key) {
                mNodes[index] = mNodes[index].nextNode;
                return;
            }
            while (tempNode.nextNode != null) {
                if (tempNode.nextNode.value == key) {
                    tempNode.nextNode = tempNode.nextNode.nextNode;
                    break;
                }
                tempNode = tempNode.nextNode;
            }
        }

    }

    public boolean contains(int key) {
        int index = hash(key);
        Node tempNode = mNodes[index];
        if(tempNode==null){
            return false;
        }
        if (tempNode.value == key) {
            return true;
        }
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            if (tempNode.value == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % ARRAY_SIZE;
    }
}
