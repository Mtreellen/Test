package collection.collectionmethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历，使用迭代器Iterator接口
 * @author mtreellen
 * @create 2019-10-10-13:49
 */
public class IteratorTest {
    public static void test() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Iterator iterator = coll.iterator();
        /*方式一：不推荐
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
//        System.out.println(iterator.next());// java.util.NoSuchElementException
        */

        /*方式二：不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        */

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //错误写法一：跳着输出，并出现 NoSuchElementException 异常
        while((iterator.next()) != null){
            System.out.println(iterator.next());
        }
        //错误写法二：死循环一直顺出第一个元素
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }
    public static void test1() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
//            iterator.remove();//java.lang.IllegalStateException
            Object obj = iterator.next();
            if("hello".equals(obj)){
                iterator.remove();
//                iterator.remove();//java.lang.IllegalStateException
            }
        }
        //上一个迭代器iterator已经指向集合末尾了，需要重新生成
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());//"hello"被删除
        }
    }
    //foreach
    public static void test2() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(new String("world"));
        coll.add(12);//自动装箱
        coll.add(false);
        coll.add(new Person("Tom", 23));

        for(Object obj : coll){
            System.out.println(obj);
        }
    }
        public static void main(String[] args) {
//        test();
//        test1();
            test2();
    }
}
