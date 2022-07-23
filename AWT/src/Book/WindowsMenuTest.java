package Book;

import javax.swing.*;

/**
 * 窗口菜单
 * <p>
 * 1.JMenuBar类：
 * <p>
 * 是JComponent的子类，用于创建一个菜单栏，一个窗口只能有一个菜单栏，并且只能添加到窗口的顶端
 * <p>
 * 常用方法：
 * JMenuBar()：创建一个新的菜单栏。
 * JMenu add(JMenu c)：将菜单添加到菜单栏的末尾。
 * JMenu getMenu(int index)：获取菜单栏中指定位置的菜单。
 * int getMenuCount()：获取菜单栏的菜单数。
 * setMenuBar(JMenuBar menubar)：向窗口添加JMenuBar方法。
 * <p>
 * 2.JMenu类
 * <p>
 * 用于创建菜单，一个菜单栏中可以添加多个菜单对象，并且菜单可以嵌套从而构成子菜单。
 * <p>
 * 常用方法：
 * JMenu()：创建一个新的菜单栏。
 * JMenu(String s)：创建一个菜单标签为s的菜单栏。
 * JMenuItem add(JMenuItem item)：将菜单项添加到菜单的末尾。
 * JMenuItem insert(JMenuItem item,int pos)：在给定位置插入新菜单项。
 * void addSeparator()：将分隔符添加到菜单的末尾。
 * JMenuItem getItem(int index)：获取菜单中指定位置的菜单项。
 * int getItemCount()：获取菜单中的项数。
 * void remove(JMenuItem)：从菜单中移除指定菜单项。
 * <p>
 * 3.JMenuItem类：
 * <p>
 * 用于创建菜单项，每一个菜单中可以包括多个菜单项
 * <p>
 * 常用方法：
 * JMenuItem(String s)：创建一个指定名称的新菜单项。
 * JMenuItem(String s,Icon icon)：创建一个指定名称和图标的新菜单项。
 * void setEnable(boolean b)：启用或禁用菜单项。
 *
 * @author ZJJ
 * #Description WindowsMenuTest
 * #Date: 2022/5/26 19:08
 */
public class WindowsMenuTest extends JFrame {
    JMenuBar menubar;
    JMenu menu1, menu2, menu3, menu4, submenu11, submenu12;
    JMenuItem menuItemOpen, menuItemFlush, menuItemPackage, menuItemClass,
            menuItemClose, menuItemSave, menuItemCut, menuItemPaste, menuItemAbout;

    public void init(String s){
        setTitle(s);
        menubar = new JMenuBar();//创建一个菜单栏

        menu1 = new JMenu("文件");
        menu2 = new JMenu("编辑");
        menu3 = new JMenu("搜索");
        menu4 = new JMenu("帮助");

        submenu11 = new JMenu("新建");//创建一个"新建"子菜单
        //下面是创建菜单栏
        menuItemPackage = new JMenu("包");//创建一个"包"菜单项+++++++++++++++++
    }
}
