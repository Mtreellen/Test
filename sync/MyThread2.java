package sync;

/**
 * @author ellen
 * @date 2019-11-26 14:29
 * @description：错误集锦
 *
 */
public class MyThread2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        // 错误1
//        test1(this.ticket);

        // 错误2
//        test2(this.ticket);

        // 错误3
//        for (int i = 0; i < 100; i++) {
//            this.test3(this.ticket);
//        }

        // 错误4
        for (int i = 0; i < 100; i++) {
            this.test4(this.ticket);
        }

        // 错误5
//        testError();

    }
    private synchronized void test1(int ticket){
        for (int i = 0; i < 100; i++) {
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "还剩下 " + ticket-- + "张票");
            }
        }
    }
    private synchronized void test2(int ticket) {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "还剩下 " + ticket-- + "张票");
        }
    }
    private synchronized void test3(int ticket) {
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 剩下 " + ticket-- + "张票");
        }
    }
    private synchronized void test4(int ticket) {
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 剩下 " + this.ticket-- + "张票");
        }
    }
    private void testError() {
        // 不加判断有错误
        // 不加循环控条件也不行
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "还剩下 " + this.ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2, "A").start();
        new Thread(myThread2, "B").start();
        new Thread(myThread2, "C").start();
    }
}
