/*
 * PROBLEM STATEMENT: LeetCode 450 - Delete Node in a BST
 * Given the root of a BST and a key, delete the node with that value
 * (if it exists) while keeping the tree a valid BST. Return the
 * (possibly updated) root.
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [0, 10^4].
 * ● -10^5 <= Node.val <= 10^5
 * ● Each node has a unique value.
 * ● root is guaranteed to be a valid BST.
 * ● -10^5 <= key <= 10^5
 *
 * Follow-up target: O(height of tree) time complexity.
 */

public class Delete_Node_In_A_BST {

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
    // WHY: Directly delegates to the recursive delete helper - the entire
    // search-then-delete logic fits into one self-linking recursive function.
    public static TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    // WHAT: Recursive helper that finds 'key' (BST search) and, once found,
    // removes it while restructuring the subtree to stay a valid BST.
    // WHY: Every call RETURNS what should sit at this position now - the
    // parent automatically re-links (node.left = ... / node.right = ...)
    // as recursion unwinds, same self-linking trick as Insert.
    private static TreeNode delete(TreeNode node, int key) {
        // 1. BASE CASE - KEY NOT FOUND: We've run out of tree to search,
        // meaning key doesn't exist here - nothing to delete.
        if (node == null) {
            return null;
        }

        // 2. SEARCH PHASE - GO LEFT: key is smaller, BST guarantees it can
        // only exist (if at all) in the left subtree.
        if (key < node.val) {
            node.left = delete(node.left, key);
        }
        // 3. SEARCH PHASE - GO RIGHT: key is larger, must be in right subtree.
        else if (key > node.val) {
            node.right = delete(node.right, key);
        }
        // 4. FOUND THE NODE TO DELETE: key == node.val, now handle the
        // 3 possible deletion cases.
        else {
            // 4a. CASE A - NO LEFT CHILD: Includes both "leaf node" (no
            // children at all) AND "only has a right child" situations.
            // WHY: If left is null, we can simply promote right (which
            // might itself be null for a true leaf, or a real subtree)
            // to take this node's place - no ordering is violated either way.
            if (node.left == null) {
                return node.right;
            }
            // 4b. CASE B - NO RIGHT CHILD (but left exists): Symmetric to
            // above - promote the left child to take this node's place.
            else if (node.right == null) {
                return node.left;
            }
            // 4c. CASE C - TWO CHILDREN: The tricky case. We find the
            // inorder successor (smallest value in right subtree), copy
            // its value here, then delete the successor's original spot.
            else {
                // WHY: The smallest value in node.right is guaranteed to be
                // bigger than everything in node.left, and smaller than
                // everything else in node.right - perfect replacement that
                // preserves BST ordering.
                int successorVal = findMin(node.right);

                // WHY: Overwrite this node's value with the successor's
                // value - effectively "moving" the successor here.
                node.val = successorVal;

                // WHY: Now node.right has a DUPLICATE of successorVal sitting
                // in its original position - recursively delete that
                // duplicate. This recursive call will hit Case A or B,
                // since the minimum node in a subtree can only have a
                // right child (never a left one, by definition of "minimum").
                node.right = delete(node.right, successorVal);
            }
        }

        // 5. RETURN THE (POSSIBLY MODIFIED) NODE: For search-phase cases
        // (2 and 3), this node itself wasn't deleted - just return it as-is
        // so the caller re-attaches it unchanged (or with an updated child
        // pointer from the recursive call).
        return node;
    }

    // WHAT: Standard BST helper - finds the smallest value in a subtree.
    // WHY: In a BST, the smallest value is always found by going LEFT
    // repeatedly until there's no more left child - this is exactly the
    // "inorder successor" we need for Case C deletion.
    private static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING DELETE NODE IN A BST ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [5,3,6,2,4,null,7], key = 3
        // -------------------------------------------------------------
        // Structural Visualization (before delete):
        //              5
        //            /   \
        //           3     6
        //          / \      \
        //         2   4      7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Run the static execution engine directly
        TreeNode result = deleteNode(root, 3);

        // Expected Output: [5,4,6,2,null,null,7] (one valid answer)
        System.out.println("Root: " + result.val);
        System.out.println("Root.left (replaced 3): " + result.left.val);
        System.out.println("Root.left.left: " + result.left.left.val);
        System.out.println("Root.left.right: " + (result.left.right == null ? "null" : result.left.right.val));
    }
}