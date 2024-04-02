package WorkPOO.Exercise3.Classes;

import javax.swing.*;

public class BankAccount {
    private String holder;
    private double balance;

    public BankAccount(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositMoney(double deposit) {
        this.balance += deposit;
    }

    public void withdrawMoney(double withdrawalValue) {
        if (withdrawalValue > this.balance) {
            JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para realizar este retiro");
        } else {
            this.balance -= withdrawalValue;
        }
    }

    public void showBalanceInScreen() {
        JOptionPane.showMessageDialog(null, "Balance de la cuenta: " + this.balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
