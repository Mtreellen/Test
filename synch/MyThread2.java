package synch;

/**
 * @author ellen
 * @date 2019-11-26 14:56
 * @description
 */
public class MyThread2 implements Runnable{
    private Sync2 sync;
    public MyThread2(Sync2 sync) {
        this.sync = sync;
    }
    @Override
    public void run() {
        // 可以锁住
        this.sync.testA();
    }
}
class Sync2{
    public synchronized void testA(){
        System.out.println("方法开始。。");
        System.out.println(Thread.currentThread().getName() + " start....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end....");
        System.out.println("方法结束。。。");
    }
}
class Test2{
    public static void main(String[] args) {
        test2();
    }
    private static void test2(){
        Sync2 sync = new Sync2();
        MyThread2 mt2 = new MyThread2(sync);
        Thread threadA = new Thread(mt2, "线程A ");
        Thread threadB = new Thread(mt2, "线程B ");
        Thread threadC = new Thread(mt2, "线程C ");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}