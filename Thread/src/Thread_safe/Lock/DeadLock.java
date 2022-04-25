package Thread_safe.Lock;

/**
 * 演示线程的死锁问题<p>
 * <p>
 * 死锁；<p>
 * 不同的线程分别占用对方需要的同步资源不放弃,都在等待对方放弃自己需要的同步资源,就形成了线程的死锁出现死锁后,<p>
 * 不会出现异常,不会出现提示,只是所有的线程都处于阻塞状态,无法继续。<p>
 *
 * @author ZJJ
 * #Description DeadLock
 * #Date: 2022/4/21 20:07
 */
class A {
    public synchronized void foo(B b) {//A类对象：a
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了A实例的foo方法");//①
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了B实例的last方法");//③
        b.last();
    }

    public synchronized void last() {//同步监视器：A类对象：a
        System.out.println("进入了A类的last方法内部");
    }
}

class B {
    public synchronized void bar(A a) {//B类对象：b
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了B实例的bar方法");//②

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
    }

    public synchronized void last() {//同步监视器：b
        System.out.println("进入了B类的last方法内部");
    }
}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入主线程以后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        //调用b对象的bar方法
        b.bar(a);
        System.out.println("进入了副线程以后");
    }

    public static void main(String[] args) {
        //副线程
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        //主线程
        /*
          init赋名后，进行a.foo(b),此时锁是A类对象，而结束则要运行b.last(),那么就要遇到锁B类对象
              而此时的副线程进行run(),赋名以后，进行b.bar(a),此时锁是B类对象,
              而结束则要运行a.last(),那么就要遇到锁A类对象，可以发现主线程的顺序是AB，而副线程的顺序是BA，
              二者的锁不相同。并且想要相互运行对方的last()方法，导致线程无法结束，所有的线程都处于阻塞状态,无法继续。

         */
        dl.init();
        /*相当于二者所经历的锁是不同的，那么两个线程就各自运行自己的，并且毫不相让，导致出现死锁*/
    }
}
