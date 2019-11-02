package collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mtreellen
 * @create 2019-10-11-11:10
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //自然
        test();
        System.out.println("********************************8");
        //定制
        test1();
    }
    public static void test2(){
        Comparator com = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };
        Set set = new TreeSet(com);

        set.add(new User("Tom",23));
        set.add(new User("Ellen", 22));
        set.add(new User("Anna",13));
        set.add(new User("Jary",43));
        set.add(new User("Jary",2));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void test1(){
        Set set = new TreeSet();

        set.add(new User("Tom",23));
        set.add(new User("Ellen", 22));
        set.add(new User("Anna",13));
        set.add(new User("Jary",43));
        set.add(new User("Jary",2));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void test(){
        Set set = new TreeSet();
        set.add(new User("Tom",23));
        set.add(new User("Ellen", 22));
        set.add(new User("Anna",13));
        set.add(new User("Jary",43));
        set.add(new User("Jary",2));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
