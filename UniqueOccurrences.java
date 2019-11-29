package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ellen
 * @date 2019-11-25 15:25
 * @description：LeetCode——1207.独一无二的出现次数
 * 统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueOccurrences {
    //TODO
    public boolean uniqueOccurrences(int[] arr) {
        return false;
    }
    public static int[] test(int[] arr){
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[j]){
                count++;
            }else{
                set.add((count + 1));
                count = 0;
                j = i;
            }
        }
        return arr;
    }
}
