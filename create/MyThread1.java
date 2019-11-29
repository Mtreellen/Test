package create;

/**
 * @author ellen
 * @date 2019-11-24 20:59
 * @description：创建线程——继承Thread类，重写run()方法
 *   通过实例化Runner2类的一个对象就可以开辟一个新的线程
 *   调用从Thread类继承来的start()方法就可以启动新开辟的线程
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--"+ i);
        }
    }
}
class TestThread{
    public static void main(String[] args) {
        MyThread1 mh1 = new MyThread1();
        MyThread1 mh2 = new MyThread1();
        mh1.setName("线程A");
        mh2.setName("线程B");
        mh1.start();
        mh2.start();
    }
}