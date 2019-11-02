package collection.list;

import java.util.*;

/**
 * @author mtreellen
 * @create 2019-10-10-18:25
 */
public class ListTest1 {
    public static void main(String[] args) {
//        test();
        test1();
    }
    /**
     * List遍历的三种方式
     */
    public static void test1(){
        List list = new ArrayList();
        list = Arrays.asList("haha", 12, new StringBuffer("haha"), false, 3.14, "姐姐");

        //Iterator迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*
        //错误写法一：跳着输出，并出现 NoSuchElementException 异常
        while((iterator.next()) != null){
            System.out.println(iterator.next());
        }
        //错误写法二：死循环一直顺出第一个元素
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
         */

        //foreach
        for(Object obj : list){
            System.out.println(obj);
        }
        
        //普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void test(){
        Collection coll = Arrays.asList("haha", 12, new StringBuffer("haha"), false, 3.14, "姐姐");
        //Iterator迭代器
        Iterator iterator = coll.iterator();

        /*
        //错误，死循环
        while(iterator.hasNext()){
            System.out.println(coll);
        }
        */
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //foreach
        for(Object obj : coll){
            System.out.println(obj);
        }

        /*
        //普通for
        for (int i = 0; i < coll.size(); i++) {
            //System.out.println(((List) coll).get(i));
            //????
            //TODO：普通for循环遍历Collection
        }
        */
    }


}
