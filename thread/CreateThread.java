package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author mtreellen
 * @date 2019-10-31-13:34
 */
public class CreateThread {
    public static void main(String[] args) {
        testRunnable();
//        testLambda();
//        testCallable();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        thread.run();
    }
    public static void testThread(){
        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
    public static void testRunnable(){
        MyThread1 myThread1 = new MyThread1("A");
        MyThread1 myThread2 = new MyThread1("B");
        MyThread1 myThread3 = new MyThread1("C");
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
    }
    public static void testRunnable1(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("呵呵");
            }
        };
        new Thread(runnable).start();
    }
    public static void testLambda(){
        Runnable runnable = () -> System.out.println("Hehe");
        new Thread(runnable).start();
    }
    public static void testCallable(){
        MyThread2 myThread = new MyThread2();
        FutureTask<String> futureTask = new FutureTask<>(myThread);
        Thread thread1 = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask);
        thread1.start();
        thread2.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
// Extends Thread class
class MyThread extends Thread{
    private String title;

    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "、" + i);
        }
    }
}
// Implements Runnable Interface
class MyThread1 implements Runnable{
    private String title;
    public MyThread1(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.title + "、" + i);
        }
    }
}
class MyThread2 implements Callable<String>{
    private Integer ticket = 100;
//    public MyThread2(){}//???
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
//            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName());
            System.out.println("还剩下" + this.ticket-- + "张票");
        }
        return "票卖完了";
    }
}