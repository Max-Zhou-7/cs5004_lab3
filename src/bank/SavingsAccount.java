package bank;

import java.text.DecimalFormat;

/**
 * beginning of a class.
 */
public class SavingsAccount implements IAccount {
  private double starterAmount;
  private int counter;

  /**
   * constructor.
   * @param starterAmount start money
   */
  public SavingsAccount(double starterAmount) {
    if (starterAmount < 0.01 || starterAmount < 0) {
      throw new IllegalArgumentException("Amount cannot be less than $0,01 OR negative!");
    }

    this.starterAmount = starterAmount;
    this.counter = 0;
  }

  /**
   * deposit.
   * @param value money
   */
  @Override
  public void deposit(double value) {
    if (value < 0) {
      throw new IllegalArgumentException("Amount cannot be negative!");
    }
    this.starterAmount += value;
  }

  /**
   * withdraw.
   * @param withdraw withdraw
   * @return true of false
   */
  @Override
  public boolean withdraw(double withdraw) {
    if (withdraw > this.starterAmount) {
      return false;
    }
    else {
      this.counter += 1;
      this.starterAmount -= withdraw;
      return true;
    }
  }

  /**
   * get counter.
   * @return counter
   */
  public int getCounter() {
    return this.counter;
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
   * perform maintenance.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (getCounter() > 6) {
      this.starterAmount -= 14;
    }
    this.counter = 0;
  }

  /**
   * print string.
   * @return string
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("$0.00");
    return df.format(getBalance());
  }
}
