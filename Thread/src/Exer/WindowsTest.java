package Exer;

/**
 * 例：三个窗口售卖票，一共100张,使用继承Thread的方法
 *
 * @author ZJJ
 * #Description Windows
 * #Date: 2022/4/17 20:14
 */
//使用的是继承，这就导致Windows无法再继承其他的
class Windows extends Thread {
    private static int ticket = 100;//公用一个ticket，但即使这样写，在运行的时候仍然会重复3个100

    @Override
    public void run() {

        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + "：卖票，票号为：" + ticket);
            } else {
                break;
            }

            ticket--;
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {
        Windows window1 = new Windows();
        Windows window2 = new Windows();
        Windows window3 = new Windows();

        window1.start();
        window2.start();
        window3.start();
    }
}
