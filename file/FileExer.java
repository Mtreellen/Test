package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author mtreellen
 * @date 2019-10-23-16:34
 */
public class FileExer {
    @Test
    public void test() throws IOException {
        File file = new File("E:\\io\\hi.txt");
        File file1 = new File(file.getParent(),"haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }
}
