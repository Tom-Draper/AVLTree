class AVLTree {

    AVLTreeNode root;

    public AVLTree() {
        this.root = new AVLTreeNode(null);
    }

    public void createTestTree() {
        insert("1");
        insert("2");
        insert("3");
        insert("4");
        insert("5");
        insert("6");
        insert("7");
    }

    // Print using pre-order traversal
    public void printPreorder(AVLTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        printPreorder(node.left); 
        printPreorder(node.right); 
    }

    public void print() {
        printPreorder(root);
    }

    // Search using pre-order traversal
    private boolean searchPreorder(AVLTreeNode node, String e) {
        if (node.value == e) {
            return true;
        }
        searchPreorder(node.left, e); 
        searchPreorder(node.right, e); 
        return false;
    }

    public boolean inTree(String e) {
        return searchPreorder(root, e);
    }

    public void insert(String e) {
        if (root.value == null) {
            root = new AVLTreeNode(e);
        }
    }

    public void insertBalanced(String e) {
        // TODO implement this
    }
}