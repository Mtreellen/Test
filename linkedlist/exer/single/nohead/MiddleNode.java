package linkedlist.exer.single.nohead;

import org.junit.Test;

/**
 * @author ellen
 * @date 2019-11-16 15:50
 * @description：LeetCode——876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 *示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode faster = head;
        ListNode slower = head;
        while(faster.next != null && faster != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }
    public ListNode middleNode1(ListNode head) {
        int count = size(head) / 2;
        ListNode cur = head;
        // [0, size()/2)
        // (0, size()/2]
        while(count > 0 && cur.next != null){
            count--;
            cur = cur.next;
        }
        return cur;
    }

    public static int size(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    @Test
    public void test(){
        ListNode no = new ListNode(1);
        ListNode no1 = new ListNode(2);
        ListNode no2 = new ListNode(3);
        no.next = no1;
        no1.next = no2;

        System.out.println(middleNode1(no).val);
    }
}
