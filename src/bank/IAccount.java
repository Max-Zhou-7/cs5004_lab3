package bank;

/**
 * Iaccount interface setup.
 */
public interface IAccount {

  /**|
   * deposit.
   * @param value money
   */
  public void deposit(double value);

  /**
   * withdraw.
   * @param withdraw withdraw
   * @return boolean
   */
  public boolean withdraw(double withdraw);

  /**
   * sum of account.
   * @return sum of money
   */
  public double getBalance();

  /**
   * different monthly performance.
   */
  public void performMonthlyMaintenance();
}
