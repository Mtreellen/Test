package linkedlist.test.single.head;

/**
 * @author ellen
 * @date 2019-11-15 16:35
 * @description
 */
public class Node {
    private String name;
    private int no;
    private static int count;
    private Node next;

    public Node() {
        this.no = count;
    }
    public Node(int no, String name){
        this.no = no;
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
        count++;
        this.no = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                " no=" + no +
                "，name='" + name + '\'' +
                '}';
    }
}
