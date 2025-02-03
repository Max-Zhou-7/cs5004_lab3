package bank;

public interface IAccount {
  public void deposit(double value);
  public boolean withdraw(double withdraw);
  public double getBalance();
  public void performMonthlyMaintenance();
}
