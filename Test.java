package doublelikedlist;

/**
 * @author ellen
 * @date 2019-11-24 14:01
 * @description
 */
public class Test {
    public static void main(String[] args) {
//       buildTest();
//       sizeTest();
//        containsTest();
//        removeTest();
//        removeTest1();
//        removeAllKeyTest();
        addIndexTest();
    }

    private static void removeAllKeyTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
        System.out.println("========doubleLinkedList.removeAllKey(2)========");
        doubleLinkedList.removeAllKey(2);
        doubleLinkedList.display();
//        doubleLinkedList.clear();
    }

    private static void removeTest1() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
        System.out.println("========doubleLinkedList.remove(1)========");
        System.out.println(doubleLinkedList.remove(1));
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
//        doubleLinkedList.clear();
    }

    private static void removeTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
        System.out.println("========doubleLinkedList.remove(2)========");
        System.out.println(doubleLinkedList.remove(2));
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
        doubleLinkedList.clear();
    }

    private static void containsTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        System.out.println("========doubleLinkedList.display()========");
        doubleLinkedList.display();
        System.out.println("========doubleLinkedList.contains(3)========");
        System.out.println(doubleLinkedList.contains(3));
        System.out.println("========doubleLinkedList.contains(343)========");
        System.out.println(doubleLinkedList.contains(343));
        doubleLinkedList.clear();
    }

    private static void sizeTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        System.out.println(doubleLinkedList.size());
//        doubleLinkedList.clear();
    }

    public static void buildTest(){
        System.out.println("=============addFirst()=============");
        addFirstTest();
        System.out.println("=============addLast()=============");
        addLastTest();
        System.out.println("=============addIndex()=============");
        addIndexTest();
    }

    private static void addIndexTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addIndex(1,4);//1->4->2->3
        doubleLinkedList.addIndex(2, 5);//1->
        doubleLinkedList.addIndex(3, 6);
        doubleLinkedList.addIndex(0, 7);

        doubleLinkedList.display();
        doubleLinkedList.clear();
    }

    private static void addLastTest() {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.display();
        doubleLinkedList.clear();
    }

    public static void addFirstTest(){
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.display();
        doubleLinkedList.clear();
    }
}
