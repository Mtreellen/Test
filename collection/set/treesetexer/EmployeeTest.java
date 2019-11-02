package collection.set.treesetexer;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author mtreellen
 * @create 2019-10-11-14:16
 */
public class EmployeeTest {
    public static void main(String[] args) {
//        test();
        test1();
    }

    /**
     * TODO:自己再写一遍
     * 定制排序：birthday
     */
    public static void test1(){

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    int minusYear = b1.getYear() - b2.getYear();
                    if(minusYear != 0){
                        return minusYear;
                    }
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }
                    return b1.getDay() - b2.getDay();

                }else{
                    throw new RuntimeException("传入数据类型不一致");
                }
            }
        });

        Employee em = new Employee("斯嘉丽·约翰逊", 35, new MyDate(1984, 11, 22));
        Employee em1 = new Employee("凯特·布兰切特", 45,new MyDate(1969, 5, 14));
        Employee em2 = new Employee("刘嘉玲", 54,new MyDate(1965, 12, 8));
        Employee em3 = new Employee("艾伦·德詹尼斯", 61,new MyDate(1958, 1, 26));
        Employee em4 = new Employee("刘德华", 58, new MyDate(1961, 9, 27));

        set.add(em);
        set.add(em1);
        set.add(em2);
        set.add(em3);
        set.add(em4);

        for(Object e : set){
            System.out.println(e);
        }

        System.out.println(set);
    }
    /**
     * 使用自然排序：name
     */
    public static void test(){
        TreeSet set = new TreeSet();

        Employee em = new Employee("斯嘉丽·约翰逊", 35, new MyDate(1984, 11, 22));
        Employee em1 = new Employee("凯特·布兰切特", 45,new MyDate(1969, 5, 14));
        Employee em2 = new Employee("刘嘉玲", 54,new MyDate(1965, 12, 8));
        Employee em3 = new Employee("艾伦·德詹尼斯", 61,new MyDate(1958, 1, 26));
        Employee em4 = new Employee("刘德华", 58, new MyDate(1961, 9, 27));

        set.add(em);
        set.add(em1);
        set.add(em2);
        set.add(em3);
        set.add(em4);

        for(Object e : set){
            System.out.println(e);
        }
    }
}
