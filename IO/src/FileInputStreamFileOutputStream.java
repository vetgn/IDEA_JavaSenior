import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * <p>
 * 结论：
 * 1.对于文本文件(.txt,.java,.c,.cpp),使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 * @author ZJJ
 * #Description FileInputStreamFileOutputStream
 * #Date: 2022/5/21 17:17
 */
public class FileInputStreamFileOutputStream {
    @Test
    public void test1() {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            File file = new File("one.png");
            File file1 = new File("two.png");

            //不能使用字符流来处理图片等字节数据
            fr = new FileInputStream(file);
            fw = new FileOutputStream(file1);

            byte[] cbuf = new byte[5];
            int len;
            while (((len = fr.read(cbuf)) != -1)) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void copyFile(String srcPath, String destPath) {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);

            //不能使用字符流来处理图片等字节数据
            fr = new FileInputStream(srcPath);
            fw = new FileOutputStream(destPath);

            byte[] cbuf = new byte[1024];
            int len;
            while (((len = fr.read(cbuf)) != -1)) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testcopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath\\1.mp4";
        String destPath = "D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath\\2.mp4";
        copyFile(srcPath, destPath);
        long end = System.currentTimeMillis();

        System.out.println("操作消耗的时间" + (end - start));//861
    }
}
