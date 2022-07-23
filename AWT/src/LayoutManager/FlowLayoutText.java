package LayoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description FlowLayout
 * #Date: 2022/6/19 09:29
 */


/*在FlowLayout布局管理器中,组件像水流一样向某方向流动(排列),遇到障碍(边界)就折回,重头开始排列在默认情况下, FlowLayout布局管理器从左向右排列所有组件,遇到边界就会折回下一行重新开始。*/
/*
 * FlowLayout() :使用默认的对齐方式及默认的垂直间距、水平间距创建FlowLayout布局管理器。
 * FlowLayout(int align) :使用指定的对齐方式及默认的垂直间距、水平间距创建FlowLayout布局管理器。
 * FlowLayout(int align,int hgap,int vgap) :使用指定的对齐方式及指定的垂直问距、水平间距创建FlowLayout布局管理器。
 * */

    /*FlowLayout中组件的排列方向(从左向右、从右向左、从中间向两边等),
    该参数应该使用FlowLayout类的静态常量:FlowLayout.LEFT、FlowLayout.CENTER、FlowLayout.RIGHT ,默认是左对齐。
    FlowLayout 中组件中间距通过整数设置,单位是像素,默认是5个像素。*/
public class FlowLayoutText {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("测试FlowLayout");

        //1.通过setLayout方法设置容器的布局管理器

        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        //2.添加多个按钮到jFrame中
        for(int i=0;i<=100;i++){
            jFrame.add(new JButton("按钮" + i));
        }

        //设置最佳大小，pack()方法
        jFrame.setBounds(500,400,1000,900);
//        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
