package method;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ellen
 * @date 2019-11-25 21:02
 * @description：join()
 *      - 等待其他线程终止
 *      - 等待该线程终止
 *      - 如果在主线程调用该方法，会让主线程休眠，而调用该方法的线程会执行，
 *      直到该线程执行完毕后，主线程才恢复执行
 *      - 会释放对象锁
 *      - a.join()，b从运行回阻塞，又从阻塞回到运行
 */
public class JoinTest implements Runnable{
    @Override
    public void run() {
        System.out.println("主线程休眠开始。。。");
        printTime();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程休眠结束。。。");
        printTime();
    }

    private static void printTime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);
        System.out.println(str);
    }
    public static void main(String[] args) {
        System.out.println("main start..");
        JoinTest joinTest = new JoinTest();
        Thread th1 = new Thread(joinTest, "子线程A");
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end..");
    }
}
