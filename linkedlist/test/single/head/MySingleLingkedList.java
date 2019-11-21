package linkedlist.test.single.head;

/**
 * @author ellen
 * @date 2019-11-15 16:35
 * @description：带头单向单链表
 */
public class MySingleLingkedList extends SingleLinkedList{
    private Node head = new Node();// 头结点

    /**
     * 头插法
     * @param data
     */
    @Override
    public void addFirst(String data) {
        Node node = new Node(data);
        if(this.head.getNext() == null){
            this.head.setNext(node);
        }else{
            node.setNext(this.head.getNext());
            this.head.setNext(node);
        }
    }

    /**
     * 尾插法
     * @param data
     */
    @Override
    public void addLast(String data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }

    /**
     * 找到第 index 个节点的前一个节点
     * @param index
     * @return
     *          返回第 index 个节点的前一个节点
     */
    public Node searchIndex(int index){
        int count = 0;
        Node cur = this.head;
        while(count < index - 1){
            cur = cur.getNext();
            count++;
        }
        return cur;
    }
    /**
     * 在指定的位置插入节点
     * @param index：要插入的位置
     * @param data：要插入的节点的数据
     * @return
     *          插入成功返回 true
     *          不成功返回 false
     */
    @Override
    public boolean addIndex(int index, String data) {
        if(index < 0 || index > size() + 1){
            throw new IndexOutOfBoundsException("下标不合法");
        }
        Node node = new Node(data);
        if(index == 0){
            addFirst(data);
            return true;
        }
        node.setNext(searchIndex(index).getNext());
        searchIndex(index).setNext(node);
        return true;
    }

    /**
     * 给有序的链表插入节点，插入后链表节点依然保持有序
     * @param node
     *          要插入的节点
     */
    public void addBySort(Node node){
        Node cur = this.head;
        boolean flag = false;
        while(true){
            // 这个判断必须在是上面，否则，head 的next为空时会有NullPointerException
            // 如果走到链表尾部都没有找到比node的no值大的或者等于的节点，那么就说明node的no值是最大的
            // 应该插入到最后
            if(cur.getNext() == null){
                break;
            }
            // 如果cur的next节点的no值大于或者等于当前新的节点的no值，那么就找到了插入的位置，结束循环
            if(cur.getNext().getNo() >= node.getNo()){
                flag = true;
                break;
            }
            cur = cur.getNext();
        }
        if(flag){
            // flag为true表明cur的next节点的no值大于或者等于当前新的节点的no值
            // 将 新的节点 node 插入到cur的后面
            node.setNext(cur.getNext());
            cur.setNext(node);
        }else{
            // node的no值最大，直接插入到链表尾部
            // 因为cur已经达到链表最后一个节点处，所以直接将cur的next设为node即可
            cur.setNext(node);
        }
    }

    @Override
    public boolean contains(Node key) {
        if(this.head.getNext() == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = head.getNext();
        while(cur != null){
            if(cur.getName().equals(key.getName())){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    public boolean contains(String key) {
        if(this.head.getNext() == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = head.getNext();
        while(cur != null){
            if(cur.getName().equals(key)){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * 删除节点（只删除一个）
     * @param key
     *          链表中第一次出现的name值与key值相同的节点被删除
     */
    @Override
    public void remove(String key) {
        if(this.head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            if(key.equals(cur.getNext().getName())){
                cur.setNext(cur.getNext().getNext());
                System.out.println(">> 删除成功");
                return;
            }
            cur = cur.getNext();
        }
        System.out.println(">>name 值为 " + key +" 的节点不存在于链表中");
    }

    @Override
    public void removeAllKey(String key) {
        if(this.head.getNext() == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = this.head;
        Node curNext = cur.getNext();
        while(curNext != null){
            if(cur.getNext().getName().equals(key)){
                cur.setNext(cur.getNext().getNext());
                System.out.println(">>节点 " + curNext +" 成功被删除");
                curNext = curNext.getNext();
            }else{
                cur = cur.getNext();
                curNext = curNext.getNext();
            }
        }
        if(curNext == null){
            System.out.println(">>name值等于 " + key +" 的节点不存在于链表中");
        }
    }


    @Override
    public int size() {
        int count = 0;
        Node cur = head.getNext();
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    @Override
    public void display() {
        if (this.head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = head.getNext();
        while(cur != null){
            System.out.println(cur);
            cur = cur.getNext();
        }
    }
    public Node search(String name){
        if(this.head.getNext() == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = head.getNext();
        while(cur != null){
            if(cur.getName().equals(name)){
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }
    @Override
    public void clear() {
        this.head = null;
    }
}
