package synch;

/**
 * @author ellen
 * @date 2019-11-26 14:46
 * @description：synchronized对象锁
 */
public class MyThread1 implements Runnable {
    public MyThread1() {}
    @Override
    public void run() {
        /*
        锁不住：
        synchronized 锁的是当前对象，但是这里每次进来的线程都有各自的sync
        sync1：线程A
        sync2：线程B
        sync3：线程C
        */
//        test1();

        // 可以锁住
        test2();
    }
    private void test1(){
        Sync1 sync = new Sync1();
        sync.testA();
    }
    private void test2(){
        // 使用静态方法
        Sync1.testB();
    }
}
class Sync1{
    public synchronized void testA(){
        System.out.println("方法开始。。。");
        System.out.println(Thread.currentThread().getName() + " start....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end....");
        System.out.println("方法结束。。。");
    }

    /**
     * 全局锁——锁的依旧是对象
     */
    public static synchronized void testB(){
        System.out.println("方法开始。。");
        System.out.println(Thread.currentThread().getName() + " start....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end....");
        System.out.println("方法结束。。");
    }
}

class Test{
    public static void main(String[] args) {
        test1();
    }
    private static void test1(){
        MyThread1 myThread1 = new MyThread1();
        Thread threadA = new Thread(myThread1, "线程A ");
        Thread threadB = new Thread(myThread1, "线程B ");
        Thread threadC = new Thread(myThread1, "线程C ");
        threadA.start();
        threadB.start();
        threadC.start();
    }

}