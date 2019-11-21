package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 16:23
 * @description：LeetCode——19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;
        // [1, n)
        while(n >= 1 && faster.next != null){
            n--;
            faster = faster.next;
        }
        while(faster.next != null){
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = faster;
        return head;
    }
}
