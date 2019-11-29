package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:39
 * @description
 */
public class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
//        test();
//        test1();
        test2();
    }
    void test(){
        goods.set(" 鸿星尔克球鞋201.2号 ");
    }
    void test1(){
        while(true){
            goods.set(" 鸿星尔克球鞋201.2号 ");
        }
    }
    void test2(){
        while(goods.getCount() < 10){
            goods.set(" 鸿星尔克球鞋201.2号 ");
        }
    }
}
