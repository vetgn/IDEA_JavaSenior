package LayoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description BoxLayoutTest
 * #Date: 2022/6/20 20:38
 */

/*为了简化开发,Swing 引入了一个新的布局管理器: BoxLayout。BoxLayout 可以在垂直和水平两个方向上摆放GUI组件 Boxlavout 提供了如下一个简单的构造器:*/

    /*BoxLayout(Container target, int axis)  指定创建基于target容器的BoxLayout布局管理器,该布局管理器里的组件按axis方向排列。
    其中 axis有BoxLayout.X_AXIS(横向)和BoxLayout.Y_AXIS (纵向)两个方向。*/
public class BoxLayoutTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("这里测试BoxLayout");
//1. 基于frame容器,创建一个BoxLayout对象,并且,该对象存放组件是垂直存放
        BoxLayout boxLayout = new BoxLayout(jFrame, BoxLayout.Y_AXIS);

// 2. 把BoxLayout对象设置给Frame
        jFrame.setLayout(boxLayout);

// 3.往frame中添加两个按钮组件
        JButton jButton1 = new JButton("按钮1");
        JButton jButton2 = new JButton("按钮2");

        jFrame.add(jButton1);
        jFrame.add(jButton2);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
