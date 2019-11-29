package create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ellen
 * @date 2019-11-24 22:04
 * @description
 */
public class MyThread3 implements Callable {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
        return "The end~~";
    }
}
class TestCallable{
    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3();
        // Callable中call()的返回值类型为String
        FutureTask<String> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask).start();
        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
