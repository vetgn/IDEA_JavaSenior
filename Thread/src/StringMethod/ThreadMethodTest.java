package StringMethod;

/**
 * 测试Thread中的常用方法
 * <p>1.start():启动当前方法；调用当前线程的run()
 * <p>2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * <p>3.currentThread()：静态方法，返回执行当前代码的线程
 * <p>4.getName()：获取当前线程的名字
 * <p>5.setName()：设置当前线程的名字
 * <p>6.yield()：释放当前cpu的执行权
 * <p>7.join()：在线程a中调用线程b的join()，此时线程a就会进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态,类似于插队
 * <p>8.stop():已过时。当执行此方法时，强制结束当前线程
 * <p>9.sleep(Long milli time):让当前线程“睡眠”指定的milli time毫秒。在指定的milli time毫秒时间里，当前线程是阻塞状态。
 * <p>10.isAlive()：判断当前线程是否存活
 * <p>
 * <p>
 * 线程的优先级
 * <p>
 * 1、
 * MAX_PRIORITY: 10
 * MIN_PRIORITY: 1
 * MORM_PRIORITY: 5--->默认优先级
 * <p>
 * 2.如何获取和设置当前线程的优先级
 * getPriority():获取线程的优先级
 * setPriority(int p):设置线程的优先级
 * <p>
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程在高概率的情况下
 * 被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 *
 * @author 朱军军
 * #Description ThreadMethodTest
 * #Date: 2022/4/13 15:45
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("线程一");//在输出名字之前命名
        //设置分线程的优先级
        myThread1.setPriority(Thread.MAX_PRIORITY);

        myThread1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//          主线程到20时停止，执行另一个线程
//            if (i == 20) {
//                try {
//                    myThread1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(myThread1.isAlive());//因为上面有join()，所以先执行myThread1,所以现在他已经执行完了(死了)
    }
}

class MyThread1 extends Thread {
   /* Thread中有进行改名称的方法
   public  MyThread1(String name){
        super(name);
    }*/

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {


                //sleep()
//                try {
//                    sleep(10);//每隔1秒进行一次
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }


//            if (i % 20 == 0) {
//                yield();
//            }
        }
    }
}
