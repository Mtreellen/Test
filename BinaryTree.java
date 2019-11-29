package tree.binarytree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ellen
 * @date 2019-11-27 13:16
 * @description
 */
class BinaryTree {
    Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(E);
        E.setRight(H);
        C.setLeft(F);
        C.setRight(G);
        return A;
    }
    void preOrderTransfer(Node root){
        if(root == null){
            System.out.print("null ");
            return;
        }
        System.out.print("[ " +(char)root.getVal() + " ] ");
        preOrderTransfer(root.getLeft());
        preOrderTransfer(root.getRight());
    }
    void inOrderTransfer(Node root){
        if(root == null){
            System.out.print("null ");
            return;
        }
        inOrderTransfer(root.getLeft());
        System.out.print("[ " +(char)root.getVal() + " ] ");
        inOrderTransfer(root.getRight());
    }
    void postOrderTransfer(Node root){
        if(root == null){
            System.out.print("null ");
            return;
        }
        postOrderTransfer(root.getLeft());
        postOrderTransfer(root.getRight());
        System.out.print("[ " +(char)root.getVal() + " ] ");
    }

    /**
     * 二叉树中节点的个数
     * @param root：根节点（当前节点）
     * @return 二叉树节点个数
     */
    int size(Node root){
        if(root == null){
            return 0;
        }
        return size(root.getLeft()) + size(root.getRight()) + 1;
    }
    private static int size = 0;
    int size1(Node root){
        if(root == null){
            return 0;
        }
        size++;
        size1(root.getLeft());
        size1(root.getRight());
        return size;
    }
    int getLeafSize(Node root){
        // 别忘了这个判断！！！
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        return getLeafSize(root.getLeft()) + getLeafSize(root.getRight());
    }
    static int leafSize = 0;
    int getLeafSize1(Node root){
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            leafSize++;
        }
        getLeafSize1(root.getLeft());
        getLeafSize1(root.getRight());
        return leafSize;
    }
    Node find(Node root, int val){
        if(root == null){
            return null;
        }
        if(root.getVal() == val){
            return root;
        }
        Node ret = find(root.getLeft(), val);
        if(ret != null){
            return ret;
        }
        Node ret1 = find(root.getLeft(), val);
        if(ret != null){
            return ret1;
        }
        return null;
    }

    List<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.add(root.getVal());
        List<Integer> left = preorderTraversal(root.getLeft());
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.getRight());
        list.addAll(right);
        return list;
    }
    List<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> left = inorderTraversal(root.getLeft());
        list.addAll(left);
        list.add(root.getVal());
        List<Integer> right = inorderTraversal(root.getRight());
        list.addAll(right);
        return list;
    }
    List<Integer> postorderTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> left = postorderTraversal(root.getLeft());
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.getRight());
        list.addAll(right);
        list.add(root.getVal());
        return list;
    }
}
