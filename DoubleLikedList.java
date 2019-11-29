package doublelikedlist;

/**
 * @author ellen
 * @date 2019-11-24 14:01
 * @description：双向链表
 */
public abstract class DoubleLikedList {
    //头插法
    public abstract void addFirst(int data);
    //尾插法
    public abstract void addLast(int data);
    //任意位置插入,第一个数据节点为0号下标
    public abstract boolean addIndex(int index,int data);
    //查找是否包含关键字key是否在单链表当中
    public abstract boolean contains(int key);
    //删除第一次出现关键字为key的节点
    public abstract Node remove(int key);
    //删除所有值为key的节点
    public abstract void removeAllKey(int key);
    //得到单链表的长度
    public abstract int size();
    // 打印链表信息
    public abstract void display();
    // 清空链表
    public abstract void clear();
}
