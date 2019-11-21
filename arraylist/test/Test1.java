package arraylist.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ellen
 * @date 2019-11-15 13:00
 * @description
 */
public class Test1 {
    @Test
    public void test(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Person("Monica·Geller", "chef", 25, true));
        System.out.println(list.indexOf(
                new Person("Monica·Geller", "chef", 25, true)));
        list.add("hel");
        System.out.println(list.indexOf("hel"));
    }
}
