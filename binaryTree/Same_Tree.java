/*
 * PROBLEM STATEMENT: LeetCode 100 - Same Tree
 * Given the roots of two binary trees p and q, check if they are the same tree.
 * Two binary trees are the same if they are structurally identical AND 
 * corresponding nodes have the same value.
 *
 * Constraints:
 * ● The number of nodes in both trees is in the range [0, 100].
 * ● -10^4 <= Node.val <= 10^4
 */

public class Same_Tree {

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
    // WHY: Directly delegates to recursive comparison — no extra state needed
    // here, unlike problems that require a running global tracker.
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    // WHAT: Recursive helper that compares two nodes and their subtrees.
    // WHY: Breaks the "are these trees the same" question into smaller,
    // identical sub-questions on left and right children.
    private static boolean compare(TreeNode p, TreeNode q) {
        // 1. BASE CASE - BOTH NULL: Nothing to compare, so this branch matches.
        // WHY: If both trees "end" here at the same time, structure agrees.
        if (p == null && q == null) {
            return true;
        }

        // 2. BASE CASE - ONE NULL: One tree has a node, the other doesn't.
        // WHY: Structural mismatch — shapes differ, so trees can't be the same.
        if (p == null || q == null) {
            return false;
        }

        // 3. VALUE CHECK: Both nodes exist here, so it's now safe to read .val.
        // WHY: Even if structure matches, differing values break the match.
        if (p.val != q.val) {
            return false;
        }

        // 4. RECURSIVE STEP: Check left subtrees AND right subtrees.
        // WHY: The whole tree only matches if BOTH sides independently match.
        boolean leftSame = compare(p.left, q.left);
        boolean rightSame = compare(p.right, q.right);

        return leftSame && rightSame;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING SAME TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 3): p = [1,2,1], q = [1,1,2]
        // -------------------------------------------------------------
        // Structural Visualization:
        //   p:      1              q:      1
        //          / \                    / \
        //         2   1                  1   2
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        // Run the static execution engine directly
        boolean result = isSameTree(p, q);

        // Expected Output: false (values at left/right children swapped)
        System.out.println("Are Trees Same: " + result);
    }
}