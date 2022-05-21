import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * <p>
 * 3.处理流，就是“套接”在已有的流的基础上
 *
 * @author ZJJ
 * #Description BufferedTest
 * #Date: 2022/5/21 17:44
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {
            //1.造文件
            File scrFile = new File("one.png");
            File destFile = new File("Three.png");
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);

//                bos.flush();//刷新缓存区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPah) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {
            //1.造文件
            File scrFile = new File(srcPath);
            File destFile = new File(destPah);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath\\1.mp4";
        String destPath = "D:\\JavaCode\\IDEA_JavaSenoir\\FileTestPath\\3.mp4";
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();

        System.out.println("操作消耗的时间" + (end - start));//171
    }
    /*使用BufferedReader和BufferedWriter实现文本文件的复制*/

    @Test
    public void testBufferedReaderBufferedWriter(){
        //创建文件和相应的流
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            //读写操作
            //方式一：
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }
            //方式二：
            String data;
            while ((data = br.readLine()) != null){
                //方法一：
//                bw.write(data  + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包行换行符
                bw.newLine();//提供换行的操做
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(br !=null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw !=null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
