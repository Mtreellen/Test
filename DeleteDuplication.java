package linkedlist.exer.single;

/**
 * @author ellen
 * @date 2019-11-23 11:27
 * @description：牛客——删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中所有重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    // TODO:
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead==null || pHead.next==null){return pHead;}
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode curPrev = null;
        ListNode cur = pHead;
        ListNode curNext = pHead.next;
        while(cur != null){
            if(curNext != null && cur.val == curNext.val){
                while(cur.val == curNext.val) {
                    curNext = curNext.next;
                }
                cur = curNext;
                curPrev.next = curNext;
                curNext = curNext.next;
            }else{
                curPrev = cur;
                curNext = curNext.next;
            }
        }
        return pHead;
    }
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }
}
