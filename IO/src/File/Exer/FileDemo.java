package File.Exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author ZJJ
 * #Description FileDemo
 * #Date: 2022/5/19 21:51
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath\\hello.txt");
        //创建一个与file同目录下的另一个文件，文件名为:haha.txt
        File file1 = new File(file.getParent(), "haha.txt");
        boolean newfile = file1.createNewFile();
        if (newfile) {
            System.out.println("创建成功!");
        }
    }

    /*判断指定目录下是否有后缀名为.jpg的文件,如果有,就输出该文件名称*/
    @Test
    public void test1() {
        File file = new File("D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath");
        String[] str = file.list();
        for (int i = 0; i < str.length; i++) {
            if (str[i].endsWith(".jpg")) {
                System.out.println(str[i]);
            }
        }
    }

    /*遍历指定目录所有文件名称,包括子文件目录中的文件。
    拓展1:并计算指定目录占用空间的大小
    拓展2:删除指定文件目录及其下的所有文件 */
    @Test
    public void test2() {
        File file = new File("D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath");
        PrintFile(file);
    }

    public void PrintFile(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                PrintFile(files[i]);
            } else {
                System.out.println(files[i].getAbsoluteFile());
            }
        }
    }
}
