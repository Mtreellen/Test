package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:41
 * @description
 */
public class Goods2 extends Goods {
    @Override
    synchronized void set(String goodsName) {
        this.setGoodsName(goodsName);
        if(this.getCount() > 0){
            System.out.println("该商品库存足够，等会再生产，先休息~~");
            // 等待商品消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setCount(this.getCount() + 1);
        System.out.println(Thread.currentThread().getName() + "生产了 " + toString() + this.getCount());
        // 唤醒等待消费的线程
        notify();
    }

    @Override
    synchronized void get() {
        if(this.getCount() == 0){
            System.out.println("该商品库存不足，客官稍等一下~~");
            // 等待商品生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setCount(this.getCount() - 1);
        System.out.println(Thread.currentThread().getName() + "消费了 " + toString() + this.getCount());
        // 唤醒生产者继续生产
        notify();
    }
}
