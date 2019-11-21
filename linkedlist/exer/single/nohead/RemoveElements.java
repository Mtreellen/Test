package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 14:49
 * @description：LeetCode
 *      删除不带头链表中等于给定值 val 的所有节点
 */
public class RemoveElements {
    /**
     * 删除不带头链表中等于给定值 val 的所有节点。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;

        while(head != null && cur.next != null){
            ListNode curNext = cur.next;
            if(cur.next.val == val){
                cur.next = curNext.next;
                curNext = curNext.next;
            }else{
                cur = curNext;
                curNext = curNext.next;
            }
        }
        return head;
    }

    /**
     * 删除不带头链表中等于给定值 val 的所有节点，效率更高的方式：
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur.next != null){
            ListNode curNext = cur.next;
            if(cur.next.val == val){
                cur.next = curNext.next;
                curNext = curNext.next;
            }else{
                cur = curNext;
                curNext = curNext.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
}
