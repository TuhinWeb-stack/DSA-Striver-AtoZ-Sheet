/*
 * PROBLEM STATEMENT: LeetCode 987 - Vertical Order Traversal of a Binary Tree
 * Given the root of a binary tree, calculate the vertical order traversal.
 * Each node is at position (row, col); left child = (row+1, col-1),
 * right child = (row+1, col+1). Group nodes by column (left to right),
 * ordered top-to-bottom by row; ties at the same (row, col) are broken
 * by ascending node value.
 *
 * Constraints:
 * ● The number of nodes in the tree is in the range [1, 1000].
 * ● 0 <= Node.val <= 1000
 */

import java.util.*;

public class Vertical_Order_Traversal_Of_A_Binary_Tree {

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

    // WHAT: Small helper record to carry (row, val) together into a column's list.
    // WHY: We need BOTH row and val stored together so we can sort by row first,
    // then by val on ties — a plain List<Integer> would lose the row info needed
    // for correct tie-breaking.
    private static class NodeInfo {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    // WHAT: Static entry point matching LeetCode's method layout signature.
    // WHY: Orchestrates two clear phases — (1) traverse & bucket nodes by column,
    // (2) sort each bucket and flatten into the final answer.
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. EDGE CASE: Empty tree has nothing to traverse.
        if (root == null) {
            return result;
        }

        // 2. COLUMN MAP: TreeMap auto-sorts keys (columns) in ascending order,
        // so column -2, -1, 0, 1, 2... come out already left-to-right —
        // no manual sorting of columns needed later.
        // WHY: This directly matches the required "leftmost to rightmost" output order.
        TreeMap<Integer, List<NodeInfo>> columnMap = new TreeMap<>();

        // 3. BFS SETUP: We track (node, row, col) together since a plain
        // Queue<TreeNode> would lose position info as we move through levels.
        // WHY: BFS naturally lets us compute row/col by simply +1/-1/+1 from parent,
        // without needing extra global counters.
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0}); // node, row, col

        // 4. BFS TRAVERSAL: Visit every node, bucket it by its column.
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            TreeNode node = (TreeNode) current[0];
            int row = (int) current[1];
            int col = (int) current[2];

            // WHY: computeIfAbsent creates a new list for a column the first time
            // we see it, otherwise reuses the existing list — avoids manual
            // null-checking boilerplate.
            columnMap.computeIfAbsent(col, k -> new ArrayList<>())
                     .add(new NodeInfo(row, node.val));

            // WHY: Push children with updated row/col so their position is
            // correctly computed relative to the parent, per problem definition.
            if (node.left != null) {
                queue.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }

        // 5. SORT & FLATTEN: For each column (already in left-to-right order
        // thanks to TreeMap), sort its nodes by row first, then by value on ties.
        for (List<NodeInfo> columnNodes : columnMap.values()) {
            // WHY: Comparator chains row comparison first (primary key), then
            // falls back to val comparison (secondary key / tie-breaker) —
            // this directly implements the problem's ordering rule.
            columnNodes.sort((a, b) -> {
                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                }
                return Integer.compare(a.val, b.val);
            });

            // WHY: Extract just the values (drop row info) since that's all
            // the final output format requires.
            List<Integer> columnValues = new ArrayList<>();
            for (NodeInfo info : columnNodes) {
                columnValues.add(info.val);
            }
            result.add(columnValues);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING VERTICAL ORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT (Example 2): root = [1,2,3,4,5,6,7]
        // -------------------------------------------------------------
        // Structural Visualization:
        //           1
        //          / \
        //         2   3
        //        / \ / \
        //       4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Run the static execution engine directly
        List<List<Integer>> result = verticalTraversal(root);

        // Expected Output: [[4],[2],[1,5,6],[3],[7]]
        System.out.println("Vertical Order Traversal: " + result);
    }
}