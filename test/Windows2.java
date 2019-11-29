package test;

/**
 * @author ellen
 * @date 2019-11-24 22:15
 * @description：
 */
public class Windows2{
    public static void main(String[] args) {
        Runner2 runner2 = new Runner2();
        new Thread(runner2, "窗口1").start();
        new Thread(runner2, "窗口2").start();
        new Thread(runner2, "窗口3").start();
    }
}
class Runner2 implements Runnable{
    private Integer ticket = 10;
//    @Override
//    public void run(){
//        for (int i = this.ticket; i > 0; i--) {
//            System.out.println(Thread.currentThread().getName() + "剩下：" + this.ticket + "张票");
//        }
//    }
//    @Override
//    public void run() {
//        for (int i = this.ticket; i > 0; i--) {
//            System.out.println(Thread.currentThread().getName() + "剩下：" + this.ticket-- + "张票");
//        }
//    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩下：" + this.ticket-- + "张票");
                }
//            }
        }
    }
}
