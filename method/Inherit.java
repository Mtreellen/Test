package method;

/**
 * @author ellen
 * @date 2019-11-26 13:29
 * @description：线程具有继承性（继承优先级）
 */
public class Inherit implements Runnable{
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority()
        );
        // 在子线程A中启动孙子线程B
        new Thread(new ChildThread(), "孙子线程B").start();
    }
}

class ChildThread extends Inherit implements Runnable{
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority()
        );
    }
}
class Test{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
        Inherit inherit = new Inherit();
        Thread thread = new Thread(inherit, "子线程A");
        thread.setPriority(
                Thread.MAX_PRIORITY
        );
        thread.start();
    }
}