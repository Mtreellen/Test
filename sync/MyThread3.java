package sync;

/**
 * @author ellen
 * @date 2019-11-26 14:38
 * @description：疑问
 */
public class MyThread3 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        // 同步代码块
//        test1();

        // 同步方法
        // 有问题
//        for (int i = 0; i < 100; i++) {
//            test2(this.ticket);
//        }

        // 反射机制
        // 有问题
//        test3(this.ticket);
    }

    //synchronized 是对象锁，锁的是对象，静态方法中不能有 this关键字
    // 也不能有 Object 对象
    // 此方法不能用
    /*
    private static void test1(int ticket) {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下 " + ticket-- + "张票");
                }
            }
        }
    }
    */
    private static synchronized void test2(int ticket) {
        if (ticket > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 剩下 " + ticket-- + "张票");
        }
    }
    private static void test3(int ticket){
        for (int i = 0; i < 100; i++) {
            synchronized (MyThread1.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩下 " + ticket-- + "张票");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        new Thread(myThread3, "A").start();
        new Thread(myThread3, "B").start();
    }
}
