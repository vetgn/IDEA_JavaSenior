package Thread_safe.Exer01;

/**
 * 银行有一个账户。有两个储户分别向同一个账户存3000元,每次存1000,存3次。<p>
 * 每次存完打印账户余额。<p>
 * 问题:该程序是否有安全问题,如果有,如何解决?<p>
 * <p>
 * 【提示】<p>1,明确哪些代码是多线程运行代码,须写入run()方法<p>
 * 2,明确什么是共享数据。<p>
 * 3,明确多线程运行代码中哪些语句是操作共享数据的。 <p>
 * <p>
 * 分析:<p>
 * 1.是否是多线程问题?  ---是,两个储户线程<p>
 * 2.是否有共享数据?      --- 有,账户(或账户余额)<p>
 * 3.是否有线程安全问题?   ---有<p>
 * 4.需要考虑如何解决线程安全问题?    ---  同步机制:有三种方式。 <p>
 *
 * @author ZJJ
 * #Description AccountTest
 * #Date: 2022/4/28 21:34
 */
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
//存钱
    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println( Thread.currentThread().getName()+"存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
