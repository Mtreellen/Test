package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 一道关于List的面试题
 * @author mtreellen
 * @create 2019-10-10-18:39
 */
public class ListExer1 {
    public static void main(String[] args) {
        ListExer1 listExer1 = new ListExer1();
        listExer1.testListRemove();
    }
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);

    }
    public static void updateList(List list){
        list.remove(2);
    }
}
