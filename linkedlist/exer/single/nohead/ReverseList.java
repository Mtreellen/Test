package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 14:51
 * @description：LeetCode——206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {
    /**
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 链表为空
        if (head == null) {
            return null;
        }
        // 链表中只有一个节点
        if (head.next == null) {
            return head;
        }
        ListNode curPrev = null;
        ListNode cur = head;
        ListNode curNext = head.next;
        ListNode newHead = null;
        while(cur != null){
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
            if(curNext != null) {
                curNext = curNext.next;
            }
        }
        newHead = curPrev;
        return newHead;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}