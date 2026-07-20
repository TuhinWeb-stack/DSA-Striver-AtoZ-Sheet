/*
 * PROBLEM STATEMENT: LeetCode 98 - Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid BST.
 * Left subtree values must be strictly less than the node's value,
 * right subtree values must be strictly greater, and this must hold
 * recursively for ALL descendants, not just immediate children.
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [1, 10^4].
 * ● -2^31 <= Node.val <= 2^31 - 1
 */

public class Validate_Binary_Search_Tree {

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
    // WHY: Kicks off recursion with an unbounded range (-infinity, +infinity)
    // since the root has no constraints from any ancestor yet. We use
    // 'long' bounds (not int) to safely represent +/- infinity beyond
    // Integer.MIN_VALUE/MAX_VALUE, since Node.val can itself BE those
    // exact extreme int values (see constraints) - using int infinities
    // would incorrectly reject a legitimately valid edge-case tree.
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // WHAT: Recursive helper that checks if 'node' AND its entire subtree
    // fit strictly within the range (min, max) - not just the node itself.
    // WHY: The valid range narrows as we descend, correctly propagating
    // constraints from ALL ancestors (not just the immediate parent) down
    // to every descendant - this is what catches violations like a
    // deeply-nested node breaking a rule set by a distant ancestor.
    private static boolean validate(TreeNode node, long min, long max) {
        // 1. BASE CASE - NULL NODE: An empty subtree trivially satisfies
        // any range constraint - nothing here to violate anything.
        if (node == null) {
            return true;
        }

        // 2. RANGE CHECK: Current node's value must be STRICTLY within
        // (min, max) - using strict inequalities enforces "strictly less/
        // greater than" as required by the problem (no duplicates allowed).
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // 3. RECURSE LEFT: Everything in the left subtree must be less
        // than node.val, so we TIGHTEN the upper bound to node.val while
        // keeping the same lower bound (min) inherited from ancestors.
        // WHY: This is how a distant ancestor's constraint (e.g., "must be
        // < 5") correctly carries all the way down through every left
        // step, not just the immediate child.
        boolean leftValid = validate(node.left, min, node.val);

        // 4. RECURSE RIGHT: Everything in the right subtree must be
        // greater than node.val, so we TIGHTEN the lower bound to
        // node.val while keeping the same upper bound (max).
        boolean rightValid = validate(node.right, node.val, max);

        // 5. COMBINE: The whole subtree is valid only if BOTH sides are
        // valid - a single violation anywhere invalidates everything.
        return leftValid && rightValid;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING VALIDATE BINARY SEARCH TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 2): root = [5,1,4,null,null,3,6]
        // -------------------------------------------------------------
        // Structural Visualization:
        //         5
        //       /   \
        //      1     4
        //           / \
        //          3   6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        // Run the static execution engine directly
        boolean result = isValidBST(root);

        // Expected Output: false (node 3 violates root's constraint of > 5)
        System.out.println("Is Valid BST: " + result);
    }
}