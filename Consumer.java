package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:38
 * @description
 */
public class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
//        test();
        test1();
    }
    void test(){
        goods.get();
    }
    void test1(){
        while(true){
            goods.get();
        }
    }
}
