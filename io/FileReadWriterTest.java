package io;

import org.junit.Test;

import java.io.*;

/**
 * @author mtreellen
 * @date 2019-10-23-17:03
 */
public class FileReadWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");

    }
    @Test
    public void testFileRead(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            int read = fr.read();
            while(read != -1){
                System.out.print((char)read);
                read = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            File file = new File("hello1.txt");
            fw = new FileWriter(file, true);
            fw.write("I have a dream!!!\n");
            fw.write("Do you remember??\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopy(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
