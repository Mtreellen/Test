package string;

import java.util.Arrays;

/**
 * @author mtreellen
 * @create 2019-10-10-15:10
 */
public class StringTest1 {
    public static void test(){
        String[] arr = new String[]{"AA", "AA", "AA"};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "CC";//直接修改哦！！！
        }
        System.out.println(arr.toString());//[Ljava.lang.String;@1b6d3586
        System.out.println(Arrays.toString(arr));//[CC, CC, CC]

        for(String s : arr){
            s = "BB";//新的变量哦！！！
            System.out.print(s + " ");//BB BB BB
        }
        System.out.println("\n" + Arrays.toString(arr));//[CC, CC, CC]
    }

    public static void main(String[] args) {
        test();
    }
}
