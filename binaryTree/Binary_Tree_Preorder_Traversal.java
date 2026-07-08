import java.util.ArrayList;
import java.util.List;

/*
 * PROBLEM STATEMENT: LeetCode 144 - Binary Tree Preorder Traversal
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * * Traversal Rule: Preorder visits nodes in the strict order: ROOT -> LEFT -> RIGHT
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 100].
 * ● -100 <= Node.val <= 100
 */

// WHAT: Non-public package-isolated structural TreeNode class.
// WHY: Prevents name collision errors if you have other tree problems practicing in the same directory.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) { 
        this.val = val; 
    }
}

// WHAT: Main execution class matching your exact filename requirement.
public class Binary_Tree_Preorder_Traversal {

    // WHAT: Static entry method that allocates our output list pool.
    // WHY: Eliminates the need to instantiate an object of the outer class inside main().
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    // WHAT: Recursive processing engine that tracks depth state.
    private static void traverse(TreeNode node, List<Integer> result) {
        // Base Case: If we step onto an empty node link, bounce safely back up the call stack.
        if (node == null) {
            return;
        }

        // 1. ROOT STEP: Log the current node value immediately.
        // WHY: Preorder mandates processing the parent node before descending into child subtrees.
        result.add(node.val);

        // 2. LEFT STEP: Recursively clear the entire left subtree branch.
        traverse(node.left, result);

        // 3. RIGHT STEP: Recursively clear the remaining right subtree branch.
        traverse(node.right, result);
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING BINARY TREE PREORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [1, null, 2, 3]
        // -------------------------------------------------------------
        // Structural Visualization:
        //     1
        //      \
        //       2
        //      /
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Run the static logic sequence directly
        List<Integer> output = preorderTraversal(root);

        // Expected Output: [1, 2, 3]
        System.out.println("Preorder Output: " + output);
    }
}