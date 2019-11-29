package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:43
 * @description
 */
public class Goods4 extends Goods {

    // 生产商品
    public synchronized void set(String goodsName){
        this.setGoodsName(goodsName);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setCount(this.getCount() + 1);
        System.out.println(Thread.currentThread().getName() + "生产了 " + toString() + this.getCount());
        // 唤醒等待消费的线程
        notifyAll();
    }

    // 消费商品
    public synchronized void get(){
        while(this.getCount() == 0){
            System.out.println("该商品库存不足，客官稍等一下~~");
            // 等待商品生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setCount(this.getCount() - 1);
        System.out.println(Thread.currentThread().getName() + "消费了 " + toString() + this.getCount());
        // 唤醒生产者继续生产
        notifyAll();
    }
}
