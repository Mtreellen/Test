package linkedlist.exer.single.nohead;

/**
 * @author ellen
 * @date 2019-11-16 18:27
 * @description：牛客——删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode curPrev = null;
        ListNode cur = pHead;
        ListNode curNext = pHead.next;
        while(curNext != null){
            if(cur.val == curNext.val){
                while(cur.val == curNext.val) {
                    curNext = curNext.next;
                }
                cur = curNext;
                curPrev.next = curNext;
                curNext = curNext.next;
            }else{
                curPrev = cur;
                cur = curNext;
                curNext = curNext.next;
            }
        }
        return pHead;
    }
}
