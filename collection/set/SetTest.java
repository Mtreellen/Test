package collection.set;

import collection.collectionmethod.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *Set 的无序和不可重复的理解
 * @author mtreellen
 * @create 2019-10-10-18:49
 */
public class SetTest {
    public static void main(String[] args) {
        test();
        test1();
        test2();
        test3();
    }
    public static void test3() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(12);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//重写equals和hashCode
        }
    }
    public static void test2() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new Person("Tom", 21));
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(12);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//没有重写equals和hashCode
        }
    }
    public static void test1(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new Person("Tom", 21));

        set.add(12);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//
        }

        //1. 无序性

        //2. 不可重复性
    }
    public static void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new Person("Tom", 21));
        set.add(12);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//
        }

        //1. 无序性

        //2. 不可重复性
    }
}
