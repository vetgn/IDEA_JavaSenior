package LayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ZJJ
 * #Description CardLayoutTest
 * #Date: 2022/6/20 19:49
 */

/*CardLayout布局管理器以时间而非空间来管理它里面的组件,它将加入容器的所有组件看成一叠卡片[(每个卡片其实就是一个组件),
每次只有最上面的那个Component才可见。就好像一副扑克牌,它们叠在一起,每次只有最上面的一张扑克牌才可见.*/

    /*CardLayout()  创建默认的CardLayout布局管理器。
    CardLayout(int hgap,int vgap)  通过指定卡片与容器左右边界的间距Chgap)、上下边界Cvgap)的间距来创建CardLayout布局管理器.
    first(Container target)  显示target容器中的第一张卡片.
    last(Container target)  显示target容器中的最后一张卡片.
    previous(Container target)  显示target容器中的前一张卡片.
    next(Container target)  显示target容器中的后一张卡片.
    show(Container taget,String name)   显示target容器中指定名字的卡片.*/

public class CardLayoutTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("测试CardLayout");

        //1.创建一个Panel,用来存储多张卡片
        Panel panel = new Panel();
        // 2.创建CardLayout对象,并且把该对象设置给之前创建的容器
        CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        // 3. 往panel中存储多个组件
        String[] name = {"第一张", "第二张", "第三张", "第四张", "第五张"};

        for (int i = 0; i < name.length; i++) {
            panel.add(name[i], new JButton(name[i]));
        }
        // 4. 把panel放到frame的中间区域
        jFrame.add(panel);
        // 5.创建另外一个panel p2,用来存储多个按钮组件
        Panel panel1 = new Panel();
        // 6.创建5个按钮组件
        JButton button1 = new JButton("上一张");
        JButton button2 = new JButton("下一张");
        JButton button3 = new JButton("第一张");
        JButton button4 = new JButton("最后一张");
        JButton button5 = new JButton("第三张");
        // 7.创建一个事件监听器,监听按钮的点击动作
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "上一张":
                        cardLayout.previous(panel);
                        break;
                    case "下一张":
                        cardLayout.next(panel);
                        break;
                    case "第一张":
                        cardLayout.first(panel);
                        break;
                    case "最后一张":
                        cardLayout.last(panel);
                        break;
                    case "第三张":
                        cardLayout.show(panel, "第三张");
                        break;
                }
            }
        };
        // 8.把当前这个时间监听和多个按钮绑定到一起
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        // 9.把按钮添加到容器p2中
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        // 10. 把p2放到frame的南边区域
        jFrame.add(panel1, BorderLayout.SOUTH);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
