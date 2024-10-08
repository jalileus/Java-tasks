
import java.util.Scanner;

class Node {

    int data;
    Node left;
    Node right;
}

class BST {

    public Node createNewNode(int val) {
        Node new_node = new Node();
        new_node.data = val;
        new_node.left = null;
        new_node.right = null;
        return new_node;
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            return createNewNode(val);
        }
        if (val < node.data) {
            node.left = insert(node.left, val);
        } else if (val > node.data) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public void printLeafNodes(Node node) {
        if (node == null) {
            return;
        }

        printLeafNodes(node.left);

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }

        printLeafNodes(node.right);
    }
}

public class Tree {

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;
        try (Scanner reader = new Scanner(System.in)) {
            while (true) {
                int val = reader.nextInt();
                
                if (val == 0) {
                    bst.printLeafNodes(root);
                    reader.close();
                    break;
                }
                
                root = bst.insert(root, val);
            }
        }
    }
}
