package method;

/**
 * @author ellen
 * @date 2019-11-25 20:56
 * @description
 */
public class SleepTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "==" + i);
            /*
            sleep() 立马交出 CPU，不会释放锁
             */
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        new Thread(sleepTest, "A").start();
        new Thread(sleepTest, "B").start();
        new Thread(sleepTest, "C").start();
    }
}

