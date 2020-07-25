import java.util.ArrayList;

public class BinaryTree<T> {

    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    /* Constructs a binary tree based on a given preorder traversal PRE and an
       inorder traversal IN. */
    public BinaryTree(ArrayList<T> pre,  ArrayList<T> in) {
        root = listHelper(pre, in);
    }

    private TreeNode listHelper(ArrayList<T> pre,  ArrayList<T> in) {
        // TODO: YOUR CODE HERE
        return null;
    }

    /* Print the values in the tree in preorder. */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /* Print the values in the tree in inorder. */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    /* Prints the BinaryTree in preorder or in inorder. Used for testing. */
    protected static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    public class TreeNode {

        KDPoint coords;
        TreeNode left;
        TreeNode right;
        String axis;
        //int splitmedian;

        public TreeNode(KDPoint item) {
            this.coords = item; left = right = null;
        }

        public TreeNode(KDPoint item, TreeNode left, TreeNode right, String axis) {
            this.coords = item;
            this.left = left;
            this.right = right;
            //this.splitmedian = splitmedian;
            this.axis = axis;
        }

        /* Prints the nodes of the BinaryTree in preorder. Used for testing. */
        private void printPreorder() {
            System.out.print(coords + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        /* Prints the nodes of the BinaryTree in inorder. Used for testing. */
        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(coords + " ");
            if (right != null) {
                right.printInorder();
            }
        }

    }
}
