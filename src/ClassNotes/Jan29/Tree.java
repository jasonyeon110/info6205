package ClassNotes.Jan29;

public class Tree {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        initTree(tree);
        tree.prinfLeftView();
        System.out.println();


    }

    private static void initTree(BinaryTree<Integer> tree){
        tree.root = new Node<Integer>(1);

        tree.root.left = new Node<Integer>(2);
        tree.root.right = new Node<Integer>(3);

        tree.root.left.left = new Node<Integer>(4);
        tree.root.left.right = new Node<Integer>(5);

        tree.root.left.left.left = new Node<Integer>(8);
        tree.root.left.right.left = new Node<Integer>(9);

        tree.root.right.left = new Node<Integer>(6);
        tree.root.right.right = new Node<Integer>(7);

        tree.root.right.left.right = new Node<Integer>(10);
        tree.root.right.right.right = new Node<Integer>(11);


    }
}
