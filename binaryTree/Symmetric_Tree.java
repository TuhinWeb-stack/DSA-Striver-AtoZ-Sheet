/*
 * PROBLEM STATEMENT: LeetCode 101 - Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of
 * itself (i.e., symmetric around its center).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [1, 1000].
 * ● -100 <= Node.val <= 100
 */

public class Symmetric_Tree {

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
    // WHY: A single node (or empty tree) is trivially symmetric, so we
    // kick off the real comparison starting from the root's two children.
    public static boolean isSymmetric(TreeNode root) {
        // 1. EDGE CASE: An empty tree has no asymmetry to find.
        if (root == null) {
            return true;
        }

        // WHY: We compare root.left against root.right — NOT root against
        // itself — because symmetry is about the two halves mirroring
        // each other, not the root matching anything.
        return isMirror(root.left, root.right);
    }

    // WHAT: Recursive helper that checks if two subtrees are MIRROR images
    // of each other (crossed comparison), not identical copies.
    // WHY: This is the core logic — reusing the "Same Tree" recursion
    // pattern but swapping which children get compared against which.
    private static boolean isMirror(TreeNode left, TreeNode right) {
        // 1. BASE CASE - BOTH NULL: Nothing here on either side, mirrors fine.
        if (left == null && right == null) {
            return true;
        }

        // 2. BASE CASE - ONE NULL: One side has a node, other doesn't —
        // shapes can't mirror each other.
        if (left == null || right == null) {
            return false;
        }

        // 3. VALUE CHECK: Both nodes exist, so now check if their values match.
        // WHY: For a mirror, the values at symmetric positions must be equal.
        if (left.val != right.val) {
            return false;
        }

        // 4. CROSSED RECURSIVE STEP: This is the key difference from "Same Tree".
        // WHY: In a mirror, the LEFT side's outer edge (left.left) must match
        // the RIGHT side's outer edge (right.right) — think of folding the
        // tree in half like a reflection. Similarly, left.right (inner) must
        // match right.left (inner).
        boolean outerMatch = isMirror(left.left, right.right);
        boolean innerMatch = isMirror(left.right, right.left);

        return outerMatch && innerMatch;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING SYMMETRIC TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [1,2,2,3,4,4,3]
        // -------------------------------------------------------------
        // Structural Visualization:
        //             1
        //           /   \
        //          2     2
        //         / \   / \
        //        3   4 4   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Run the static execution engine directly
        boolean result = isSymmetric(root);

        // Expected Output: true
        System.out.println("Is Symmetric: " + result);
    }
}