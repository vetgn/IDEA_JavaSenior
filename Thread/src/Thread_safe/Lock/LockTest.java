package Thread_safe.Lock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK 5.0新增
 *
 * @author ZJJ
 * #Description LockTest
 * #Date: 2022/4/25 20:23
 */
class Window implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
    }
}
