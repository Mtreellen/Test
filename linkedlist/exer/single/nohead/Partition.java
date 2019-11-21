package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 17:56
 * @description：牛客——链表分割（“四指针法”）
 *
 * 编写代码：
 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {
    // TODO:再看一看
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode cur = pHead;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = null;
            if(cur.val <= x){
                if(beforeEnd == null && beforeStart == null){
                    beforeStart = cur;
                    beforeEnd = cur;
                }else{
                    beforeEnd.next = cur;
                    beforeEnd = cur;
                }
            }else{
                if(afterStart == null && afterEnd == null){
                    afterStart = cur;
                    afterEnd = cur;
                }else{
                    afterEnd.next = cur;
                    afterStart = cur;
                }
            }
            cur = cur.next;
        }
        // 如果链表中都是比基准大的数字
        if(beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}