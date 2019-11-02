package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mtreellen
 * @date 2019-10-23-9:24
 */
public class ArrayTest {
    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
        test3();
    }
    public static void test(){
        String[] arr = new String[3];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new String();
            System.out.println(arr[i]);
        }
        System.out.println(arr);
        String s = new String();
        System.out.println(s);//空  （有别于null）
    }

    /**
     * 创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
     */
    public static void test1(){
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 30 + 1);
            boolean flag = false;
            while(true){
                for (int j = 0; j < i; j++) {
                    if(arr[j] == arr[i]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    arr[i] = (int)(Math.random() * 30 + 1);
                    flag = false;
                    continue;
                }
                break;
            }
            System.out.println(arr[i]);
        }
    }
    public static void test2(){
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30 + 1);
            for (int j = 0; j < i; j++) {
                if(arr[j] == arr[i]){
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * TODO:回形数格式方阵的实现
     */
    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数字");
        int len = scanner.nextInt();
        int[][] arr = new int[len][len];

        int s = len * len;
        /*
         * k = 1:向右 k = 2:向下 k = 3:向左 k = 4:向上
         */
        int k = 1;
        int i = 0, j = 0;
        for (int m = 1; m <= s; m++) {
            if (k == 1) {
                if (j < len && arr[i][j] == 0) {
                    arr[i][j++] = m;
                } else {
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            } else if (k == 2) {
                if (i < len && arr[i][j] == 0) {
                    arr[i++][j] = m;
                } else {
                    k = 3;
                    i--;
                    j--;
                    m--;
                }
            } else if (k == 3) {
                if (j >= 0 && arr[i][j] == 0) {
                    arr[i][j--] = m;
                } else {
                    k = 4;
                    i--;
                    j++;
                    m--;
                }
            } else if (k == 4) {
                if (i >= 0 && arr[i][j] == 0) {
                    arr[i--][j] = m;
                } else {
                    k = 1;
                    i++;
                    j++;
                    m--;
                }
            }
        }

        // 遍历
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[m].length; n++) {
                System.out.print(arr[m][n] + "\t");
            }
            System.out.println();
        }
    }
}

class ArrayTest1 {
    public static void main(String[] args) {
        //Access to an array of student's grade.
        int[] arr = gainScore();
        //Print this array about student's grade.
        printArray(arr);
        //Ascending sort an array
        sort(arr);
        System.out.println("从低到高排序：");
        printArray(arr);
        System.out.println("查询已经有序的数组中成绩为89的下标：");
        System.out.println(find(arr, 89));
        System.out.println("复制成绩最低三名构成新数组:");
        int[] arr1 = copyOf(arr);
        printArray(arr1);
        System.out.println("工具类打印成绩最低三名成绩:");
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] gainScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本组学生人数> ");
        int input = scanner.nextInt();
        int[] arr = new int[input];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩> ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void sort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int[] copyOf(int[] arr) {
        int[] newArr = new int[3];
        sort(arr);
        for (int i = 0; i < 3; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}

class ArrayTest2{
    public static void main(String[] args) {
//        test();
//        test2();
//        test3();
//        test5();
//        test6();
        test7();
    }

    /**
     * 创建一个char类型的26个元素的数组，分别 放置'A'-'Z'。
     * 使用for循环访问所有元素并打印出来。
     */
    public static void test(){
        char[] chars = new char[100];
        for (int i = 65,j = 0; i <= 90 && j < 26; i++, j++) {
            chars[j] = (char)i;
            System.out.println("chars[" + j + "] = " + chars[j] + " ");
        }
    }
    public static void test1(){
        char[] chars = new char[36];
        char ch = 'A';
        for (int i = 0; i < chars.length; i++) {
        //TODO:
        }
    }

    /**
     * 一维数组a[]，将数组元素顺序颠倒
     */
    public static void test2(){
        int[] arr = new int[]{12, 34, 54, 3, 7, 8, 1, -23};
        for (int i = 0,j = arr.length - 1; i<=j ; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void test3() {
        int[] a = new int[] { (int) (Math.random() * 1000),
                (int) (Math.random() * 1000), (int) (Math.random() * 1000),
                (int) (Math.random() * 1000), (int) (Math.random() * 1000) };

        System.out.println(a);
        System.out.println(Arrays.toString(a));
        swap(a);
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int a[]) {
        int len = a.length;
        for (int i = 0; i < len / 2; i++) {
            int tmp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = tmp;
        }
    }
    public static void test4(){
        int age = 22;
        String[] str = new String[]{"儿童", "少年", "青少年", "青年", "壮年", "中年", "", "", "", ""};
        int idx = age / 10;
        System.out.println(str[idx]);
    }

    /**
     * 用数组求出斐波那契数列的前20项值
     */
    public static void test5(){
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 0; i < 17; i++) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[0] + arr[1];
        }
        System.out.println(arr[2]);
    }

    /**
     * 对10个整数进行按照从小到大的顺序排序
     */
    public static void test6(){
        int[] arr = new int[]{43, 5, 32, -1, 8, 9, 0, -65, 32, 5};
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
                if(!flag){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 求一个3*3矩阵对角线元素之和
     */
    public static void test7(){
        int[][] arr = new int[3][3];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = (int)(Math.random() * 100);
                System.out.print("arr[" + i + "][" + j + "] = " + arr[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.toString(arr));//[[I@14ae5a5, [I@7f31245a, [I@6d6f6e28]

        for (int i = 0; i < arr[0].length; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum);
    }
}
class ArrayTest3{
    public static void main(String[] args) {
        test();
    }
    /**
     * 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
     */
    public static void test(){
//        int value = 6;
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 7, 8, 8, 9);
//        for (int i = list.size() - 1; i >= 0 ; i++) {
//            if(value < list.get(i)){
//                list.add(i + 1, list.get(i));
//            }
//            if(value >= list.get(i)){
//                list.set(i, value);
//            }
//        }
//        for (Integer i : list){
//            System.out.print(i + " ");
//        }

    }
}
class ArrayTest4{
    public static void main(String[] args) {
        printYanghuiTriangle(10);
    }

    /**
     *  Print YangHuiTriangle use the for loop
     * @param row: how many rows of YangHuiTriangle you want to print
     */
    public static void printYanghuiTriangle(int row){
        int[][] arr = new int[row][];
        //i means how many rows the array have
        for (int i = 0; i < arr.length; i++) {
            //every lows are different, first low have one elemen, second have two element...
            arr[i] = new int[i + 1];
            //this loop to control the lows ergodic process
            for (int j = 0; j < arr[i].length; j++) {
                //let every elements of array as 1
                arr[i][j] = 1;
                //when elements equals the third row and second col, let the elements as last two elements plus
                //this two elements are before this element
                if(i > 1 && j > 0 && j < arr[i].length - 1){
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                //ergodic array
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}