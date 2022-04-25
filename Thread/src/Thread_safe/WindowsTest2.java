package Thread_safe;

/**
 * 例：三个窗口售卖票，一共100张,使用继承Thread的方法
 *<p>
 *     说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类
 *     充当同步监视器。
 *</p>
 * @author ZJJ
 * #Description WindowsTest2
 * #Date: 2022/4/21 15:23
 */

class Windows2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();//下方new了3个对象，因此obj要加上static

    @Override
    public void run() {
        synchronized (Windows2.class) {           //方式二    //synchronized (obj) {
            while (true) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                } else {
                    break;
                }

                ticket--;
            }
        }

    }
}

public class WindowsTest2 {
    public static void main(String[] args) {
        Windows2 window1 = new Windows2();
        Windows2 window2 = new Windows2();
        Windows2 window3 = new Windows2();

        window1.start();
        window2.start();
        window3.start();
    }
}

