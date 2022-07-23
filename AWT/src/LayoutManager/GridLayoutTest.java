package LayoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description GridLayoutTest
 * #Date: 2022/6/20 14:11
 */

/*GridLayout布局管理器将容器分割成纵横线分隔的网格,每个网格所占的区域大小相同。
当向使用GridLayout 布局管理器的容器中添加组件时,默认从左向右、从上向下依次添加到每个网格中。
与FlowLayout不同的是,放置在GridLayout布局管理器中的各组件的大小由组件所处的区域决定(每个组件将自动占满整个区域)。*/

/*
 * GridLayout(int rows,int cols) :采用指定的行数、列数,以及默认的横向间距、纵向间距将容器分割成多个网格
 * GridLayout(int rows,int cols,int hgqp,int vgap) :采用指定的行数、列数,以及指定的横向间距、纵向间距将容器分割成多个网格。
 * */

public class GridLayoutTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("计算器");

        //1.创建Panel对象，里面存放TextFiled组件
        Panel panel = new Panel();
        panel.add(new TextField(30));
        //2.把当前这个Panel添加到frame的北边区域
        jFrame.add(panel,BorderLayout.NORTH);
        //3.创建一个Panel对象，并且设置它的布局管理器为GridLayout
        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(3,5,4,4));
        //4.在Panel中添加内容
            for(int i=0;i<10;i++){
                panel1.add(new JButton(String.valueOf(i)));
            }
            panel1.add(new JButton("+"));
            panel1.add(new JButton("-"));
            panel1.add(new JButton("*"));
            panel1.add(new JButton("/"));
//            panel1.add(new JButton("."));
        //5.把当前Panel添加到frame中
        jFrame.add(panel1);

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
