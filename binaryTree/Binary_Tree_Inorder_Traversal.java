import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * PROBLEM STATEMENT: LeetCode 94 - Binary Tree Inorder Traversal
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * * Traversal Rule: Inorder visits nodes in the strict order: LEFT -> ROOT -> RIGHT
 * * Follow-up Challenge: The recursive solution is trivial, do it iteratively using a Stack.
 * * Constraints:
 * ● The number of nodes in the tree is in the range [0, 100].
 * ● -100 <= Node.val <= 100
 */

// WHAT: Non-public package-isolated structural TreeNode class.
// WHY: Prevents name collision errors if you practice multiple tree problems in the same folder.
class TreeNodeInorder {
    int val;
    TreeNodeInorder left;
    TreeNodeInorder right;
    
    TreeNodeInorder(int val) { 
        this.val = val; 
    }
}

// WHAT: Main execution class matching your required filename pattern.
public class Binary_Tree_Inorder_Traversal {

    // WHAT: Static iterative method to compute the inorder sequence.
    // WHY: Uses an explicit java.util.Stack to mimic the system call stack, 
    // satisfying the iterative constraint without risking a stack overflow.
    public static List<Integer> inorderTraversal(TreeNodeInorder root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNodeInorder> stack = new Stack<>();
        TreeNodeInorder curr = root;

        // WHAT: Core iterative exploration engine.
        // WHY: Runs as long as we are standing on a valid node OR have parent pointers 
        // cached in the stack waiting to be processed.
        while (curr != null || !stack.isEmpty()) {
            
            // 1. LEFT STEP: Push the current node and dive as deep left as possible.
            // WHY: Inorder traversal demands that the furthest-left child must be handled first.
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. ROOT STEP: Pop the deepest left-end parent and record its value.
            // WHY: When 'curr' hits null, we have reached a left dead-end. The node on top 
            // of the stack is the immediate parent that must be processed next.
            curr = stack.pop();
            result.add(curr.val);

            // 3. RIGHT STEP: Shift our pointer to explore the right subtree branch.
            // WHY: After the entire left branch and the parent node are cleared, the right path 
            // must be evaluated using the exact same logic.
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- RUNNING ITERATIVE BINARY TREE INORDER TRAVERSAL ---");

        // -------------------------------------------------------------
        // SETUP SAMPLE INPUT: root = [1, null, 2, 3]
        // -------------------------------------------------------------
        // Structural Visualization:
        //     1
        //      \
        //       2
        //      /
        //     3
        TreeNodeInorder root = new TreeNodeInorder(1);
        root.right = new TreeNodeInorder(2);
        root.right.left = new TreeNodeInorder(3);

        // Run the static logic sequence directly
        List<Integer> output = inorderTraversal(root);

        // Expected Output: [1, 3, 2]
        System.out.println("Inorder Output: " + output);
    }
}