package bank;

import java.text.DecimalFormat;

/**
 * beginning of class implements from IAccount.
 */
public class CheckingAccount implements IAccount {
  private double starterAmount;

  /**
   * constructor.
   * @param starterAmount money to create the account.
   */
  public CheckingAccount(double starterAmount) {
    if (starterAmount < 0.01 || starterAmount < 0) {
      throw new IllegalArgumentException("Amount cannot be less than $0,01 OR negative!");
    }

    this.starterAmount = starterAmount;

  }

  /**
   * deposit money.
   * @param value more money.
   */
  @Override
  public void deposit(double value) {
    if (value < 0) {
      throw new IllegalArgumentException("Amount cannot be negative!");
    }
    this.starterAmount += value;

  }

  /**
   * take money out of account.
   * @param withdraw withdraw
   * @return true of false
   */
  @Override
  public boolean withdraw(double withdraw) {
    if (withdraw > this.starterAmount) {
      return false;
    }
    else {
      this.starterAmount -= withdraw;
      return true;
    }
  }

  /**
   * get balance.
   * @return balance
   */
  @Override
  public double getBalance() {
    return this.starterAmount;
  }

  /**
   * Perform Maintenance.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (getBalance() < 100) {
      this.starterAmount -= 5;
    }
  }

  /**
   * print how much money in account for two decimal places.
   * @return string
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("$0.00");
    return df.format(getBalance());
  }
}
