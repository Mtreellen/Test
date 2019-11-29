package method;

/**
 * @author ellen
 * @date 2019-11-26 13:21
 * @description：线程优先级
 */
public class PriorityTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "===" +i);
        }
    }

    public static void main(String[] args) {
        PriorityTest priorityTest = new PriorityTest();
        Thread thread1 = new Thread(priorityTest, "子线程A");
        Thread thread2 = new Thread(priorityTest, "子线程B");
        Thread thread3 = new Thread(priorityTest, "子线程C");
        thread1.setPriority(
                Thread.MIN_PRIORITY
        );
        thread2.setPriority(
                Thread.MAX_PRIORITY
        );
        thread3.setPriority(
                Thread.NORM_PRIORITY
        );
        thread1.start();
        thread2.start();
        thread3.start();
        // 主线程优先级为 普通优先级：5
        System.out.println(Thread.currentThread().getPriority());
    }
}
