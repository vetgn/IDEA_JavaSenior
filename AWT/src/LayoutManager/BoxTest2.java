package LayoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZJJ
 * #Description BoxTest2
 * #Date: 2022/6/20 21:08
 */

 /*通过之前的两个BoxLayout演示,我们会发现,被它管理的容器中的组件之间是没有间隔的,不是特别的美观,但之前学习的几种布局,
        组件之间都会有一些间距,那使用BoxLayout如何给组件设置间距呢?其实很简单,我们只需要在原有的组件需要间隔的地方,添加间隔即可,
        而每个间隔可以是一个组件,只不过该组件没有内容,仅仅起到一种分隔的作用。*/

/*static Component createHarizontalGlue()  创建一条水平Glue (可在两个方向上同时拉伸的间距)
static Component createVerticalGlue()  创建一条垂直Glue (可在两个方向上同时拉伸的间距)
static Component createHorizontalStrut(int width) 创建一条指定宽度(宽度固定了,不能拉伸)的水平Strut(可在垂直方向上拉伸的间距)
static Component createVerticalStrut(int height)创建一条指定高度(高度固定了,不能拉伸)的垂直Strut (可在水平方向上拉伸的间距)*/

public class BoxTest2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Box2测试");

        //1.创建水平排列的Box容器hBox
        Box hBox = Box.createHorizontalBox();
        //2. 往hBox容器中添加按钮,还需要在多个按钮之间添加分割
        hBox.add(new Button("水平按钮-"));
        hBox.add(Box.createHorizontalGlue());//该分割在两个方向上都可以拉伸
        hBox.add(new Button("水平按钮二"));
        hBox.add(Box.createHorizontalStrut(30));
        hBox.add(new Button("水平按钮="));

        //3.创建垂直排列的Box容器vBox
        Box vBox = Box.createVerticalBox();
        //4. 往vBox容器中添加按钮,还需要在多个按钮之间添加分割
        vBox.add(new Button("垂直按钮-"));
        vBox.add(Box.createVerticalGlue());//该分割在两个方向上都可以拉伸
        vBox.add(new Button("垂直按钮"));
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(new Button("垂直按钮="));
        //5. 把box容器添加到frame中

        jFrame.add(hBox, BorderLayout.NORTH);
        jFrame.add(vBox);

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
