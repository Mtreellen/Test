package collection.collectionmethod;

import java.util.*;

/**
 * Collection定义的常用方法
 * @author mtreellen
 * @create 2019-10-10-12:10
 */
public class CollectionMethodTest {
    //add(Object o)  size()  addAll(Collection coll)   isEmpty()    clear()
    public static void test(){
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(" world");
        coll.add(12);//自动装箱
        coll.add(new Date());
        System.out.println(coll.size());//4

        Collection coll1 = new ArrayList();
        coll1.add("Ab");
        coll1.add(12.3);

        coll.addAll(coll1);
        System.out.println(coll.size());//6
        //调用了toString()
        System.out.println(coll);//[hello,  world, 12, Thu Oct 10 12:20:32 CST 2019, Ab, 12.3]

        System.out.println(coll.isEmpty());//false
        coll.clear();
        System.out.println(coll.isEmpty());//true

        Collection coll2 = new ArrayList();
        System.out.println(coll2.isEmpty());//true

        coll2.clear();
        System.out.println(coll2.isEmpty());//true
    }
    //contains()
    public static void test1(){
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom",23));

        System.out.println(coll.contains("hello"));//true
        System.out.println(coll.contains(new String("world")));//true  --->  比较的是内容而非地址  -->  String类重写了equals()

        Person p = new Person("Tom",23);
        System.out.println(coll.contains(p));//false

        coll.add(p);
        System.out.println(coll.contains(p));//true

        coll.add(new Person("Helen", 10));
        System.out.println(coll.contains(new Person("Helen", 10)));//false  -->  此时没有重写equals()方法，调用的是Object的，所以比较的是地址值


    }
    //contains()
    public static void test2(){
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom",23));

        coll.add(new Person("Helen", 10));

        //Person类重写equals()后
        System.out.println(coll.contains(new Person("Helen", 10)));//true
        /*运行结果
        Person's equals()
        Person's equals()
        Person's equals()
        Person's equals()
        Person's equals()
        Person's equals()
        true
         */
    }
    //containsAll(Collection coll)
    public static void test3(){
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom",23));

        Collection coll1 = Arrays.asList("hello", new String("world"),
                12, new Person("Tom",23));
        System.out.println(coll.containsAll(coll1));//true

        Collection coll2 = Arrays.asList("hello", 12, "hehe");
        System.out.println(coll.containsAll(coll2));//false

        Collection coll3 = Arrays.asList(12, false, "hello");
        System.out.println(coll.containsAll(coll3));//true  -->  不讲究顺序
    }
    //remove()
    public static void test4() {
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        coll.remove("hello");
        System.out.println(coll);//[world, 12, false, Person{name='Tom', age=23}]

        coll.remove(123);
        System.out.println(coll);//[world, 12, false, Person{name='Tom', age=23}]

        coll.remove(new Person("Tom",23));
        System.out.println(coll);

        System.out.println(coll.remove(false));//true
    }
    //removeAll(Collection coll)
    public static void test5() {
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Collection coll1 = Arrays.asList("hello", new String("world"),
                true, new Person("Tom",123));

        System.out.println(coll);//[hello, world, 12, false, Person{name='Tom', age=23}]
        System.out.println(coll1);//[hello, world, true, Person{name='Tom', age=123}]
        System.out.println(coll.removeAll(coll1));//true
        System.out.println(coll);//[12, false, Person{name='Tom', age=23}]
        System.out.println(coll1);//[hello, world, true, Person{name='Tom', age=123}]
    }
    //retainAll(Collection coll)
    public static void test6() {
        Collection coll = new ArrayList();

        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Collection coll1 = Arrays.asList(
                "hello",
                new String("world"),
                true,
                new Person("Tom",123),
                12
        );
        System.out.println(coll.retainAll(coll1));//true
        System.out.println(coll);//[hello, world, 12]
        System.out.println(coll1);//[hello, world, true, Person{name='Tom', age=123}, 12]
    }
    //equals()
    public static void test7() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Collection coll1 = new ArrayList();
        coll1.add("hello");
        coll1.add(new String("world"));
        coll1.add(12);//自动装箱
        coll1.add(false);
        coll1.add(new Person("Tom", 23));

        System.out.println(coll.equals(coll1));//true
        System.out.println(coll.equals("hello"));//false
    }
    //hashCode()
    public static void test8() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        System.out.println(coll.hashCode());//
    }
    //toArray()  ----   集合 -》  数组
    public static void test9() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Object[] obj = new Object[coll.size()];
        obj = coll.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }

        //数组 -》 集合
        List<String> list = Arrays.asList(new String[]{"AA", "Ac", "BB"});
        System.out.println(list);//[AA, Ac, BB]

        //注意
        List<int[]> list1 = Arrays.asList(new int[]{12, 32, 21});
        System.out.println(list1);//[[I@1b6d3586]

        List<char[]> list2 = Arrays.asList(new char[]{'a', 'c', 'q'});
        System.out.println(list2);//[[C@4554617c]

        List<Integer> list3 = Arrays.asList(12, 32, 21);
        List<Character> list4 = Arrays.asList('a', 'c', '1');
        System.out.println(list3);//[12, 32, 21]
        System.out.println(list4);//[a, c, 1]

        List<Integer> list5 = Arrays.asList(new Integer[]{21, 32, 21});
        List<Character> list6 = Arrays.asList(new Character[]{'a', 'c', 'q'});
        System.out.println(list5);//[21, 32, 21]
        System.out.println(list6);//[a, c, q]
    }

    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
//        test9();LinkedList
    }
}
