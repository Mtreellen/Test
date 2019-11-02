package collection.list;

import collection.collectionmethod.Person;

import java.util.ArrayList;

/**
 * @author mtreellen
 * @create 2019-10-10-15:44
 */
public class ArrayListTest {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        ArrayList list = new ArrayList();
        list.add("hehe");
        list.add(12);
        list.add(new Person("ellen", 21));
        System.out.println(list);
        System.out.println(list.contains("haha"));
        System.out.println(list.isEmpty());
    }
}
