package collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mtreellen
 * @create 2019-10-16-19:12
 */
public class TreeSeTest1 {
    public static void main(String[] args) {
        System.out.println("**************自然排序**********************");
        testNatureSort();
        System.out.println("**************定制排序——按年龄升序**********************");
        testDesignSort();
    }
    public static void testDesignSort(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(comparator);

        set.add(new User("Ben",23));
        set.add(new User("Ellen", 22));
        set.add(new User("Anna",13));
        set.add(new User("Jary",43));
        set.add(new User("Jary",2));
        set.add(new User("Chandler",28));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void testNatureSort(){
        Set set = new TreeSet();

        set.add(new User("Ben",23));
        set.add(new User("Ellen", 22));
        set.add(new User("Anna",13));
        set.add(new User("Jary",43));
        set.add(new User("Jary",2));
        set.add(new User("Chandler",28));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
