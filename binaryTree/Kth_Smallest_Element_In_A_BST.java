/*
 * PROBLEM STATEMENT: LeetCode 230 - Kth Smallest Element in a BST
 * Given the root of a BST and an integer k, return the kth smallest
 * value (1-indexed) among all node values in the tree.
 *
 * Constraints:
 * ● The number of nodes in the tree is n, where 1 <= k <= n <= 10^4.
 * ● 0 <= Node.val <= 10^4
 *
 * Follow-up target: efficient repeated kth-smallest queries under
 * frequent insert/delete operations (discussed after the solution).
 */

public class Kth_Smallest_Element_In_A_BST {

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
    // WHY: Uses array-wrapped counters (count, result) so the recursive
    // in-order helper can carry and update shared state across calls -
    // plain local variables would reset on every recursive call and
    // couldn't "remember" progress between left/node/right steps.
    public static int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];  // tracks how many nodes visited so far
        int[] result = new int[1]; // stores the answer once found

        inorder(root, k, count, result);

        return result[0];
    }

    // WHAT: In-order traversal (Left -> Node -> Right) that visits BST
    // nodes in ascending sorted order, stopping early once the kth node
    // is reached.
    // WHY: In-order traversal on a BST is GUARANTEED to produce values
    // in sorted order - this is the core property that makes this
    // problem trivial once recognized.
    private static void inorder(TreeNode node, int k, int[] count, int[] result) {
        // 1. BASE CASE - NULL NODE: Nothing to visit here.
        // WHY: Also acts as an early-exit guard - if count[0] already
        // reached k in a sibling branch, we don't want to keep recursing
        // pointlessly (see step 2 for the actual short-circuit check).
        if (node == null) {
            return;
        }

        // 2. EARLY EXIT CHECK: If we've already found our answer in an
        // earlier part of the traversal, stop doing any further work.
        // WHY: Without this, we'd keep traversing the rest of the tree
        // even after finding the kth smallest - wasteful once k is small
        // and the tree is large.
        if (count[0] >= k) {
            return;
        }

        // 3. GO LEFT FIRST: Explore all smaller values before this node.
        // WHY: This is what guarantees ascending order - everything in
        // the left subtree is smaller and must be counted before we count
        // the current node itself.
        inorder(node.left, k, count, result);

        // 4. VISIT CURRENT NODE: Increment the counter - we've now
        // "seen" one more value in sorted order.
        count[0]++;

        // WHY: The moment our running count matches k, THIS node's value
        // is exactly the kth smallest - record it as the answer.
        if (count[0] == k) {
            result[0] = node.val;
            return; // WHY: no need to explore the right subtree at all now
        }

        // 5. GO RIGHT: Only reached if we haven't found the kth element
        // yet - explore larger values next, in sorted order.
        inorder(node.right, k, count, result);
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING KTH SMALLEST ELEMENT IN A BST ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 2): root = [5,3,6,2,4,null,null,1], k = 3
        // -------------------------------------------------------------
        // Structural Visualization:
        //              5
        //            /   \
        //           3     6
        //          / \
        //         2   4
        //        /
        //       1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        // Run the static execution engine directly
        int result = kthSmallest(root, 3);

        // Expected Output: 3 (sorted order is 1,2,3,4,5,6 -> 3rd smallest is 3)
        System.out.println("3rd Smallest Element: " + result);
    }
}