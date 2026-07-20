/*
 * PROBLEM STATEMENT: LeetCode 235 - Lowest Common Ancestor of a BST
 * Given a BST, find the LCA of two given nodes p and q. A node can be
 * a descendant of itself (per LCA definition).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [2, 10^5].
 * ● -10^9 <= Node.val <= 10^9
 * ● All Node.val are unique.
 * ● p != q, and both p and q exist in the BST.
 */

public class Lowest_Common_Ancestor_Of_A_BST {

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
    // WHY: Directly delegates to the recursive BST-aware search - unlike
    // the general binary tree LCA (LC 236), we don't need to explore
    // BOTH subtrees and combine results; BST ordering tells us exactly
    // which single direction to go.
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    // WHAT: Recursive helper that uses BST ordering to navigate directly
    // toward the split point where p and q's paths diverge.
    // WHY: Comparing p.val and q.val against node.val tells us with
    // certainty which subtree (if any) could contain BOTH targets -
    // no need to search blindly like in a non-BST tree.
    private static TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        // 1. DECISION - BOTH TARGETS SMALLER: If both p and q are less
        // than the current node's value, BST guarantees both must live
        // in the left subtree - so the LCA must be there too.
        // WHY: No need to check the right subtree at all - it's
        // guaranteed to contain neither p nor q.
        if (p.val < node.val && q.val < node.val) {
            return findLCA(node.left, p, q);
        }

        // 2. DECISION - BOTH TARGETS LARGER: Symmetric case - both must
        // be in the right subtree.
        if (p.val > node.val && q.val > node.val) {
            return findLCA(node.right, p, q);
        }

        // 3. SPLIT POINT FOUND: If we reach here, it means NEITHER of
        // the above conditions held - meaning either:
        //   (a) p and q are on OPPOSITE sides of node.val (one smaller,
        //       one larger) - node is exactly where their paths diverge, OR
        //   (b) node.val itself equals p.val or q.val - node IS one of
        //       our targets, and per LCA definition a node can be its
        //       own ancestor.
        // WHY: Either way, THIS node is the lowest common ancestor -
        // going further in any direction would "overshoot" and lose
        // one of the two targets.
        return node;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING LOWEST COMMON ANCESTOR OF A BST ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1):
        // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // -------------------------------------------------------------
        // Structural Visualization:
        //                6
        //              /   \
        //             2     8
        //            / \   / \
        //           0   4 7   9
        //              / \
        //             3   5
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node8.left = node7;
        node8.right = node9;
        node4.left = node3;
        node4.right = node5;

        // Run the static execution engine directly
        TreeNode result = lowestCommonAncestor(root, node2, node8);

        // Expected Output: 6
        System.out.println("LCA of 2 and 8: " + result.val);

        // Also verify Example 2: LCA(2, 4) should be 2
        TreeNode result2 = lowestCommonAncestor(root, node2, node4);
        System.out.println("LCA of 2 and 4: " + result2.val);
    }
}