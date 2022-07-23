package Book;

import javax.swing.*;

/**
 * @author ZJJ
 * #Description JFrameTest
 * #Date: 2022/5/26 17:38
 */

/*
 * JFrame的常用方法：
 *
 * JFrame()：构造一个初始不可见的窗口。
 * JFrame(String title)：创建一个初始不可见的、指定标题的窗口。
 * void setTitle(String title)：设置窗口标题栏的内容。
 * void setSize(int width,int height)：设置窗口的大小。
 * void setRisizable(boolean r)：设置是否可以改变窗口的大小。
 * void setLocation(int x,int y)：设置窗口的位置。
 * void setVisible(booleab v)：设置窗口是否可见，默认不可见。
 * void setLocationRelativeTo(null)：设置窗口居中显示。
 * Container Container getContentpane()：获取内容面板。
 * void setDefaultCloseOperation(int o)：设置在此窗口上发起"close"时默认执行的操作。
 *
 * */
public class JFrameTest1 {
    /*创建新窗口，大小300*200，位置200*200，并且大小不可调*/
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Java测试窗口");
        jFrame.setSize(300, 200);
        jFrame.setLocation(200, 200);
        jFrame.setResizable(false);//设置无法改变大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
