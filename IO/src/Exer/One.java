package Exer;

import java.io.*;

/**
 * 分别使用节点流: FilelnputStream、FileOutputStream和缓冲流:BufferedlnputStream、 BufferedOutputStream实现文本文件图片/视频文件的复制。并比较二者在数据复制方面的效率
 *
 * @author ZJJ
 * #Description One
 * #Date: 2022/6/6 15:08
 */
public class One {
    public void copy1(String srcPath, String dirPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(dirPath);
            byte[] cbuf = new byte[10];
            int len;
            while ((len = fileInputStream.read(cbuf)) != -1) {
                fileOutputStream.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void copy2(String srcPath, String dirPath) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dirPath));

            byte[] cbuf = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(cbuf)) != -1) {
                bufferedOutputStream.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        One one = new One();
        one.copy1("D:\\JavaCode\\IDEA_JavaSenoir\\IO\\hello.txt", "D:\\JavaCode\\IDEA_JavaSenoir\\IO\\hello4.txt");
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        one.copy2("D:\\JavaCode\\IDEA_JavaSenoir\\IO\\hello.txt", "D:\\JavaCode\\IDEA_JavaSenoir\\IO\\hello5.txt");
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
