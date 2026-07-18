/*
 * PROBLEM STATEMENT: LeetCode 199 - Binary Tree Right Side View
 * Given the root of a binary tree, return the values of the nodes visible
 * when standing on the right side of the tree, ordered top to bottom
 * (i.e., the rightmost node at each level).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [0, 100].
 * ● -100 <= Node.val <= 100
 */

import java.util.*;

public class Binary_Tree_Right_Side_View {

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
    // WHY: Runs a standard BFS level-order traversal, capturing only the
    // LAST node's value seen at each level (the rightmost visible node).
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 1. EDGE CASE: Empty tree has no levels, hence nothing visible.
        // WHY: Prevents pushing a null root into the queue, which would
        // crash the very first poll().
        if (root == null) {
            return result;
        }

        // 2. QUEUE SETUP: Standard BFS uses a queue to process nodes level-by-level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 3. MAIN BFS LOOP: Keep going while there are nodes left to process.
        while (!queue.isEmpty()) {
            // 3a. LEVEL SIZE SNAPSHOT: Freeze how many nodes belong to THIS
            // level before the inner loop starts adding children to the queue.
            // WHY: Without this snapshot, queue.size() would keep growing
            // mid-loop and we'd lose track of level boundaries.
            int levelSize = queue.size();

            // 3b. PROCESS EXACTLY ONE LEVEL: Loop only levelSize times.
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // WHY: If this is the LAST node in the current level's
                // left-to-right processing order, it's the rightmost node —
                // exactly the one visible from the right side.
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // WHY: Always push left before right — this guarantees the
                // queue processes nodes in true left-to-right order, which
                // is what makes "last node in the loop" == "rightmost node".
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE RIGHT SIDE VIEW ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [1,2,3,null,5,null,4]
        // -------------------------------------------------------------
        // Structural Visualization:
        //          1
        //         / \
        //        2   3
        //         \    \
        //          5    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Run the static execution engine directly
        List<Integer> result = rightSideView(root);

        // Expected Output: [1, 3, 4]
        System.out.println("Right Side View: " + result);
    }
}