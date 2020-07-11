package ineo.exception;

import java.math.BigDecimal;

public class BankDemo {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(101);
        checkingAccount.setAmount(BigDecimal.valueOf(0));
        checkingAccount.deposit(BigDecimal.valueOf(500));
        System.out.println(checkingAccount.getAmount());
        try {
            checkingAccount.withdraw(BigDecimal.valueOf(600));
        } catch (InsufficientFundsException e) {

            System.out.println("余额不足，账户中缺少的资金为：" + e.getAmount());
            e.printStackTrace();
        }

    }
}
