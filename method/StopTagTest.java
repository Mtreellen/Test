package method;

/**
 * @author ellen
 * @date 2019-11-25 21:20
 * @description
 */
public class StopTagTest implements Runnable {
    private Boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while(flag){
            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行");
            try {
                Thread.sleep(1000);//子线程休眠1秒
            } catch (InterruptedException e) {//中断异常
                e.printStackTrace();
            }
            i++;
        }
    }
    public void setFlag(Boolean flag){
        this.flag = flag;
    }

    public static void main(String[] args) {
        StopTagTest thread = new StopTagTest();
        Thread thread1 = new Thread(thread, "子线程");
        thread1.start();
        try {
            Thread.sleep(5000);//主线程休眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setFlag(false);//主线程休眠三秒后才执行此代码，然后线程停止
    }
}
