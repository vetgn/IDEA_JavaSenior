package Thread_safe.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK 5.0新增
 *
 * （注意：在使用lock.lock()时，要注意方法是否会创建多个对象，导致创建多个锁，因此注意加上静态）
 *
 * 1.面试题: synchronized 与Lock的异同?<p>
 * 相同:二者都可以解决线程安全问题<p>
 * 不同: synchronized机制在执行完相应的同步代码以后,自动的释放同步监视器<p>
 * Lock需要手动的启动同步(Lock()),同时结束同步也需要手动的实现(unlock()) <p>
 *
 * 2.优先使用顺序：
 * Lock -> 同步代码块 （已经进入了方法体，分配了相应资源） -> 同步方法（在方法体之外 ）
 * @author ZJJ
 * #Description LockTest
 * #Date: 2022/4/25 20:23
 */
class Window implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
            //2.调用锁定方法lock()
                lock.lock();
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
            } finally {
//                3.调用解锁方法：unlock()
                lock.unlock();
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
