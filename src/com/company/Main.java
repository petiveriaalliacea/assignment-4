package com.company;

//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class Main {
    static int maxLevel;
    static int sum;

    public static void main(String[] args) {
        // Example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        deepestLeavesSum(root);
        System.out.println(sum);
    }


    public static int deepestLeavesSum(TreeNode root) {
        getDeepestLeavesSum(0, root);
        return sum;
    }


    public static void getDeepestLeavesSum(int level, TreeNode root) {
        if(root == null) return;

        if(maxLevel < level) {
            sum = root.val;
            maxLevel = level;
        } else if(maxLevel == level) {
            sum += root.val;
        }

        getDeepestLeavesSum(level + 1, root.left);
        getDeepestLeavesSum(level + 1, root.right);
    }

}
