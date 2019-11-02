package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author mtreellen
 * @create 2019-10-18-12:26
 */
public class FileTest {
    @Test
    public void test(){
        File file = new File("hello.txt");
        File file1 = new File("E:\\1_Code\\Java\\IDEA\\Practice1\\src\\file");

        System.out.println(file);
        System.out.println(file1);

        File file2 = new File("E:\\1_Code\\Java\\IDEA\\Practice1", "src\\file");
        System.out.println(file2);

        File file3 = new File(file2, "a.txt");
        System.out.println(file3);
    }
    @Test
    public void test1(){
        File file = new File("hello.txt");
        File file1 = new File("D:\\io\\hi.txt");

        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile);
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
        System.out.println("**************************");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }
    @Test
    public void test2(){
        File file = new File("E:\\1_Code\\Java\\IDEA\\Practice1");
        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }
    @Test
    public void test3(){
        File file = new File("hello.txt");
        File file1 = new File("E:\\io\\hi.txt");
        boolean renameTo = file.renameTo(file1);
        System.out.println(renameTo);
    }
    @Test
    public void test4(){
//        File file = new File("hello.txt");
        File file = new File("E:\\io");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    @Test
    public void test5() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("成功创建");
        }else{
            file.delete();
            System.out.println("删除");
        }
    }
    @Test
    public void test6(){
        File file = new File("E:\\io\\io1\\io3");
        boolean isMkdir = file.mkdir();
        if(isMkdir){
            System.out.println("创建成功1");
        }
        File file1 = new File("E:\\io\\io1\\io2");
        boolean isMkdir1 = file.mkdirs();
        if(isMkdir1){
            System.out.println("创建成功2");
        }
    }
}
