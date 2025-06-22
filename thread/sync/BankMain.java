package thread.sync;

import util.MyLogger;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV1(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "Bank1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "Bank2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        MyLogger.log("최종 잔액 : " + account.getBalance());
    }
}
