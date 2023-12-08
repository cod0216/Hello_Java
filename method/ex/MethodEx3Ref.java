package method.ex;

public class MethodEx3Ref {
    public static void main(String[] args) {
        int balance = 10000;

        //입금 1000
        int depositAmount = 1000;
        balance = deposit(balance, depositAmount);

        int withdrawAmount = 2000;
        balance = withdraw(balance, withdrawAmount);
    }


    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하셨습니다. 현재 잔액 : " + balance + "입니다.");
        return balance;
    }

    public static int withdraw(int balance, int withdrawAmount) {

        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + "원을 송금하셨습니다.. 현재 잔액: " + balance + "원");
            return balance;
        }

        else {
            System.out.println(withdrawAmount + "원을 송금하려 했으나 잔액이 부족합니다.");
            return balance;
        }

    }
}
