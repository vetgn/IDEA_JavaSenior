import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author ZJJ
 * #Description RandomAccessFileTest
 * #Date: 2022/7/23 16:39
 */
/*
 * RandomAccessFile的使用
 * 1. RandomAccessFile直接继承于java.Lang.Object类,实现了DataInput 和DataOutput接口
 * 2. RandomAccessFile既可以作为一个输入流,又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时,写出到的文件如果不存在,则在执行过程中自动创建
 * 如果写出到的文件存在,则会对原有文件内容进行覆盖。(默认情况下,从头覆盖)
 *
 * r:以只读方式打开
 * rw:打开以便读取和写入
 * rwd:打开以便读取和写入;同步文件内容的更新
 * rws:打开以便读取和写入;同步文件内容和元数据的更新
 *
 * 如果模式为只读r。则不会创建文件,而是会去读取一个已经存在的文件,如果读取的文件不存在则会出现异常。
 * 如果模式为rw读写。如果文件不存在则会去创建文件,如果存在则不会创建。
 * */

public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("one.png"), "r");
            raf2 = new RandomAccessFile(new File("one1.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null) {
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null) {
                    raf2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());

        raf1.close();
    }
}