package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 15:08
 * @description：LeetCode——83. 删除排序链表中的重复元素
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    //  duplicates:
    //  n.	完全一样的东西; 复制品; 副本;
    //  v.	复制; 复印; 复写; (尤指不必要时) 重复，再做一次;

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode curNext = head.next;
        while(curNext != null){
            if(cur.val == curNext.val){
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
     * 超长链表情况下，官方题解会产生大量野指针，这里要清除置空一下
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                ListNode node = cur.next;
                cur.next = node.next;
                node.next = null;//清除野指针
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
