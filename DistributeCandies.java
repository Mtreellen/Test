package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ellen
 * @date 2019-11-25 14:59
 * @description：LeetCode——575.分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 *
 */
public class DistributeCandies {
    //TODO:
    public int distributeCandies(int[] candies) {
        HashSet< Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
    public int distributeCandies1(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
}
