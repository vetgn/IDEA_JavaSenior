package Communication.Exer;

/**
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品,
 * 店员一次只能持有固定数量的产品(比如:20),如果生产者试图生产更多的产品,店员会叫生产者停一下,
 * 如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品了,店员会告诉消费者等一下,
 * 如果店中有产品了再通知消费者来取走产品。<p><p>
 * 这里可能出现两个问题:<p>>生产者比消费者快时,消费者会漏掉一些数据没有取到。<p>
 * >消费者比生产者快时,消费者会取相同的数据<p>
 *
 * </p>
 * 分析:<p>
 * 1.是否是多线程问题?是,生产者线程,消费者线程<p>
 * 2.是否有共享数据?是,店员(或产品)<p>
 * 3.如何解决线程的安全问题?同步机制,有三种方法<p>
 * 4.是否涉及线程的通信?是
 *
 * @author ZJJ
 * #Description ProductTest
 * #Date: 2022/4/30 19:45
 */
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":生产者开始生产");

        while (true) {
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread {//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品");

        while (true) {
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者一");
        c1.setName("顾客一");

        p1.start();
        c1.start();
    }
}
