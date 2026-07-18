/*
 * PROBLEM STATEMENT: LeetCode 662 - Maximum Width of Binary Tree
 * Given the root of a binary tree, return the maximum width of the tree.
 * Width of a level = distance between leftmost and rightmost non-null
 * nodes, INCLUDING null gaps between them (as if extended to a complete
 * binary tree at that level).
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [1, 3000].
 * ● -100 <= Node.val <= 100
 * ● The answer is guaranteed to fit in a 32-bit signed integer.
 */

import java.util.*;

public class Maximum_Width_Of_Binary_Tree {

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

    // WHAT: Bundles a node together with its "complete binary tree" index.
    // WHY: A plain Queue<TreeNode> has no room to carry the positional
    // index alongside each node, and we need BOTH together to compute width.
    private static class QueueEntry {
        TreeNode node;
        long index; // WHY long: prevents overflow in deep, skewed trees

        QueueEntry(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    // WHAT: Static entry point matching LeetCode's method layout signature.
    // WHY: Runs BFS while assigning "complete binary tree" indices to each
    // node, tracking the widest (first-to-last index span) level seen.
    public static int widthOfBinaryTree(TreeNode root) {
        // 1. EDGE CASE: Single/empty guard - not strictly needed since
        // constraints guarantee at least 1 node, but kept for safety.
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;

        Queue<QueueEntry> queue = new LinkedList<>();
        queue.offer(new QueueEntry(root, 0)); // root starts at index 0

        // 2. MAIN BFS LOOP: Process the tree level by level.
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // WHY: We need the index of the very first node processed in
            // this level to (a) compute width, and (b) re-base later indices
            // in this level to prevent overflow.
            long firstIndexInLevel = queue.peek().index;

            long firstIndex = 0;
            long lastIndex = 0;

            // 3. PROCESS EXACTLY ONE LEVEL: Loop only levelSize times.
            for (int i = 0; i < levelSize; i++) {
                QueueEntry current = queue.poll();
                TreeNode node = current.node;

                // WHY: Re-base (normalize) the index relative to the first
                // node's index in THIS level. This keeps numbers small even
                // in deep skewed trees, preventing overflow, while the
                // RELATIVE distance (width) stays mathematically identical.
                long normalizedIndex = current.index - firstIndexInLevel;

                if (i == 0) {
                    firstIndex = normalizedIndex;
                }
                if (i == levelSize - 1) {
                    lastIndex = normalizedIndex;
                }

                // WHY: Standard complete-binary-tree indexing — left child
                // is always 2*i, right child is always 2*i + 1, computed
                // from the ORIGINAL (non-normalized) index to stay consistent
                // with children pushed by sibling nodes in the same level.
                if (node.left != null) {
                    queue.offer(new QueueEntry(node.left, current.index * 2));
                }
                if (node.right != null) {
                    queue.offer(new QueueEntry(node.right, current.index * 2 + 1));
                }
            }

            // 4. UPDATE MAX WIDTH: width = last - first + 1 for this level.
            // WHY: +1 because width counts INCLUSIVE of both endpoints
            // (e.g., indices 0 and 3 span positions 0,1,2,3 -> width 4).
            int currentWidth = (int) (lastIndex - firstIndex + 1);
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING MAXIMUM WIDTH OF BINARY TREE ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 1): root = [1,3,2,5,3,null,9]
        // -------------------------------------------------------------
        // Structural Visualization:
        //              1
        //            /   \
        //           3     2
        //          / \      \
        //         5   3      9
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Run the static execution engine directly
        int result = widthOfBinaryTree(root);

        // Expected Output: 4 (level 3: nodes 5,3,null,9 -> indices 0,1,2,3)
        System.out.println("Maximum Width: " + result);
    }
}