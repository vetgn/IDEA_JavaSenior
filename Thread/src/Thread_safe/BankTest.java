package Thread_safe;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author ZJJ
 * #Description BankTest
 * #Date: 2022/4/21 16:38
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
//          方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
