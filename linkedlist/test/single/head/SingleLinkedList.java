package linkedlist.test.single.head;

/**
 * @author ellen
 * @date 2019-11-15 16:35
 * @description
 */
public abstract class SingleLinkedList {
    //头插法
    public abstract void addFirst(String data);

    //尾插法
    public abstract void addLast(String data);

    //任意位置插入,第一个数据节点为0号下标
    public abstract boolean addIndex(int index,String data);

    //查找是否包含关键字key是否在单链表当中
    public abstract boolean contains(Node key);

    //删除第一次出现关键字为key的节点    
    public abstract void remove(String key);

    //删除所有值为key的节点
    public abstract void removeAllKey(String key);

    //得到单链表的长度
    public abstract int size();

    public abstract void display();
    public abstract void clear();
}
