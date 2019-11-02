package generic;

import org.junit.Test;

import java.util.*;

/**
 * @author mtreellen
 * @create 2019-10-18-10:05
 */
public class GenericTest {
    @Test
    public void test(){
        ArrayList list = new ArrayList();

        list.add(34);
        list.add(45);
        list.add(67);
        list.add(87);

//        list.add("哈哈");
        for(Object obj : list){
            int stuScore = (Integer)obj;
//            int stuScore = (int)obj;//ok
            System.out.println(stuScore);
        }
    }
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
//        ArrayList<int> list = new ArrayList<int>();//不可
        list.add(34);
        list.add(45);
        list.add(67);
        list.add(87);
        for(Object obj : list){
//            int stuScore = (Integer)obj;
//            int stuScore = (int)obj;//ok
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("小1", 23);
        map.put("小2", 54);
        map.put("小3", 71);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            Integer value = e.getValue();
            String key = e.getKey();
            System.out.println(key + "-" + value);
        }

    }
}
