import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * PROBLEM STATEMENT: LeetCode 102 - Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * * Traversal Rule: Visit nodes left-to-right, level-by-level (Breadth-First Search).
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 2000].
 * ● -1000 <= Node.val <= 1000
 */

// WHAT: Non-public package-isolated structural TreeNode class.
// WHY: Prevents name collision errors if you practice multiple tree problems in the same folder.
class TreeNodeLevelOrder {
    int val;
    TreeNodeLevelOrder left;
    TreeNodeLevelOrder right;
    
    TreeNodeLevelOrder(int val) { 
        this.val = val; 
    }
}

// WHAT: Main execution class matching your required filename pattern.
public class Binary_Tree_Level_Order_Traversal {

    // WHAT: Static method to compute the level order layout.
    // WHY: Uses a Queue (FIFO - First In First Out) to process tree horizons uniformly.
    public static List<List<Integer>> levelOrder(TreeNodeLevelOrder root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base Case: If the tree is empty, return the empty result list immediately.
        if (root == null) {
            return result;
        }

        Queue<TreeNodeLevelOrder> queue = new LinkedList<>();
        queue.add(root);

        // WHAT: Core horizontal search engine loop.
        // WHY: Continues running as long as there is another layer of child nodes beneath us.
        while (!queue.isEmpty()) {
            // CRITICAL STEP: Capture the exact number of nodes belonging to the current level.
            // WHY: The queue size grows dynamically when we add child elements. Locking down 
            // the size now ensures we only pull out nodes belonging to this specific level.
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();

            // WHAT: Process all nodes on the current horizontal row.
            for (int i = 0; i < levelSize; i++) {
                TreeNodeLevelOrder currentNode = queue.poll();
                currentLevelList.add(currentNode.val);

                // If a left child exists, stage it in the queue for the next level sweep.
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // If a right child exists, stage it in the queue for the next level sweep.
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Save the finished horizontal row layer to our overarching master list.
            result.add(currentLevelList);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE LEVEL ORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [3, 9, 20, null, null, 15, 7]
        // -------------------------------------------------------------
        // Structural Visualization:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNodeLevelOrder root = new TreeNodeLevelOrder(3);
        root.left = new TreeNodeLevelOrder(9);
        root.right = new TreeNodeLevelOrder(20);
        root.right.left = new TreeNodeLevelOrder(15);
        root.right.right = new TreeNodeLevelOrder(7);

        // Run the static layer execution directly
        List<List<Integer>> output = levelOrder(root);

        // Expected Output: [[3], [9, 20], [15, 7]]
        System.out.println("Level Order Output: " + output);
    }
}