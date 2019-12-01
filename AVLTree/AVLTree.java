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
        calcTreeBalance(root);
    }

    // Print using pre-order traversal
    private void printPreorder(AVLTreeNode node, int height) {
        if (node == null) {
            return;
        }
        String indent = new String(new char [height]).replace("\0", "  ");
        System.out.println(indent + node.value);
        printPreorder(node.left, height + 1); 
        printPreorder(node.right, height + 1); 
    }

    // Starts the process of recursively printing the tree using pre-order traversal
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

    // Check whether a value is in the tree
    public boolean inTree(String e) {
        return searchPreorder(root, e);
    }
    
    // Calculates the height of a node.
    public int calcHeight(AVLTreeNode node) {
        if (node == null) {
            return -1; // Cancels out last 1 added
        }
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.right == null) {
            return 1 + calcHeight(node.left);
        } else if (node.left == null) {
            return 1 + calcHeight(node.right);
        } else {
            // Get the tallest sub-tree between the two
            return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
        }
    }

    // Calculates balance for a particular node
    public void calcBalance(AVLTreeNode node) {
        node.balance = calcHeight(node.right) - calcHeight(node.left);
    }

    // Calculates balance for input node and all nodes below it
    public void calcTreeBalance(AVLTreeNode node) {
        if (node == null) {
            return;
        }
        node.balance = calcHeight(node.right) - calcHeight(node.left);
        calcTreeBalance(node.left);
        calcTreeBalance(node.right);
    }

    // Binary tree insertion
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

    // Insertion that retains balance 
    public void insertBalanced(String e) {
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
}