package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池(注意: 这只是简单的了解)
 * <p>
 * <p>
 * 好处:<p>
 * <p>1.提高响应速度(减少了创建新线程的时间)
 * <p>2.降低资源消耗(重复利用线程池中线程,不需要每次都创建)
 * <p>3.便于线程管理
 * <p>corePoolSize:核心池的大小
 * <p>maximumPoolSize:最大线程数
 * <p>keepAliveTime:线程没有任务时最多保持多长时间后会终止
 *
 *
 * <p>面试题：创建线程有几种方式？ --- 四种！
 *
 * @author ZJJ
 * #Description ThreadPool
 * #Date: 2022/5/1 10:40
 */
class NumberThread implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
//        提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合用于Runnable
        service.execute(new NumberThread1());//适合用于Runnable

//        service.submit(Callable callable);//适合用于Callable
//        3.关闭连接池
        service.shutdown();
    }
}
