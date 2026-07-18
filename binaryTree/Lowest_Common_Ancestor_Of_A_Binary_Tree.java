/*
 * PROBLEM STATEMENT: LeetCode 236 - Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes p and q. A node can be a descendant of itself (per LCA definition).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [2, 10^5].
 * ● -10^9 <= Node.val <= 10^9
 * ● All Node.val are unique.
 * ● p != q, and both p and q exist in the tree.
 */

public class Lowest_Common_Ancestor_Of_A_Binary_Tree {

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
    // WHY: Directly delegates to the recursive helper — the entire logic
    // fits naturally into one bottom-up recursive function, no extra
    // global state needed (unlike Max Path Sum, which needed a tracker).
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    // WHAT: Post-order recursive search that returns what it "found" in
    // the subtree rooted at 'node' — either p, q, their LCA, or null.
    // WHY: By fully exploring left AND right subtrees first (post-order),
    // we can compare their results and decide, at THIS level, whether
    // this node is the meeting point (LCA) of p and q.
    private static TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        // 1. BASE CASE - NULL NODE: An empty subtree contains neither p nor q.
        // WHY: This naturally terminates recursion at leaf children.
        if (node == null) {
            return null;
        }

        // 2. BASE CASE - FOUND A TARGET: If this node IS p or IS q, return
        // it immediately without searching deeper in this subtree.
        // WHY: We don't need to look further down — even if the OTHER
        // target lives below this node, this node itself is still a valid
        // ancestor candidate. Let the caller (parent) figure out the rest.
        if (node == p || node == q) {
            return node;
        }

        // 3. SEARCH LEFT SUBTREE: Recursively look for p/q on the left side.
        TreeNode leftResult = findLCA(node.left, p, q);

        // 4. SEARCH RIGHT SUBTREE: Recursively look for p/q on the right side.
        TreeNode rightResult = findLCA(node.right, p, q);

        // 5. DECISION - BOTH SIDES FOUND SOMETHING: This means p was found
        // on one side and q on the other (or one of them IS a child branch
        // result equal to p/q directly) — so THIS node is the meeting
        // point, i.e., the LCA.
        // WHY: p and q diverge into different subtrees exactly at their LCA.
        if (leftResult != null && rightResult != null) {
            return node;
        }

        // 6. DECISION - ONLY LEFT FOUND SOMETHING: Whatever was found
        // (could be p, q, or an already-resolved LCA) must propagate
        // upward unchanged, since the right side had nothing relevant.
        if (leftResult != null) {
            return leftResult;
        }

        // 7. DECISION - ONLY RIGHT FOUND SOMETHING (or neither): Same
        // logic as above, mirrored. If both are null, this naturally
        // returns null too (rightResult would be null).
        return rightResult;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING LOWEST COMMON ANCESTOR OF A BINARY TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [3,5,1,6,2,0,8,null,null,7,4]
        // p = 5, q = 1
        // -------------------------------------------------------------
        // Structural Visualization:
        //                3
        //              /   \
        //             5     1
        //            / \   / \
        //           6   2 0   8
        //              / \
        //             7   4
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        // Run the static execution engine directly
        TreeNode result = lowestCommonAncestor(root, node5, node1);

        // Expected Output: 3
        System.out.println("LCA of 5 and 1: " + result.val);

        // Also verify Example 2: LCA(5, 4) should be 5
        TreeNode result2 = lowestCommonAncestor(root, node5, node4);
        System.out.println("LCA of 5 and 4: " + result2.val);
    }
}