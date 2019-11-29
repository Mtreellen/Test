package doublelikedlist;

/**
 * @author ellen
 * @date 2019-11-24 14:01
 * @description：无头双向链表的实现
 */
public class MyDoubleLinkedList extends DoubleLikedList{
    private Node head = null;
    private Node last = null;
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
//            node = this.head;
            // head 始终指向第一个节点
            this.head = node;
            //第一次插入时，last指向第一次插入的节点，之后就不再动它，达到，last指向最后节点的目的
            this.last = node;
        }else{
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;//注意这一步不可少！!
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
//            node = this.head;
            // head 始终指向第一个节点，之后就不再动它
            this.head = node;
            //last指向第一次插入的节点（最后一个节点）
            this.last = node;
        }else{
            this.last.setNext(node);
            node.setPrev(this.last);
            // 保证 last 始终指向最后一个节点
            this.last = node;//注意这一步不可少！!
        }
    }

    /**
     * TODO:再看看
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean addIndex(int index, int data) {
        if(index < 0 || index > size()){
            throw new RuntimeException("参数不合法");
        }
        Node node = new Node(data);
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index == size()){
            addLast(data);
            return true;
        }
        Node cur = this.head;
        while (index < 1) {//index <= size()
            cur = cur.getNext();
            index--;
        }
        // cur指向的节点的后面插入node
        node.setNext(cur.getNext());
        cur.getNext().setPrev(node);
        cur.setNext(node);
        node.setPrev(cur);
        return true;
    }
    public boolean addBySorted(int data){
        return false;
    }

    @Override
    public boolean contains(int key) {
        if(this.head == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    @Override
    public Node remove(int key) {
        if(this.head == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                if(cur.getPrev() == null){//if(cur == this.head){
                    this.head = cur.getNext();
                    this.head.setPrev(null);
                }else {
                    cur.getPrev().setNext(cur.getNext());
                    if (cur.getNext() != null) {
                        cur.getNext().setPrev(cur.getPrev());
                    }else{
                        this.last = cur.getPrev();
                    }
                }
//                return cur;
                break;
            }else {
                cur = cur.getNext();
            }
        }
//        return null;
        return cur;
    }
    public void remove(Node key){
        if(this.head == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.getVal() == key.getVal()){
                if(cur == this.head){
                    this.head = cur.getNext();
                    this.head.setPrev(null);
                }else{
                    cur.getPrev().setNext(cur.getNext());
                    if(cur.getNext() != null){
                        cur.getNext().setPrev(cur.getPrev());
                    }else{
                        this.last = cur.getPrev();
                        this.last.setNext(null);
                    }
                }
            }
            cur = cur.getNext();
        }
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                if(cur == this.head) {
                    this.head = cur.getNext();
                    if(this.head != null) {
                        this.head.setPrev(null);
                    }
                }else{
                    cur.getPrev().setNext(cur.getNext());
                    if(cur.getNext() != null){
                        cur.getNext().setPrev(cur.getPrev());
                    }else{
                        this.last = cur.getPrev();
                        this.last.setNext(null);
                    }
                }
            }
            cur = cur.getNext();
        }
    }

    @Override
    public int size() {
        if(this.head == null){
            throw new RuntimeException("链表为空");
        }
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    @Override
    public void display() {
        if(this.head == null){
            System.out.println("链表为空");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.println(cur);
            cur = cur.getNext();
        }
    }

    /**
     * 防止内存泄露
     */
    @Override
    public void clear() {
        Node cur = this.head;
        Node curNext = cur.getNext();
        while(cur != null){
            cur.setPrev(null);
            cur.setNext(null);
            cur = curNext;
            curNext = curNext.getNext();
        }
        this.head = null;
        this.last = null;
    }
}
