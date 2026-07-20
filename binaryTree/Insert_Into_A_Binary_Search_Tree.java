/*
 * PROBLEM STATEMENT: LeetCode 701 - Insert into a Binary Search Tree
 * Given the root of a BST and a value to insert, insert it while
 * keeping the tree a valid BST, then return the root. val is guaranteed
 * to not already exist in the tree.
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [0, 10^4].
 * ● -10^8 <= Node.val <= 10^8
 * ● All Node.val are unique.
 * ● -10^8 <= val <= 10^8
 * ● val does not exist in the original BST.
 */

public class Insert_Into_A_Binary_Search_Tree {

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
    // WHY: Directly delegates to the recursive insert helper - the whole
    // insertion logic fits naturally into one self-linking recursive function.
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    // WHAT: Recursive helper that finds the correct null spot for val and
    // returns the (possibly newly-created) node that should sit at this position.
    // WHY: By having every call RETURN what belongs at its position, the
    // parent automatically re-links itself (node.left = ... / node.right = ...)
    // as the recursion unwinds - no manual parent-pointer tracking needed.
    private static TreeNode insert(TreeNode node, int val) {
        // 1. BASE CASE - FOUND THE INSERTION SPOT: We've hit null, meaning
        // this exact position is empty - this is where val belongs.
        // WHY: Creating and returning a new node here is what actually
        // performs the insertion; the caller will attach it via
        // node.left = ... or node.right = ... one level up.
        if (node == null) {
            return new TreeNode(val);
        }

        // 2. DECISION - GO LEFT: If val is smaller, it belongs somewhere
        // in the left subtree (BST property).
        // WHY: We reassign node.left to the RESULT of the recursive call -
        // if node.left was already non-null, this just re-attaches the
        // same subtree (now with val inserted deeper inside it). If
        // node.left WAS null, this attaches the brand-new node directly.
        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        // 3. DECISION - GO RIGHT: Otherwise, val belongs in the right subtree.
        // WHY: val is guaranteed not to equal node.val (no duplicates),
        // so "not less than" safely means "greater than" here.
        else {
            node.right = insert(node.right, val);
        }

        // 4. RETURN UNCHANGED NODE: This node itself isn't the insertion
        // point, so we just return it as-is, letting the CALLER re-attach
        // it to its own parent unchanged.
        // WHY: This is what makes the "self-linking" trick work - every
        // node on the path from root down to the new leaf gets its
        // left/right pointer refreshed (even if it points to the same
        // subtree as before), keeping the whole tree connected correctly.
        return node;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING INSERT INTO A BINARY SEARCH TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [4,2,7,1,3], val = 5
        // -------------------------------------------------------------
        // Structural Visualization (before insert):
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
        TreeNode result = insertIntoBST(root, 5);

        // Expected Output: [4,2,7,1,3,5] -> 5 becomes left child of 7
        System.out.println("Root value: " + result.val);
        System.out.println("Root.right value: " + result.right.val);
        System.out.println("Root.right.left value (newly inserted 5): " + result.right.left.val);
    }
}