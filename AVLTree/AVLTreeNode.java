class AVLTreeNode {
    String value;
    int balance;
    AVLTreeNode left, right;

    public AVLTreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}