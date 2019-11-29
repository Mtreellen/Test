package tree.binarytree;

/**
 * @author ellen
 * @date 2019-11-27 13:14
 * @description：二叉树
 */
public class Node {
    private Node left;
    private Node right;
    private int val;

    public Node(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + (char)val +
                '}';
    }
}
