/*
 * PROBLEM STATEMENT: LeetCode 124 - Binary Tree Maximum Path Sum
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * * Key Rule: A path can only visit a node once, meaning it cannot fork or loop.
 * * Constraints:
 * ● The number of nodes in the tree is in the range [1, 30,000].
 * ● -1000 <= Node.val <= 1000
 */

public class Binary_Tree_Maximum_Path_Sum {

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
    // WHY: Allocates a tracking reference array initialized to the smallest possible 
    // integer to safely handle trees containing entirely negative values.
    public static int maxPathSum(TreeNode root) {
        int[] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE; // Initialize to the lowest possible value
        
        calculateMaxGain(root, globalMax);
        return globalMax[0];
    }

    // WHAT: Bottom-up recursive calculator that extracts branch gains.
    // WHY: Returns the maximum single-branch path sum running out of this node 
    // while checking if a combined path through this node breaks the global record.
    private static int calculateMaxGain(TreeNode node, int[] globalMax) {
        // Base Case: An empty node adds absolutely nothing to the path sum.
        if (node == null) {
            return 0;
        }

        // 1. LEFT STEP: Find the max path gain running down the left branch.
        // WHY: We use Math.max(..., 0) because if a branch returns a negative sum, 
        // it is always better to discard it completely (turn it into 0).
        int leftGain = Math.max(calculateMaxGain(node.left, globalMax), 0);

        // 2. RIGHT STEP: Find the max path gain running down the right branch.
        int rightGain = Math.max(calculateMaxGain(node.right, globalMax), 0);

        // 3. UPDATE GLOBAL MAX RECORD: Calculate the complete path sum centered at this node.
        // WHY: A path can connect through this node from left to right, making a full arch.
        int currentPathSum = node.val + leftGain + rightGain;
        globalMax[0] = Math.max(globalMax[0], currentPathSum);

        // 4. RETURN VALUE: Return the maximum single-branch gain back up to the parent.
        // WHY: The parent can only use one branch (left or right) to maintain a continuous path line.
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE MAXIMUM PATH SUM ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT 2: root = [-10, 9, 20, null, null, 15, 7]
        // -------------------------------------------------------------
        // Structural Visualization:
        //        -10
        //        /  \
        //       9    20
        //           /  \
        //          15   7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Run the static execution engine directly
        int result = maxPathSum(root);

        // Expected Output: 42 (Path is 15 -> 20 -> 7)
        System.out.println("Maximum Path Sum: " + result);
    }
}