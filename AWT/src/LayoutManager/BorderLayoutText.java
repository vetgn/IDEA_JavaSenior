package LayoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description BorderLayoutText
 * #Date: 2022/6/20 11:35
 */

/*BorderLayout 将容器分为 EAST,SOUTH、WEST, NORTH、CENTER五个区域,普通组件可以被放置在这5个区域的任意一个中。BorderLayout布局 管理器的布局示意图如图所示(上、下、左、右、中)。*/
    /*当改变使用BorderLayout 的容器大小时, NORTH、SOUTH 和 CENTER区域水平调整,而EAST、WEST和CENTER 区域垂直调整。使用BorderLayout有如下两个注意点:
    1. 当向使用BorderLayout布局管理器的容器中添加组件时,需要指定要添加到哪个区域中。如果没有指定添加到哪个区域中,则默认添加到中间区域中;
    2.如果向同一个区域中添加多个组件时,后放入的组件会覆盖先放入的组件;*/
    /*
    * BorderLayout() :使用默认的水平间距、垂直间距创建BorderLayout布局管理器。
    * BorderLayout(int hgap,int vgap) :使用指定的水平间距、垂直间距创建BorderLayout布局管理器。
    * */
public class BorderLayoutText {
    public static void main(String[] args) {
        //1.创建新的窗口
        JFrame jFrame = new JFrame("BorderLayout测试");

        //2.通过setLayout方法设置容器的布局管理器
        jFrame.setLayout(new BorderLayout(30,10));

        //3.往jFrame中添加
        jFrame.add(new JButton("北侧按钮"),BorderLayout.NORTH);
        jFrame.add(new JButton("南侧按钮"),BorderLayout.SOUTH);
//        jFrame.add(new JButton("西侧按钮"),BorderLayout.WEST);
//        jFrame.add(new JButton("东侧按钮"),BorderLayout.EAST);

        /*这会导致中间按钮组件被测试文本替代*/
//        jFrame.add(new JButton("中间按钮"),BorderLayout.CENTER);
//        jFrame.add(new TextField("测试文本"));

        /*将这些组件放入panel中*/
        Panel panel = new Panel();
        panel.add(new JButton("中间按钮"),BorderLayout.CENTER);
        panel.add(new TextField("测试文本"));
        jFrame.add(panel);

        jFrame.setVisible(true);
        jFrame.setBounds(500,400,1000,900);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
