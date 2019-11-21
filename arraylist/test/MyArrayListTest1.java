package arraylist.test;

import java.util.Scanner;

/**
 * @author ellen
 * @date 2019-11-15 16:17
 * @description
 */
public class MyArrayListTest1 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        MyArrayList myArrayList = new MyArrayList(10);
        Scanner scanner = new Scanner(System.in);
        boolean key = true;
        while(key){
            meau();
            System.out.print("请选择您的操作> ");
            int input = scanner.nextInt();
            switch (input){
                case 1:
//                    int i = 0;
                    //TODO:有问题
                    System.out.print("输入您要插入的元素下标> ");
                    int index = scanner.nextInt();
                    System.out.print("输入您要插入的元素内容> ");
                    int value = scanner.nextInt();
                    myArrayList.add(index, value);
                    break;
                case 2:
                    System.out.print("输入您要删除的下标> ");
                    myArrayList.delete(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("输入您要删除的元素> ");
                    myArrayList.removeValue(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("输入您要查看的下标> ");
                    System.out.println("此下标对应元素为：" + myArrayList.getPos(scanner.nextInt()));
                    break;
                case 5:
                    myArrayList.display();
                    break;
                case 6:
                    System.out.println("当前顺序表的长度为：" + myArrayList.getUsedSize());
                    break;
                case 7:
                    System.out.print("输入您要查找的元素> ");
                    System.out.println("此元素是否存在：" + myArrayList.contains(scanner.nextInt()));
                    break;
                case 8:
                    myArrayList.clear();
                    System.out.println("链表成功清空");
                    break;
                case 9:
                    key = false;
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }
    public static void meau(){
        System.out.println("|********************************************\t|");
        System.out.println("|*************1.添加元素\t\t\t\t\t\t|");
        System.out.println("|*************2.删除指定下标元素\t\t\t\t|");
        System.out.println("|*************3.删除指定内容元素\t\t\t\t|");
        System.out.println("|*************4.查看指定下标元素内容\t\t\t|");
        System.out.println("|*************5.打印顺序表\t\t\t\t\t\t|");
        System.out.println("|*************6.打印顺序表长度\t\t\t\t\t|");
        System.out.println("|*************7.查看指定元素是否存在\t\t\t|");
        System.out.println("|*************8.清空顺序表\t\t\t\t\t\t|");
        System.out.println("|*************9.退出程序\t\t\t\t\t\t|");
        System.out.println("|********************************************\t|");
    }
}
// 测试类
class MyArrayListTest{
    public static void main(String[] args) {
//        testAdd();
//        testCapacity();
//        testSearch();
//        testDelete();
//        testContains();
//        testInsert();
//        testSet();
        testRemoveValue();
    }

    private static void testRemoveValue() {
        MyArrayList myArrayList = build();// MAX_CAPACITY 10    usedSize 6
        Person chef = new Person("Monica·Geller", "chef", 25, true);
        myArrayList.add(chef);
        myArrayList.display();

        System.out.println(myArrayList.removeValue(chef));
        System.out.println("----------------------------------------");
        myArrayList.display();
    }

    private static void testSet() {
        MyArrayList myArrayList = build();// MAX_CAPACITY 10    usedSize 6
        myArrayList.display();
        myArrayList.set(5, new Person("Hero·Ma", "Police", 28, true));
        System.out.println("----------------------------------------");
        myArrayList.display();
    }

    private static void testInsert() {
        MyArrayList myArrayList = build();// MAX_CAPACITY 10    usedSize 6
        myArrayList.display();
        myArrayList.insert(0,
                new Person("Ellen", "Tester", 22, true));
        myArrayList.insert(1,
                new Person("Apple", "pilot", 22, true));// 飞行员
        myArrayList.insert(9, "Hello");
        myArrayList.insert(10, "Data");
        myArrayList.insert(10, 123);// 扩容
        System.out.println("----------------------------------------");
        myArrayList.display();

    }

    private static void testContains() {
        MyArrayList myArrayList = new MyArrayList(3);
        Person person = new Person("Ellen", "Tester", 22, true);
        myArrayList.add(1);
        myArrayList.add(false);
        myArrayList.add("Hello");
        myArrayList.add(person);
        myArrayList.display();
        System.out.println("contains():");
        System.out.println(myArrayList.contains(person));
        System.out.println(myArrayList.contains(1));
        System.out.println(myArrayList.contains(false));
        System.out.println(myArrayList.contains(true));
        System.out.println(myArrayList.contains("Hello"));
    }

    private static void testDelete() {
        /*
        System.out.println("==========+ delete()前 +==========");
        build().display();
        System.out.println("是否删除成功：" + build().delete(0));
        System.out.println("==========+ delete()后 +==========");
        build().display();// 这里的build()返回的是一个新的MyArrayList对象
        */

        System.out.println("==========+ delete()前 +==========");
        MyArrayList myArrayList = build();
        myArrayList.display();
//        System.out.println("是否删除成功：" + myArrayList.delete(0));
        System.out.println("==========+ delete()后 +==========");
//        myArrayList.display();

        int i = 0;
        while(!myArrayList.isEmpty()){
            myArrayList.delete(i);
        }
        myArrayList.display();
    }

    /**
     * 测试查找
     */
    private static void testSearch() {
        MyArrayList myArrayList = new MyArrayList(3);
        Person person = new Person("Ellen", "Tester", 22, true);

        myArrayList.add(1);
        myArrayList.add(false);
        myArrayList.add("Hello");
        myArrayList.add(person);

        myArrayList.display();

        System.out.println("search():");
        System.out.println(myArrayList.search(person));// 3
        System.out.println(myArrayList.search(1));// 0
        System.out.println(myArrayList.search(false));// 1
        System.out.println(myArrayList.search(true));// -1
        System.out.println(myArrayList.search("Hello"));// 2
        System.out.println(myArrayList.search("再见"));// -1
        System.out.println(myArrayList.search(
                new Person("Monica", "chef", 25, true)));// -1
        System.out.println(myArrayList.search(
                new Person("Ellen", "Tester", 22, true)));// -1

    }

    /**
     * 测试扩容
     */
    public static void testCapacity(){
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
//        System.out.println(myArrayList.isFull());// true：满了
        // 再添加之前需要 扩容
        myArrayList.add(4);

        myArrayList.display();
    }
    /**
     * 测试添加数据
     */
    public static void testAdd(){
        System.out.println("链表为空吗：" + build().isEmpty());
        System.out.println("链表满了吗：" + build().isFull());
        build().display();
    }
    /**
     * 创建一个顺序表
     * @return：新建的顺序表
     */
    public static MyArrayList build() {
        MyArrayList myArrayList = new MyArrayList();// 默认长度 10
        myArrayList.add(new Person("Monica·Geller", "chef", 25, true));
        myArrayList.add(new Person("Rose·Geller", "professor", 28, true));//university professor
        myArrayList.add(new Person("Rachel·Greene", "manager", 24, false));// purchasing manager
        myArrayList.add(new Person("Joey·Tribbiani", "actor", 28, false));
        myArrayList.add(new Person("Chandler·Bing", "SADR", 26, true));//数据重构和统计保理 statistical analysis and data reconfiguration
        myArrayList.add(new Person("Phoebe·Buffay", "masseur", 27, false));
        return myArrayList;
    }
}
