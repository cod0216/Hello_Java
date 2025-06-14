package oop1.ex;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println("잔고 : " + account.balance);
        account.deposit(10000);
        System.out.println("잔고 : " + account.balance);
        account.withdraw(1000);
        System.out.println("잔고 : " + account.balance);
        account.withdraw(10000);
        System.out.println("잔고 : " + account.balance);
    }
}
