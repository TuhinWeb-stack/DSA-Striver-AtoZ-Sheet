import java.util.List;

/*
 * PROBLEM STATEMENT: LeetCode 104 - Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * * Definition: A binary tree's maximum depth is the number of nodes along the 
 * longest path from the root node down to the farthest leaf node.
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 10,000].
 * ● -100 <= Node.val <= 100
 */

public class Maximum_Depth_of_Binary_Tree {

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

    // WHAT: Static method to calculate the maximum depth of the tree.
    // WHY: Uses structural recursion (DFS) to break the problem into smaller sub-problems.
    public static int maxDepth(TreeNode root) {
        // Base Case: If the current node is null, its depth contribution is 0.
        if (root == null) {
            return 0;
        }

        // WHAT: Recursively calculate the max depth of the left and right subtrees.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // WHY: The maximum depth at the current node is the larger of the two 
        // subtree depths, plus 1 to account for the current node itself.
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING MAXIMUM DEPTH OF BINARY TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [3, 9, 20, null, null, 15, 7]
        // -------------------------------------------------------------
        // Structural Visualization:
        //       3         (Depth 1)
        //      / \
        //     9  20       (Depth 2)
        //       /  \
        //      15   7     (Depth 3)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Run the static layer execution directly
        int depth = maxDepth(root);

        // Expected Output: 3
        System.out.println("Maximum Depth: " + depth);
    }
}