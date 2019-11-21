package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 17:04
 * @description：牛客——输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
    /**
     * 有错误，如果超出链表结点个数的范围，就会出现空指针异常
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0){
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;
        while(k > 1){
            faster = faster.next;
            k--;
        }
        while(faster.next != null){
            faster = faster.next;
            slower = slower.next;
        }
        return slower;
    }
    public ListNode FindKthToTail1(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k - 1 > 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
