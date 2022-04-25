package Thread_safe;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author ZJJ
 * #Description WindowsTest3
 * #Date: 2022/4/21 15:51
 */
class Windows3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        show();
    }

    public synchronized void show() {//同步监视器：this

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

public class WindowsTest3 {
    public static void main(String[] args) {
        Windows3 windows3 = new Windows3();

        Thread t1 = new Thread(windows3);
        t1.setName("窗口一");
        t1.start();

        Thread t2 = new Thread(windows3);
        t2.setName("窗口二");
        t2.start();

        Thread t3 = new Thread(windows3);
        t3.setName("窗口三");
        t3.start();
    }
}