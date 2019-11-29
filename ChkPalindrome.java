package linkedlist.exer.single;

/**
 * @author ellen
 * @date 2019-11-23 9:54
 * @description：牛客——链表的回文结构
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 */
public class ChkPalindrome {
    public boolean chkPalindrome(ListNode A) {
        if(A == null){
            return false;
        }
        if(A.next == null){
            return true;
        }
        ListNode slower = A;
        ListNode faster = A;
        // 快慢指针走到链表的中间节点
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        ListNode cur = slower.next;
        ListNode curPrev = slower;
        ListNode curNext = cur.next;
        // 反转中间节点之后的节点
        while(cur != null){
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
            if(cur != null) {
                curNext = curNext.next;
            }
        }
        while(curPrev != A){
            if(curPrev.val != A.val){
                return false;
            }
            // 节点个数为偶数时
            if(A.next == curPrev){
                return true;
            }
            curPrev = curPrev.next;
            A = A.next;
        }
        return true;
    }
}
