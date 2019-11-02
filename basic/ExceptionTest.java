package basic;

import java.util.Date;
import java.util.Scanner;

public class ExceptionTest {
    //unckeckedException

    //NullPointerException
    public void test1(){
        int[] arr = null;
        System.out.println(arr);//null
        System.out.println(arr[0]);//exception
    }
    //IndexOutofBoundsException
    public void test2(){
        int[] arr = new int[10];
        System.out.println(arr[10]);//ArrayIndexOutOfBoundsException

        String s = "haha";
        System.out.println(s.charAt(4));//StringIndexOutOfBoundsException
    }
    //ClasscastException
    public void test3(){
        Object obj = new Date();
        String s = (String)obj;
    }

    //NumberFormatException
    public void test4(){
        String s = "abc";
        int num = Integer.parseInt(s);
    }

    //InputMismatchException
    public void test5(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
    }
    //ArithmeticException
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a / 0);
    }

    //checkedException，编译时异常
   /* public void test(){
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }*/

    public static void main(String[] args) {
        ExceptionTest e = new ExceptionTest();
        //e.test1();
        //e.test2();
        //e.test3();
        //e.test4();
        //e.test5();
        //e.test6();
    }
}
