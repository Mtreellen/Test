package method;

/**
 * @author ellen
 * @date 2019-11-26 13:01
 * @description：interrupt()方法
 */
public class InterruptTest implements Runnable{
    @Override
    public void run() {
//        test1();
        test2();
//        test3();
    }
    private static void test3(){
        int i = 1;
        while(true){
            try {
                Thread.sleep(1000);
                boolean b = Thread.currentThread().isInterrupted();
                if(b){
                    System.out.println("线程退出...");
                    break;
                }
                System.out.println(
                        Thread.currentThread().getName() + "第" + i + "次执行.."
                );
                System.out.println(b);
                i++;
            } catch (InterruptedException e) {
                System.out.println("异常，线程停止...");
                System.out.println(
                        "catch块中中断状态为：" + Thread.currentThread().isInterrupted()
                );
                // ??
                return;
            }
        }
    }
    private static void test2(){
        int i = 1;
        while(true){
            boolean b = Thread.currentThread().isInterrupted();
            if(b){
                System.out.println("线程退出...");
                break;
            }
            System.out.println(
                    Thread.currentThread().getName() + "第" + i + "次执行.."
            );
            System.out.println(b);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            i++;
        }
    }
    private static void test1(){
        int i = 1;
        while(true){
            boolean b = Thread.currentThread().isInterrupted();
            System.out.println(
                    Thread.currentThread().getName() + "第" + i + "次执行.."
            );
            System.out.println(b);
            if(b){
                System.out.println("线程退出...");
                break;
            }
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest interruptTest = new InterruptTest();
        Thread thread = new Thread(interruptTest, "线程A");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}