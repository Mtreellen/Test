package linkedlist.exer.single;

/**
 * @author ellen
 * @date 2019-11-23 11:24
 * @description：LeetCode——21.合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    /*
    借助虚拟节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
//        if(l1 == null && l2 != null){
//            return l2;
//        }
//        if(l2 == null && l1 != null){
//            return l1;
//        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if(l1 == null){
            tmp.next = l2;
        }
        if(l2 == null){
            tmp.next = l1;
        }
        return newHead.next;
    }
}
