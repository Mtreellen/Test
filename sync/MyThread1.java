package sync;

/**
 * @author ellen
 * @date 2019-11-26 14:20
 * @description
 */
public class MyThread1 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        // 同步代码块
//        test1();

        // 同步方法1
//        for (int i = 0; i < 100; i++) {
//            test2();
//        }
        // 同步方法2
        for (int i = 0; i < 100; i++) {
            test4(this.ticket);
        }

        // 反射机制
//        test3();
    }
    /**
     * 同步代码块
     */
    private void test1() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                //------------------------同步代码块---------------------------
                if (this.ticket > 0) {
                    // sleep()：模拟网络延迟
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下 " + this.ticket-- + "张票");
                }
                //-------------------------------------------------------------
                // 隐式解锁
            }
        }
    }

    /**
     * 同步方法
     */
    private synchronized void test2() {
        if (this.ticket > 0) {
            // sleep()：模拟网络延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 剩下 " + this.ticket-- + "张票");
        }
    }

    /**
     * 有问题
     * @param ticket
     */
    private synchronized void test4(int ticket){
        //改为this.ticket就ok，所以说传参无意义
        if(ticket > 0){
                try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 剩下 " + this.ticket-- + "张票");
        }
    }
    /**
     * 反射机制
     */
    private void test3(){
        for (int i = 0; i < 100; i++) {
            synchronized (MyThread1.class) {
                //------------------------同步代码块---------------------------
                if (this.ticket > 0) {
                    // sleep()：模拟网络延迟
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩下 " + this.ticket-- + "张票");
                }
                //-------------------------------------------------------------
                // 隐式解锁
            }
        }
    }
}
