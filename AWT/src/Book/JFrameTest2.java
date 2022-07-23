package Book;

import javax.swing.*;

/**
 *
 * 通过继承实现窗口
 * @author ZJJ
 * #Description JFrameTest2
 * #Date: 2022/5/26 19:01
 */
public class JFrameTest2 {
    public static void main(String[] args) {
        new MyFrame("Java测试窗口",200,200,300,200);
    }
}
class MyFrame extends JFrame {
    public MyFrame(String title,int x,int y,int width,int height){
        super(title);
        setBounds(x,y,width,height);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
