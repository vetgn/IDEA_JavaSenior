package Thread_safe;

/**
 * 例：三个窗口售卖票，一共100张,使用接口Runnable的方法
 * <p>
 * 1.问题：卖票过程中，出现了重票、错票 --->出现了线程的安全问题<p>
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票<p>
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他
 * 线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。<p>
 * 4.在Java中，我们通过同步机制，来解决线程安全问题
 * <p>
 * 方式一：同步代码块
 * <p>
 * <hr><blockquote><pre>
 *
 *    synchronized(同步监视器){
 *
 *        //需要被同步的代码
 *
 *    }
 *
 * </pre></blockquote><hr>
 * <p>
 * 说明：
 * <p>1.操作共享数据的代码，即为需要被同步的代码
 * <p>2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 * <p>3.同步监视器：俗称：锁。任何一个类的对象，都可以充当锁
 * 要求：多个线程必须要共用同一把锁(比如上厕所，厕所有人时亮红灯，但是如果不是同一个锁，那么别人看来是红灯，自己看来
 * 是绿灯，那么就会出事)
 * <p>
 * <p>
 * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 * 方式二：同步方法
 * <p>如何操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的</p>
 * <P>5.同步的方式，解决了线程的安全问题。---好处
 * <P>操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程,效率低。 ---局限性
 *
 * @author ZJJ
 * #Description WindowsTest1
 * #Date: 2022/4/19 15:03
 */
class Windows1 implements Runnable {

    private int ticket = 100;
    //    你可以创建任何一个对象,甚至可以自己创建一个对象，如下文的Dog
//    Object obj = new Object();
    Dog dog = new Dog();

    @Override
    public void run() {
        synchronized (this) {//此时this在本程序中指的是唯一的windows1        方式二： //synchronized (dog) {
            while (true) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                } else {
                    break;
                }
                ticket--;
            }
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

class Dog {

}
