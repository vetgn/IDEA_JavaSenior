package Exer;

/**
 * 例：三个窗口售卖票，一共100张,使用接口Runnable的方法
 *
 * @author ZJJ
 * #Description WindowsTest1
 * #Date: 2022/4/19 15:03
 */
class Windows1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
            } else {
                break;
            }
            ticket--;
        }
    }
}

public class WindowsTest1 {
    public static void main(String[] args) {
        //共用一个windows1那么，使用的ticket也是同一种票，与之前的方法相比甚至不用使用static
        Windows1 windows1 = new Windows1();

        Thread t1 = new Thread(windows1);
        t1.setName("窗口一");
        t1.start();

        Thread t2 = new Thread(windows1);
        t2.setName("窗口二");
        t2.start();

        Thread t3 = new Thread(windows1);
        t3.setName("窗口三");
        t3.start();
    }
}
