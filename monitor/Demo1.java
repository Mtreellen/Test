package monitor;

import org.junit.Test;

/**
 * @author ellen
 * @date 2019-11-26 16:12
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
//        test1();
        test2();
        test3();
    }
    public static synchronized void test2(){
        System.out.println("Hello");
    }
    public static synchronized void test3(){
        System.out.println("Hello");
    }
    public static void test1(){
        Object obj = new Object();
        synchronized (obj){
            System.out.println("Hello");
        }
    }
}
