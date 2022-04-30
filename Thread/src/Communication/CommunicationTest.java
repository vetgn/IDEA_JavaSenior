package Communication;

/**
 * 线程通信的例子：使用两个线程打印 1-100。 线程1，线程2 交替打印<p>
 * 涉及到的三个方法：<p>
 * wait():一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 * </p>
 * notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就会唤醒优先级高的线程
 * </p>notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
 *
 * <p>说明：</p>
 * 1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中。<p>
 * 2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中同步监视器
 * ，否则，会出现IllegalMonitorStateException异常</p>
 * <p>3.wait(),notify(),notifyAll()三个方法时定义在java.lang.Object类中</p>
 * <p>
 * <p>
 * 面试题: sleep()和wait()的异同?
 * <p>1.相同点:一旦执行方法,都可以使得当前的线程进入阻塞状态。
 * <p>2.不同点:
 * <p>(1)两个方法声明的位置不同: Thread类中声明sleep() ,Object类中声明wait()
 * <p>(2)调用的要求不同: sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 * <p>(3)关于是否释放同步监视器:如果两个方法都使用在同步代码块或同步方法中, sleep()不会释放锁，wait()会释放锁
 *
 * @author ZJJ
 * #Description CommunicationTest
 * #Date: 2022/4/29 20:32
 */

class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (this) {//如果将this换成obj,并且下方的notify与wait方法前面的this.不换则会报错
                /*线程从这里进入，假设线程一先进入，那么锁也是一的，执行到wait()时，停止了并且释放同步监视器，然后线程二进入
                 * 经过notify()，唤醒线程一，但是由于锁此时变成了二的，线程一无法执行，于是线程二执行，然后重复以上步骤*/

                /*为什么 notify()、notifyAll 与 wait() 是Object类中的？ --- 因为：锁的类可以是任何对象，
                而这两三个方法的对象有必须要与他们同步，那么就是说任何对象都要可以调用这三个方法，就是在Object中*/

                /*this. */
                notify();

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
//                        使得调用如下wait()方法的线程进入阻塞状态
                        /*this. */
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
