package collection.list;

import collection.collectionmethod.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mtreellen
 * @create 2019-10-10-16:37
 */
public class ListMethodTest {
    public static void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("hello");
        list.add(new Person("Tom", 12));
        list.add(123);

        System.out.println(list);//[123, hello, Person{name='Tom', age=12}, 123]
        //void add(int index, Object ele)：在index位置插入ele
        list.add(1, "jiejie");
        System.out.println(list);//[123, jiejie, hello, Person{name='Tom', age=12}, 123]

        //addAll(Collection coll)
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);//[123, jiejie, hello, Person{name='Tom', age=12}, 123, 1, 2, 3]
        System.out.println(list.size());//8

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        System.out.println(list.add(list2));//true
        System.out.println(list);//[123, jiejie, hello, Person{name='Tom', age=12}, 123, 1, 2, 3, [1, 2, 3]]
        System.out.println(list.size());//9
    }
    //get()  indexOf()   lastIndexOf()
    public static void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("hello");
        list.add(new Person("Tom", 12));
        list.add(123);

        System.out.println(list.get(2));//Person{name='Tom', age=12}

        System.out.println(list.indexOf("hello"));//1
        System.out.println(list.lastIndexOf(123));//3
    }
    public static void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("hello");
        list.add(new Person("Tom", 12));
        list.add(123);
        list.add(1);
        list.add(2);

        Object o = list.remove(1);
        System.out.println(list);//[123, Person{name='Tom', age=12}, 123, 1, 2]
        Object o1 = list.remove(1);//[123, 123, 1, 2]
        System.out.println(list);
        System.out.println(list.remove(2));//1
        System.out.println(list);//[123, 123, 2]

        Object o2 = list.set(1, "haha");
        System.out.println(o2);//123
        System.out.println(list);//[123, haha, 2]

        System.out.println(list);//[123, haha, 2]
        System.out.println(list.subList(1, 2));//[haha]  --- [   )
        System.out.println(list);//[123, haha, 2]
    }

    public static void main(String[] args) {
//        test();
//        test1();
        test2();
    }
}
