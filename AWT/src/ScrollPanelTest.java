import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description ScrollPanelTest
 * #Date: 2022/5/26 16:55
 */
public class ScrollPanelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("演示ScrollPane");

        //1.创建一个ScrollPane对象
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //2，往ScrollPane中添加内容
        scrollPane.add(new TextField("这是测试文本"));
        scrollPane.add(new JButton("这是测试按钮"));

        //3.把ScrollPane添加到Frame中
        frame.add(scrollPane);

        frame.setBounds(500, 500, 600, 460);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*但是此窗口知显示了一个按钮组件，并没有显示文本组件，这是因为ScrollPane使用BorderLayout布局管理器的缘故*/
    }
}
