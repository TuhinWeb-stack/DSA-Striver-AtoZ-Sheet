import java.util.ArrayList;
import java.util.List;

/*
 * PROBLEM STATEMENT: LeetCode 145 - Binary Tree Postorder Traversal
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * * Traversal Rule: Postorder visits nodes in the strict order: LEFT -> RIGHT -> ROOT
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 100].
 * ● -100 <= Node.val <= 100
 */

// WHAT: Non-public package-isolated structural TreeNode class.
// WHY: Prevents name collision errors if you practice multiple tree problems in the same folder.
class TreeNodePostorder {
    int val;
    TreeNodePostorder left;
    TreeNodePostorder right;
    
    TreeNodePostorder(int val) { 
        this.val = val; 
    }
}

// WHAT: Main execution class matching your required filename pattern.
public class Binary_Tree_Postorder_Traversal {

    // WHAT: Static entry method that allocates our output list pool.
    // WHY: Eliminates the need to instantiate an object of the outer class inside main().
    public static List<Integer> postorderTraversal(TreeNodePostorder root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    // WHAT: Recursive processing engine that tracks depth state.
    private static void traverse(TreeNodePostorder node, List<Integer> result) {
        // Base Case: If we step onto an empty node link, bounce safely back up the call stack.
        if (node == null) {
            return;
        }

        // 1. LEFT STEP: Recursively clear the entire left subtree branch first.
        // WHY: Postorder traversal requires evaluating children before processing parents.
        traverse(node.left, result);

        // 2. RIGHT STEP: Recursively clear the entire right subtree branch.
        traverse(node.right, result);

        // 3. ROOT STEP: Log the current node value last.
        // WHY: The parent node can only be recorded after both subtrees are completely finished.
        result.add(node.val);
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE POSTORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [1, null, 2, 3]
        // -------------------------------------------------------------
        // Structural Visualization:
        //     1
        //      \
        //       2
        //      /
        //     3
        TreeNodePostorder root = new TreeNodePostorder(1);
        root.right = new TreeNodePostorder(2);
        root.right.left = new TreeNodePostorder(3);

        // Run the static logic sequence directly
        List<Integer> output = postorderTraversal(root);

        // Expected Output: [3, 2, 1]
        System.out.println("Postorder Output: " + output);
    }
}