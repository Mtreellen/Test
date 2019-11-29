package tree.binarytree;

/**
 * @author ellen
 * @date 2019-11-27 14:01
 * @description：二叉树
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        System.out.println("前序遍历：");
        binaryTree.preOrderTransfer(root);
        System.out.println("\n后序遍历：");
        binaryTree.postOrderTransfer(root);
        System.out.println("\n中序遍历：");
        binaryTree.inOrderTransfer(root);
        System.out.print("\n二叉树节点个数1：");
        System.out.println(binaryTree.size(root));
        System.out.print("二叉树节点个数2：");
        System.out.println(binaryTree.size1(root));
        System.out.print("二叉树叶子节点个数1：");
        System.out.println(binaryTree.getLeafSize(root));
        System.out.print("二叉树叶子节点个数2：");
        System.out.println(binaryTree.getLeafSize1(root));
        System.out.print("查找 D ：");
        System.out.println(binaryTree.find(root, 'D'));

        System.out.println(binaryTree.preorderTraversal(root));

        System.out.println(binaryTree.inorderTraversal(root));

        System.out.println(binaryTree.postorderTraversal(root));
    }
}
