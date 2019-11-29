package test;

/**
 * @author ellen
 * @date 2019-11-24 22:09
 * @description：有问题
 *      为什么加了锁，三个线程也是各自卖各的——票数不是三个线程的共享资源
 *      在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 */
public class Windows1 {
    public static void main(String[] args) {
        Runner1 thread1 = new Runner1();
        Runner1 thread2 = new Runner1();
        Runner1 thread3 = new Runner1();
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Runner1 extends Thread{
    private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            synchronized (this){
            synchronized (Runner1.class){
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩下：" + this.ticket-- + "张票");
                }
            }
        }
    }
}