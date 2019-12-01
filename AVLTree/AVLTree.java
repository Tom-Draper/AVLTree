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
    public void printPreorder(AVLTreeNode node, int height) {
        if (node == null) {
            return;
        }
        String indent = new String(new char [height]).replace("\0", "  ");
        System.out.println(indent + node.value);
        printPreorder(node.left, height + 1); 
        printPreorder(node.right, height + 1); 
    }

    public void print() {
        printPreorder(root, 0);
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
        if (root.value == null) { // If tree is empty
            root = new AVLTreeNode(e);
        } else {
            AVLTreeNode node = root; // Start at root
            
            boolean done = false;
            while (!done) {
                if (e.compareTo(node.value) == 0) {
                    done = true;
                } else if (e.compareTo(node.value) < 0) {
                    if (node.left == null) {
                        node.left = new AVLTreeNode(e);
                        done = true;
                    } else {
                        node = node.left;
                    }
                } else if (e.compareTo(node.value) > 0) {
                    if (node.right == null) {
                        node.right = new AVLTreeNode(e);
                        done = true;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }

    public void insertBalanced(String e) {
        // TODO implement this
    }
}