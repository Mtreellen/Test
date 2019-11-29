package sync;

/**
 * @author ellen
 * @date 2019-11-26 13:57
 * @description：synchronized实现同步处理（加锁操作）
 *  *      一般锁的对象为 this（当前对象）
 *  *      也可以是 Object 类的对象
 *  *      1、同步代码块
 *  *          表示同一时刻只有一个线程能够进入同步代码块，但是多个线程可以同时进入当前方法
 *  *      2、同步方法
 *  *          表示同一时刻只有一个线程能够进入同步方法
 *  *      3、反射机制
 */
public class SyncTest1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread threadA = new Thread(myThread1, "窗口A ");
        Thread threadB = new Thread(myThread1, "窗口B ");
        Thread threadC = new Thread(myThread1, "窗口C ");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
