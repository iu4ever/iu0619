package ineo.exception;

import java.math.BigDecimal;

public class CheckingAccount {

    //卡号
    private long number;
    //账户余额
    private BigDecimal amount;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CheckingAccount(long number) {
        this.number = number;
    }

    public void deposit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {

        if (this.amount.compareTo(amount) > 0) {
            this.amount = this.amount.subtract(amount);
        } else {
            throw new InsufficientFundsException(amount.subtract(this.amount));
        }

    }

    //获取卡号
    public long getNumber() {
        return number;
    }

    //获取余额
    public BigDecimal getAmount() {
        return amount;
    }
}
