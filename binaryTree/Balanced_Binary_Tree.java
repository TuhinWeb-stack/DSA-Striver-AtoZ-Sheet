/*
 * PROBLEM STATEMENT: LeetCode 110 - Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * * Definition: A height-balanced binary tree is a binary tree in which the left 
 * and right subtrees of every node differ in height by no more than 1.
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 5000].
 * ● -10^4 <= Node.val <= 10^4
 */

public class Balanced_Binary_Tree {

    // WHAT: Nested static template matching LeetCode's structural node layout.
    // WHY: Keeps the name matching 'TreeNode' perfectly without leaking or 
    // colliding with other tree practice files inside your local directory.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) { 
            this.val = val; 
        }
    }

    // WHAT: Static entry point matching LeetCode's method layout signature.
    // WHY: Converts our helper function's height integer output into a boolean result.
    public static boolean isBalanced(TreeNode root) {
        // If the bottom-up check returns -1, it means the tree is unbalanced.
        return checkHeight(root) != -1;
    }

    // WHAT: Bottom-up height calculator that performs a twin task.
    // WHY: It returns the actual height if the subtree is perfectly balanced, 
    // but returns -1 instantly if any structural imbalance is detected.
    private static int checkHeight(TreeNode node) {
        // Base Case: An empty node contributes 0 to the total height path.
        if (node == null) {
            return 0;
        }

        // 1. LEFT STEP: Traverse down into the left subtree branch.
        int leftHeight = checkHeight(node.left);
        // WHY: If a failure sentinel (-1) bubbles up from beneath, pass it up instantly.
        if (leftHeight == -1) {
            return -1; 
        }

        // 2. RIGHT STEP: Traverse down into the right subtree branch.
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        // 3. BALANCE CHECK STEP: Compare the absolute difference between subtrees.
        // WHY: If the delta height is greater than 1, this specific node is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Trigger and bubble up the failure state sentinel
        }

        // 4. BALANCED PATH HEIGHT: If it passes validation, return its true height.
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BALANCED BINARY TREE EVALUATOR ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT 2: root = [1, 2, 2, 3, 3, null, null, 4, 4]
        // -------------------------------------------------------------
        // Structural Visualization (Unbalanced Example):
        //         1
        //        / \
        //       2   2
        //      / \
        //     3   3
        //    / \
        //   4   4       <-- Heavily skewed to the left branch floor!
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        // Run the static layer execution directly
        boolean result = isBalanced(root);

        // Expected Output: false
        System.out.println("Is the tree height-balanced? " + result);
    }
}