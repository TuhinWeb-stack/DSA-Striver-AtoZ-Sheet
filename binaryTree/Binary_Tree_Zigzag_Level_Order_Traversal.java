/*
 * PROBLEM STATEMENT: LeetCode 103 - Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal
 * of its nodes' values (left to right, then right to left, alternating
 * for each level).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [0, 2000].
 * ● -100 <= Node.val <= 100
 */

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

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
    // WHY: Runs a standard BFS level-order traversal, then reverses every
    // alternate level's list before adding it to the final result.
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. EDGE CASE: Empty tree has no levels to traverse.
        // WHY: Avoids adding a null node into the queue, which would crash later.
        if (root == null) {
            return result;
        }

        // 2. SETUP QUEUE: Standard BFS uses a queue to process nodes level-by-level.
        // WHY: Queue (FIFO) guarantees we process nodes in the order they were
        // discovered, which naturally groups nodes level by level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 3. LEVEL TRACKER: Toggles direction for each level processed.
        // WHY: false = left-to-right (natural order), true = right-to-left (reversed).
        boolean reverseThisLevel = false;

        // 4. MAIN BFS LOOP: Keep going while there are nodes left to process.
        while (!queue.isEmpty()) {
            // 4a. LEVEL SIZE SNAPSHOT: Capture how many nodes belong to THIS level
            // WHY: queue.size() changes as we add children, so we must "freeze"
            // the count before the inner loop starts modifying the queue.
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            // 4b. PROCESS EXACTLY ONE LEVEL: Loop only levelSize times.
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // WHY: Add to the level list in natural left-to-right order first;
                // we'll reverse the whole list afterward if needed (simpler than
                // conditionally inserting at front/back during collection).
                currentLevel.add(node.val);

                // WHY: Push children in left-then-right order regardless of
                // zigzag direction — the QUEUE processing order must stay
                // consistent; only the OUTPUT list order flips.
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 4c. APPLY ZIGZAG: Reverse this level's list if flag says so.
            // WHY: This is the only step that actually creates the "zigzag" effect.
            if (reverseThisLevel) {
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);

            // 4d. TOGGLE DIRECTION: Flip for the next level.
            // WHY: Zigzag alternates EVERY level, so we flip after each level completes.
            reverseThisLevel = !reverseThisLevel;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE ZIGZAG LEVEL ORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [3,9,20,null,null,15,7]
        // -------------------------------------------------------------
        // Structural Visualization:
        //         3
        //        / \
        //       9   20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Run the static execution engine directly
        List<List<Integer>> result = zigzagLevelOrder(root);

        // Expected Output: [[3],[20,9],[15,7]]
        System.out.println("Zigzag Level Order: " + result);
    }
}