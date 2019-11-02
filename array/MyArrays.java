package array;

import java.util.Arrays;

/**
 * @author mtreellen
 * @date 2019-10-26-19:49
 */
public class MyArrays {
    /**
     * @param arr
     * @return：数组的最大值
     */
    public static int max(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > res){
                res = arr[i];
            }
        }
        return res;
    }

    /**
     * @param arr
     * @return：数组的最小值
     */
    public static int min(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < res){
                res = arr[i];
            }
        }
        return res;
    }

    /**
     * @param arr
     * @return：数组的平均值
     */
    public static double average(int[] arr){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (sum / arr.length);
    }

    /**
     * 数组逆置
     * @param arr
     */
    public static void reverse(int[] arr){
        for (int i = 0, j = arr.length - 1 ; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /**
     * reverse array
     * @param arr
     */
    public static void reverse1(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1- i];
            arr[arr.length - 1- i] = tmp;
        }
    }

    /**
     * Returns the subscript for the index of array elements
     * @param arr
     * @param index
     * @return
     */
    public static int indexOf(int[] arr, int index){
        if(index < 0 || index >= arr.length){
            return -1;
        }
        return arr[index];
    }

    /**
     * Returns the element value as the key subscript, if not exists returns -1
     * @param key
     * @return the element value as the key, if can not find returns -1
     */
    public static int find(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * bubble sort array
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    /**
     * binary search
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key){
        int low = 0;
        int height = arr.length - 1;
        while(low <= height){
            int mid  = (low + height) / 2;
            if(key > arr[mid]){
                height = mid - 1;
            }else if(key < arr[mid]){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * binary search by recursion
     * @param arr
     * @param low
     * @param height
     * @param key
     * @return
     */
    public static int binarySearch1(int[] arr, int low, int height,int key){
        if(low > height){
            return -1;
        }
        int mid = (low + height) / 2;
        if(arr[mid] == key){
            return mid;
        }else if(key > arr[mid]){
            return binarySearch1(arr,low,mid - 1, key);
        }else if(key < arr[mid]){
            return binarySearch1(arr, mid + 1, height,key);
        }
        return -1;
    }

    /**
     * Put the even numebers in front of the odd numbers.
     * @param arr
     */
    public static void putEvenInFrontOfOdd(int[] arr){
        for (int i = 0, j = 1; j < arr.length && i < arr.length; j++) {
            if(arr[j] % 2 == 0){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
//            if(arr[i] % 2 == 0){
//                i++;
//            }
        }
    }

    /**
     * Functional testing
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 10, 7, 9, 5, 1, 2, 0, 8, 2, 4};
        System.out.println("原数组打印" + Arrays.toString(arr));
        putEvenInFrontOfOdd(arr);
        System.out.println("偶数放在奇数前面：" + Arrays.toString(arr));
        System.out.println("数组最大值：" + max(arr));
        System.out.println("数组最小值：" + min(arr));
        System.out.println("数组平均值：" + average(arr));
        System.out.println("原数组打印：" + Arrays.toString(arr));

//        System.out.println(find(arr, 10));
//        System.out.println(find(arr, -1));

        reverse(arr);
        System.out.println("数组逆置1：" +  Arrays.toString(arr));
        reverse1(arr);
        System.out.println("数组逆置2：" +  Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("冒泡排序（降序）：" +  Arrays.toString(arr));

        System.out.println("二分查找（循环）：" + binarySearch(arr, 1));
        System.out.println("二分查找（递归）：" + binarySearch1(arr, 0,arr.length - 1, 1));
    }
}
