package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mtreellen
 * @date 2019-10-31-16:36
 */
public class Exer {
    public static void main(String[] args) {
//        test1();
//        test2();
       /* System.out.println("main start..");
        test3();
        System.out.println("main end..");*/
//       test4();
//        test5();
//        test6();
//        test7();
        test8();
    }
    public static void test1(){
        Thread1 mt = new Thread1();
        Thread thread1 = new Thread(mt, "A");
        Thread thread2 = new Thread(mt, "B");
        Thread thread3 = new Thread(mt, "C");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void test2(){
        Thread2 mt = new Thread2();
        Thread thread1 = new Thread(mt, "A");
        Thread thread2 = new Thread(mt, "B");
        Thread thread3 = new Thread(mt, "C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void printTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);
        System.out.println(str);
    }
    public static void test3(){
        Thread3 thread = new Thread3();
        Thread thread1 = new Thread(thread, "子线程");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void test4(){
        Thread4 thread = new Thread4();
        Thread thread1 = new Thread(thread, "子线程");
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setFlag(false);
    }
    public static void test5(){
        Thread4 thread = new Thread4();
        Thread thread1 = new Thread(thread, "子线程");
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.stop();
    }

    public static void test6(){
        Thread4 thread = new Thread4();
        Thread thread1 = new Thread(thread, "子线程");
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();//只是将状态置为true
    }
    public static void test7(){
        System.out.println(Thread.currentThread().getPriority());
    }
    public static void test8(){
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
        Thread thread = new Thread(new Thread7(), "子线程");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
            Thread.yield();
        }
    }
}
class Thread3 implements Runnable{
    @Override
    public void run() {
        System.out.println("主线程休眠开始....");
        Exer.printTime();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程休眠结束....");
        Exer.printTime();
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Thread.currentThread().getName() + "、" + i);
//        }
    }
}
class Thread4 implements Runnable{
    private Boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while(flag){
            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
    public void setFlag(Boolean flag){
        this.flag = flag;
    }
}

class Thread5 implements Runnable{
    private Boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while(true){
            Boolean bool = Thread.currentThread().isInterrupted();
            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行");
            System.out.println(bool);
            if(bool){
                System.out.println("线程退出");
                break;
            }
            i++;
        }
    }
    public void setFlag(Boolean flag){
        this.flag = flag;
    }
}
class Thread6 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " : " + Thread.currentThread().getPriority());
    }
}

class Thread7 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " "
        + Thread.currentThread().getPriority());
        new Thread(new Thread6(), "孙子线程").start();
    }
}