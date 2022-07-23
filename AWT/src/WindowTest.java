import java.awt.*;

/**
 * @author ZJJ
 * #Description WindowTest
 * #Date: 2022/5/26 16:13
 */
public class WindowTest {
    public static void main(String[] args) {
        //1.创建一个窗口对象
        Frame frame = new Frame("测试一");
        //2.指定窗口的位置、大小
        frame.setLocation(600, 600);
        frame.setSize(800,520);
        //3.设置窗口可见
        frame.setVisible(true);
    }
}
