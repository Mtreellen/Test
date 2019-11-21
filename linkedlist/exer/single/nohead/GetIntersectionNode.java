package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-18 19:35
 * @description：LeetCode——160.相交链表
 *  找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    // 有问题的解法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){
            curA = curA.next;//
            curB = curB.next;//
            if(curA == null){
                curA = headB;
            }
            if(curB == null){
                curB = headA;
            }
        }
//        if(curA == null){
//            return null;
//        }else{
//            return curA;
//        }
        return curA;
    }
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){

            if(curA == null){
                curA = headB;
            }else{
                curA = curA.next;
            }
            if(curB == null){
                curB = headA;
            }else{
                curB = curB.next;
            }
        }
//        if(curA == null){
//            return null;
//        }else{
//            return curA;
//        }
        return curA;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
////        ListNode node1 = new ListNode(2);
////        ListNode node2 = new ListNode(3);
////        ListNode node3 = new ListNode(4);
////        ListNode node4 = new ListNode(5);
////        ListNode node5 = new ListNode(6);
////        ListNode node6 = new ListNode(7);
////        node.next = node1;
////        node1.next = node2;
////        node2.next = node3;
////        node4.next = node5;
////        node5.next = node6;
////        node6.next = node2;
////        System.out.println(getIntersectionNode(node, node4).val);
        ListNode node = new ListNode(1);
        System.out.println(getIntersectionNode(node, node).val);
    }
}
