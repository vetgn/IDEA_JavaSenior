8.6 JDK5.0新增线程创建方式

线程池相关API

• JDK 5.0起提供了线程池相关API: ExecutorService和Executors ExecutorService:真正的线程池接口。常见子类ThreadPoolExecutor
> void execute(Runnable command):执行任务/命令,没有返回值,一般用来执行Runnable

> Future<T> submit(Callable task):执行任务,有返回值,一般又来执行Callable

> void shutdown() :关闭连接池

> Executors:工具类、线程池的工厂类,用于创建并返回不同类型的线程池

> Executors.newCachedThreadPool():创建一个可根据需要创建新线程的线程池

> Executors.newFixedThreadPool(n);创建一个可重用固定线程数的线程池

> Executors.newSingleThreadExecutor():创建一个只有一个线程的线程池

> Executors.newScheduledThreadPool(n):创建一个线程池,它可安排在给定延迟后运行命令或者定期地执行。