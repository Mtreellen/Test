package arraylist.test;

import org.junit.Test;

import javax.management.relation.RoleUnresolved;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ellen
 * @date 2019-11-15 11:00
 * @description：顺序表基本操作
 */
// 自定义顺序表
public class MyArrayList {
    private Object[] elem;
//    private Integer usedSize;
    private int usedSize;// 标记顺序表已经使用的下标个数（有效数据个数）
    private int MAX_CAPACITY = 10;// 默认顺序表大小为 10
    // new 一个对象，这个对象（顺序表）就拥有了对应的 this.elem 和 this.usedSize

    // 顺序表大小为默认值：MAX_CAPACITY = 10
    public MyArrayList(){
        this.usedSize = 0;// 此时顺序表长度为 0
        this.elem = new Object[MAX_CAPACITY];// 创建当前顺序表的数组， 数组大小为 10
    }

    // 顺序表大小为指定值：capacity
    public MyArrayList(int capacity){
        this.usedSize = 0;// 此时顺序表长度为 0
        this.elem = new Object[capacity];// 创建当前顺序表的数组， 数组大小为 capacity
    }

    // 获取顺序表长度
    public int getUsedSize() {
        return usedSize;
    }
    // 再对这个对象的 数组（elem） 进行操作，利用到 标记（usedSize）

    /**
     * 判断当前顺序表是否为空
     * @return：
     *          当前顺序表为空，返回true
     *          不为空，返回false
     */
    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    /**
     * 判断当前顺序表是否为满
     * @return：
     *          当前顺序表满了，返回true
     *          没满，返回false
     */
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    /**
     * 按顺序添加元素到 顺序表 中
     * @param data：要添加的元素
     */
    public void add(Object data) {
        // 如果顺序表满了，就应该扩容了
        if(isFull()){
            // 满了，扩容
            this.elem = capacity(this.elem);
        }
        // 不需要扩容或者已经扩容完成
        // 添加元素：usedSize 标记已经使用元素的个数，每次添加就是在下标等于 usedSize 处添加
        this.elem[this.usedSize] = data;
        // 元素添加后，顺序表长度加一
        this.usedSize++;
    }

    /**
     * @param pos：要插入元素的位置
     * @param data：要在pos位置插入的数据
     */
    public void add(int pos, int data){
        if(isFull()){
            //数组满了，则扩容
            this.elem = capacity(this.elem);
        }
        if(pos < 0 || pos > elem.length){
            return;
        }
        //pos后的数据往后移动一个单位
        for(int i = this.usedSize; i > pos; i--){
            this.elem[i] = this.elem[i - 1];
        }
        //插入数据
        this.elem[pos] = data;
        this.usedSize++;
    }


    /**
     * 指定位置插入元素
     * @param pos：要添加元素的下标
     * @param data：要添加的元素
     */
    public void insert(int pos, Object data){
        // 检验下标是否合法
        if(pos > this.elem.length || pos < 0 || pos > usedSize){
            throw new RuntimeException("下标不合法");
        }
        // 如果顺序表满了，就应该扩容了
        if(isFull()){
            // 满了，扩容
            this.elem = capacity(this.elem);
        }

        // 不需要扩容或者已经扩容完成

        /*
            1.找到指定的下标位置 pos，将 pos 下标以及其之后的元素都向后移动一个单位
            2.将 data 数据插入 pos 位置
        */
        int i = 0;
        for (i = this.usedSize; i > pos ; i--) {// i 不能等于 pos
            // 1.
            this.elem[i] = this.elem[i - 1];// 注意数组越界问题
        }
        // 2.
        this.elem[i] = data;

        // 添加数据完成，顺序表长度加1
        this.usedSize++;
    }

