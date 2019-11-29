package create;

/**
 * @author ellen
 * @date 2019-11-24 21:32
 * @description
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -- "+ i);
        }
    }
}
class TestRunnable{
    public static void main(String[] args) throws InterruptedException {
//        testLambda();
        testRunnable();
    }
    public static void testRunnable(){
        MyThread2 mh1 = new MyThread2();
        Thread th1 = new Thread(mh1, "线程A");
        Thread th2 = new Thread(mh1, "线程B");
        th1.start();
        th2.start();
    }
    public static void testLambda(){
        Runnable runnable = () -> System.out.println("Hello world");
        new Thread(runnable).start();

    }
}
