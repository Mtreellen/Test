package exer;

import create.MyThread4;

/**
 * @author ellen
 * @date 2019-11-26 15:21
 * @description
 */
public class Exer1 {
    public static void main(String[] args) {
        Sync1 sync = new Sync1();
        MyThread1 myThread1 = new MyThread1(sync);
        Thread threadA = new Thread(myThread1, "线程A");
        Thread threadB = new Thread(myThread1, "线程A");
        threadA.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
class Sync1{
    // 线程A 进入test1()
//    public synchronized void test1(){
    public void test1(){
//        while(true){}
        if(Thread.currentThread().getName().equals("线程A")){
            while (true){

            }
        }
    }
    // 线程A 仍在执行，线程B 能否进入 test2()
    // 不能
    public synchronized void test2(){
        if(Thread.currentThread().getName().equals("线程B")){
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName());
    }
}
class MyThread1 implements Runnable{
    private Sync1 sync;
    public MyThread1(Sync1 sync) {
        this.sync = sync;
    }
    @Override
    public void run() {
        this.sync.test1();
        this.sync.test2();
    }
}