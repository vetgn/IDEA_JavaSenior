import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description PanelTest
 * #Date: 2022/5/26 16:28
 */
public class PanelTest {
    public static void main(String[] args) {
        //1.创建一个window对象，因为，panel以及其他的容器，都不能独立存在，必须依附在window存在
        Frame frame = new Frame("Panel测试");
        //2.创建一个Panel对象
        Panel panel = new Panel();
        //3.创建一个文本框和一个按钮，并且把它们放入到Panel容器中
        panel.add(new TextField("这是一个测试文本"));
        panel.add(new JButton("这是一个测试按钮"));//JButton是没有局限性的
        //4.把panel放入到window中
        frame.add(panel);
        //5.设置window的位置以及大小
        frame.setBounds(500, 500, 600, 460);
        //6.设置window可见
        frame.setVisible(true);
    }
}
