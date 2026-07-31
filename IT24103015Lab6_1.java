class Node {
    int empId;
    String empName;
    Node left, right;

    public Node(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
        left = right = null;
    }

    public void displayNode() {
        System.out.println("Employee ID: " + empId + ", Name: " + empName);
    }
}


class Tree {
    Node root;

    public void insert(int empId, String empName) {
        root = insertRec(root, empId, empName);
    }

    private Node insertRec(Node current, int empId, String empName) {
        if (current == null) {
            return new Node(empId, empName);
        }
        if (empId < current.empId) {
            current.left = insertRec(current.left, empId, empName);
        } else {
            current.right = insertRec(current.right, empId, empName);
        }
        return current;
    }

    public Node find(int empId) {
        Node current = root;
        while (current != null) {
            if (empId == current.empId) return current;
            current = (empId < current.empId) ? current.left : current.right;
        }
        return null;
    }

    public Node findRecursive(int empId) {
        return findRec(root, empId);
    }

    private Node findRec(Node current, int empId) {
        if (current == null || current.empId == empId) return current;
        return (empId < current.empId) ? findRec(current.left, empId) : findRec(current.right, empId);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            current.displayNode();
            inOrderRec(current.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node current) {
        if (current != null) {
            current.displayNode();
            preOrderRec(current.left);
            preOrderRec(current.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node current) {
        if (current != null) {
            postOrderRec(current.left);
            postOrderRec(current.right);
            current.displayNode();
        }
    }

    public void deleteAll() {
        root = null;
        System.out.println("All nodes have been deleted.");
    }
}
public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(10, "Dinusha");
        tree.insert(11, "Tharushika");
        tree.insert(12, "Chamika");

        System.out.println("In-order Traversal:");
        tree.inOrder();

        System.out.println("\nFind Recursive (1002):");
        Node result = tree.findRecursive(1002);
        if (result != null) result.displayNode();

        tree.deleteAll();
    }
}

