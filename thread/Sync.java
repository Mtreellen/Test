package thread;

/**
 * @author mtreellen
 * @date 2019-10-31-22:01
 */
public class Sync {
    public synchronized void test(){
        System.out.println(Thread.currentThread().getName() + "方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((Thread.currentThread().getName() + "方法结束"));
    }
}
