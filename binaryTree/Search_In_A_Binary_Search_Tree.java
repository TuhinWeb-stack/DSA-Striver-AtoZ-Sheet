/*
 * PROBLEM STATEMENT: LeetCode 700 - Search in a Binary Search Tree
 * Given the root of a BST and an integer val, find the node whose value
 * equals val and return the subtree rooted at that node. Return null
 * if no such node exists.
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [1, 5000].
 * ● 1 <= Node.val <= 10^7
 * ● root is guaranteed to be a valid BST.
 * ● 1 <= val <= 10^7
 */

public class Search_In_A_Binary_Search_Tree {

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
    // WHY: Uses the BST ordering property to eliminate half the tree at
    // every step, instead of blindly checking both children like a
    // regular (non-BST) binary tree search would require.
    public static TreeNode searchBST(TreeNode root, int val) {
        // 1. BASE CASE - NULL NODE: We've run out of tree to search,
        // meaning val doesn't exist anywhere on this path.
        // WHY: This also naturally handles "target not found" - if we
        // never hit base case 2 (match), we eventually hit this and
        // return null.
        if (root == null) {
            return null;
        }

        // 2. BASE CASE - FOUND MATCH: Current node IS the target.
        // WHY: Returning 'root' here automatically returns the WHOLE
        // subtree too, since root.left and root.right pointers are
        // still intact - exactly what the problem asks for.
        if (root.val == val) {
            return root;
        }

        // 3. DECISION - GO LEFT: If val is smaller than current node's
        // value, the BST guarantees it can ONLY exist (if at all) in
        // the left subtree - no need to ever check the right side.
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // 4. DECISION - GO RIGHT: Otherwise (val > root.val), the BST
        // guarantees it can only exist in the right subtree.
        // WHY: We don't need an explicit "val > root.val" check since
        // we've already ruled out "==" and "<" above - this is the
        // only remaining case.
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING SEARCH IN A BINARY SEARCH TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [4,2,7,1,3], val = 2
        // -------------------------------------------------------------
        // Structural Visualization:
        //              4
        //            /   \
        //           2     7
        //          / \
        //         1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Run the static execution engine directly
        TreeNode result = searchBST(root, 2);

        // Expected Output: subtree rooted at 2 -> [2,1,3]
        if (result != null) {
            System.out.println("Found node with val: " + result.val);
            System.out.println("Left child: " + (result.left != null ? result.left.val : "null"));
            System.out.println("Right child: " + (result.right != null ? result.right.val : "null"));
        } else {
            System.out.println("Node not found.");
        }
    }
}