    /**
     * 顺序表扩容
     * @param elem：传入顺序表的数组
     * @return：返回扩容后新的数组
     * 注意：usedSize 是顺序表长度，扩容时其没有发生改变， 所以只对数组操作即可
     */
    private Object[] capacity(Object[] elem){
        // 创建新的数组，容量为原数组elem的两倍
        Object[] objects = new Object[elem.length * 2];
        // 利用 Arrays 中的 copyOf方法将elem数组元素的复制到新的扩容好的数组objects中
        objects = Arrays.copyOf(elem,elem.length * 2);
        // 返回新的数组
        return objects;
    }

    /**
     * 打印顺序表元素
     */
    public void display() {
        // 如果顺序表为空，就不打印(结束方法)
        if (isEmpty()) {
            System.out.println("顺序表为空!!");
            return;
        }
        // 利用 for 循环遍历打印顺序表中元素
        // [ 0, this.usedSize )
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(i + " " + this.elem[i]);
        }
    }


    /**
     * 删除顺序表中指定位置（下标）的元素
     * @param pos：要删除的元素下标
     * @return
     *          删除成功，返回true
     *          不成功，返回false
     */
    public boolean delete(int pos){
        // 检验下标是否合法
        if(pos > this.elem.length || pos < 0 || pos >= this.usedSize){
            throw new RuntimeException("下标不合法");
        }
        // 如果顺序表为空，删除失败，返回false
        if (isEmpty()) {
            System.out.println("顺序表为空!!");
            return false;
        }
        // [ pos, this.usedSize)
        for (int i = pos; i < this.usedSize; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        // 删除成功后，顺序表中有效元素个数减1（顺序表长度减1）
        this.usedSize--;
        return true;
    }

    /**
     * 根据元素值删除元素
     * @param data：要删除的元素
     * @return
     *          删除成功返回true
     *          不成功返回false
     */
    public boolean removeValue(Object data){
        // 如果顺序表为空，删除失败，返回false
        if (isEmpty()) {
            System.out.println("顺序表为空!!");
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
//            if(data.equals(this.elem[i])){
            if(contains(data)){
                delete(i);
                return true;
            }
        }
        // data 不存在于顺序表中
        return false;
    }

    /**
     *  判定是否包含某个元素
     * @param data
     * @return
     *          顺序表包含该元素，返回true
     *          不包含，返回false
     * ArrayList的 contains() 底层调用了 indexOf()
     */
    public boolean contains(Object data){
        // 如果顺序表为空，返回false
        if (isEmpty()) {
            System.out.println("顺序表为空!!");
            return false;
        }
        return search(data) >= 0;
    }

    /**
     * 指定元素是否存在于顺序表中：
     *      如果是基本数据类型，直接比较值是否相等
     *      如果是引用数据类型，类类型就比较某个或某几个属性值是否相等
     *                          数组比较名字
     *                          String类型用 equals()
     * @param data：要查找的元素
     * @return：
     *          找到返回下标
     *          没找到返回 -1
     */
    public int search(Object data){
        // 顺序表为空，不用找了，直接返回 -1 或者 提示顺序表为空（可以抛出一个异常）
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");// 直接结束方法
        }
        // ArrayList 的 indexOf() 源码
        if(data == null){
            for (int i = 0; i < this.elem.length; i++) {
                if(this.elem[i] == null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < this.elem.length; i++) {
                if(data.equals(this.elem[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    public Object getPos(int pos){
        if(this.usedSize <= 0 || pos < 0 || pos > this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }

    /**
     * 设置 pos 位置的值为 data
     * @param pos
     * @param data
     */
    public void set(int pos, Object data){
        // 检验下标是否合法
        if(pos > this.elem.length || pos < 0){
            throw new RuntimeException("下标不合法");
        }
        if(pos >= this.usedSize){
            throw new RuntimeException("下标无效");
        }
        // 如果顺序表为空
        if(isFull()){
            System.out.println("顺序表为空");
            return;
        }
        this.elem[pos] = data;
    }

    /**
     * 清空顺序表
     */
    public boolean clear(){
        this.usedSize = 0;
        return true;
    }
}
