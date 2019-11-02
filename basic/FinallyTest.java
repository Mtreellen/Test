package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest {
    public void test1(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch(ArithmeticException e){
            e.printStackTrace();
            int[] arr = new int[10];
            System.out.println(arr[10]);
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("一定会执行的代码——finally");
        }
    }

    public String test2(){
        try{
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return "没有异常";
        }catch(Exception e){
            e.printStackTrace();
            return "有异常";
        }finally{
            System.out.println("一定会执行——finally");
        }
    }

    public String test3(){
        try{
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return "没有异常";
        }catch(Exception e){
            e.printStackTrace();
            return "有异常";
        }finally{
            System.out.println("一定会执行——finally");
            return "finally";
        }
    }

    public void test4(){
        FileInputStream fis = null;
       try{
           File file = new File("hello.txt");//放到当前工程目录下
           fis = new FileInputStream(file);

           int data = fis.read();
           while (data != -1) {
               System.out.print((char) data);
               data = fis.read();
           }
       }catch(FileNotFoundException e){
           e.printStackTrace();
       }catch(IOException e){
           e.printStackTrace();
       }finally{
           try {
               if(fis != null)
                   fis.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    public void test5(){
        FileInputStream fis = null;
        try{
            File file = new File("hello1.txt");//放到当前工程目录下
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FinallyTest finallyTest = new FinallyTest();
        //finallyTest.test1();

//        String num = finallyTest.test2();
//        System.out.println(num);//有异常

//        String s = finallyTest.test3();
//        System.out.println(s);//finally

//        finallyTest.test4();

        finallyTest.test5();

    }
}
