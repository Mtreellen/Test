package method;

/**
 * @author ellen
 * @date 2019-11-25 21:02
 * @description：yield()
 *      线程让步，① running->runnable，不释放锁，不一定会立即交出CPU
 *      ② runnable->running
 */
public class YieldTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "==" + i);
        }
    }

    public static void main(String[] args) {
        YieldTest yieldTest = new YieldTest();
        new Thread(yieldTest, "A").start();
        new Thread(yieldTest, "B").start();
        new Thread(yieldTest, "C").start();
    }
}
