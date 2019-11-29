package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:33
 * @description
 */
public class Goods1 extends Goods {
    // 生产商品
    @Override
    synchronized void set(String goodsName) {
        this.setGoodsName(goodsName);
        this.setCount(this.getCount() + 1);
        System.out.println(Thread.currentThread().getName() + "生产了 " + toString() + this.getCount());
    }
    // 消费商品
    @Override
    synchronized void get() {
        this.setCount(this.getCount() - 1);
        System.out.println(Thread.currentThread().getName() + "消费了 " + toString() + this.getCount());
    }
}
