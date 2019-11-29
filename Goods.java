package ProducerAndConsumer.version1;

/**
 * @author ellen
 * @date 2019-11-28 14:31
 * @description
 */
public abstract class Goods {
    private String goodsName;//商品名称
    private int count;//库存

    public int getCount() {
        return count;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setCount(int count) {
        this.count = count;
    }

    abstract void set(String goodsName);
    abstract void get();

    @Override
    public String toString() {
        return "Goods{ " +
                "goodsName = '" + goodsName + '\'' +
                " }";
    }
}
