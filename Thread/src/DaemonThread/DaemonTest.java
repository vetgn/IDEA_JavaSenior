package DaemonThread;

/**
 * 守护线程：
 * <p>
 * 什么是守护线程？
 * </p>
 * 1.线程总体分为用户线程（User Thread） 和 （Daemon Thread）。守护线程的作用是为用户线程提供服务的。
 * <p>当所有用户线程执行完成时，JVM自动关闭。但是守护线程却独立于JVM，守护线程一般是由操作系统或者用户自己创建</p>
 * 2.线程默认为非守护线程，即用户线程。如果用户线程全部退出，没有了守护线程，守护线程就没有服务的对象，就会退出。
 * <p>
 * <p>
 * 用setDaemon(true)可以设置一个守护线程，应注意一下几点：
 * <p>1.thread.setDaemon(true)必须在thread.start()之前设置，否则会抛出IllegalThreadStateException。</p>
 * 2.在守护线程中产生的新线程也是守护线程。
 * </p>3.并非所有的应用都可以分配给守护线程来进行服务，如读写操作或大量复杂耗时的计算。因为在守护线程还没来及进行操作
 * 时，虚拟机可能已经退出了。这是可能还有大量数据尚未来得及读入或写出，多次计算的结果也可能不一样。这对程序是会毁灭性的。
 *
 * @author ZJJ
 * #Description DaemonTest
 * #Date: 2022/5/1 17:19
 */
class Bank extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(getName() + ":" + i);
                }
            }
        }
    }
}

public class DaemonTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.setName("守护线程");
        bank.setDaemon(true);
        bank.start();

        Thread.currentThread().setName("非守护线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}
