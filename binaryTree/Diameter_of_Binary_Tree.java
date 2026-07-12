/*
 * PROBLEM STATEMENT: LeetCode 543 - Diameter of Binary Tree
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * * Definition: The diameter is the length of the longest path between any two nodes.
 * * Key Constraint: The length is measured by the number of EDGES, not nodes.
 * * Constraints:
 * ● The number of nodes in the tree is in the range [1, 10,000].
 * ● -100 <= Node.val <= 100
 */

public class Diameter_of_Binary_Tree {

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
    // WHY: Allocates a single-element array tracking state to record the max global 
    // diameter seen across all recursive stack frames.
    public static int diameterOfBinaryTree(TreeNode root) {
        // We use an array of size 1 instead of a primitive int because arrays are 
        // passed by reference in Java, allowing recursive calls to modify the shared maximum value.
        int[] maxDiameter = new int[1];
        calculateHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    // WHAT: Bottom-up height calculator that updates our global path tracker on the fly.
    // WHY: Returns the height of the current node's subtree while simultaneously 
    // checking if the left-to-right path spanning across this node is the new longest trail.
    private static int calculateHeight(TreeNode node, int[] maxDiameter) {
        // Base Case: An empty node has a height contribution of 0.
        if (node == null) {
            return 0;
        }

        // 1. LEFT STEP: Find the deep height path on the left branch.
        int leftHeight = calculateHeight(node.left, maxDiameter);

        // 2. RIGHT STEP: Find the deep height path on the right branch.
        int rightHeight = calculateHeight(node.right, maxDiameter);

        // 3. DIAMETER RECORD CHECK: Calculate edges passing through this node.
        // WHY: The number of edges combining both sides is exactly leftHeight + rightHeight.
        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);

        // 4. HEIGHT RETURN: Return the height of this current subtree back up to the parent.
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING DIAMETER OF BINARY TREE CALCULATOR ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT 1: root = [1, 2, 3, 4, 5]
        // -------------------------------------------------------------
        // Structural Visualization:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Run the static execution engine directly
        int result = diameterOfBinaryTree(root);

        // Expected Output: 3 (Path can be [4, 2, 1, 3] or [5, 2, 1, 3])
        System.out.println("Diameter of the tree (Edge Count): " + result);
    }
}