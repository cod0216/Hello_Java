package thread.sync;

import util.MyLogger;
import util.ThreadUtils;

public class BankAccountV2 implements BankAccount{
    private int balance;

    public BankAccountV2(int initBalance) {
        this.balance = initBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        MyLogger.log("거래 시작 : " + getClass().getSimpleName());

        // 잔고가 출금액보다 적으면, 진행 안됨
        MyLogger.log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
        if(balance < amount) {
            MyLogger.log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
            return false;
        }

        // 잔고가 출금액 보다 많으면, 진행
        MyLogger.log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        ThreadUtils.sleep(1000); // 출금에 걸리는 시간으로 가정
        balance = balance - amount;
        MyLogger.log("[출금 완료] 출금액 : " + amount + ", 변경 잔액 : " + balance);

        MyLogger.log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
