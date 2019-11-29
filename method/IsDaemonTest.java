package method;

/**
 * @author ellen
 * @date 2019-11-26 13:36
 * @description：isDaemon()方法：如果返回false，则说明该线程是“用户线程”,否则是“守护线程”
 *      垃圾回收线程就是守护线程。
 *      只要当前JVM进程中存在任何一个非守护线程没有结束，
 *      守护线程就在工作；只有当后一 个非守护线程结束时，
 *      守护线程才会随着JVM一同停止工作。
 */
public class IsDaemonTest implements Runnable{
    @Override
    public void run() {
        while(true){
//            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " 是否为守护线程" + Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 退出");
                return;
            }
        }
    }
}
class TestIsDaemon{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().isDaemon());
        IsDaemonTest isDaemonTest = new IsDaemonTest();
        Thread threadA = new Thread(isDaemonTest, "子线程 A");
        Thread threadB = new Thread(isDaemonTest, "子线程 B");
        // 将子线程A设置为守护线程
        threadA.setDaemon(true);

        threadA.start();
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();
    }
}