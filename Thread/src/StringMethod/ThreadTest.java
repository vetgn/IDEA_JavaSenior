package StringMethod;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run() ---> 将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 例子：遍历100以内的所有的偶数
 *
 * @author 朱军军
 * #Description ThreadTest
 * #Date: 2022/4/13 13:30
 */

//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();

        //4.通过此对象调用start()：①启动当前线程 ②调用当前线程的run()
        myThread.start();
        //问题一： 我们不能通过直接调用run()的方式启动线程,如果调用那么输出的永远都相同，因为是单线程
        //myThread.run();

        //问题二：再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行，会报错IllegalThreadStateException()
        //myThread.start();
        //我们需要重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i + "************************");//每次输出的结果是不同的，看自己cpu的运行速度，表明这就是多线程
            }
        }

    }
}
