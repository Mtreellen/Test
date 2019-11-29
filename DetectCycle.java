package linkedlist.exer.single;

/**
 * @author ellen
 * @date 2019-11-23 10:19
 * @description：LeetCode——环形链表Ⅱ
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class DetectCycle {
    /*
    TODO：链表环入口的推导问题
     */
    public ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower){
                faster = head;// faster从头开始到入口节点，相遇的节点到入口节点，两个“距离”相等
                break;
            }
        }
        if(!(faster == null || faster.next == null)) {
            while (faster != slower) {
                faster = faster.next;
                slower = slower.next;
            }
            return faster;// 此时的faster和slower都是环入口节点
        }else{
            return null;
        }
    }
}
