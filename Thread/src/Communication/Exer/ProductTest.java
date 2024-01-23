package Communication.Exer;

public class ProductTest {
    public static void main(String[] args) {
        Bun bun = new Bun();
        Producer producer = new Producer(bun);
        Consumer consumer = new Consumer(bun);
        Thread thread1 = new Thread(producer, "生产者");
        Thread thread2 = new Thread(consumer, "消费者");
        thread1.start();
        thread2.start();
    }
}

class Bun {
    private int num = 0;

    public synchronized void AddBun() {
        if (num >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "第" + num + "个商品");
        notify();
    }

    public synchronized void MinusBun() {
        if (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "剩" + num + "个商品");
        num--;
        notify();
    }
}

class Producer implements Runnable {
    private Bun bun;

    public Producer(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bun.AddBun();
            System.out.println("生产者生产产品");
        }
    }
}

class Consumer implements Runnable {
    private Bun bun;

    public Consumer(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bun.MinusBun();
            System.out.println("消费者消费");
        }
    }
}