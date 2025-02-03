package bank;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * beginning of test.
 */
public class testSavingsAccount {
  SavingsAccount a;
  SavingsAccount b;
  SavingsAccount c;

  /**
   * set up.
   */
  @Before
  public void setup() {
    a = new SavingsAccount(20.345);
  }

  /**
   * general test.
   */
  @Test
  public void testGeneral() {
    a.deposit(1.11);
    assertEquals(21.455,a.getBalance(),0);
    a.withdraw(3.223);
    a.withdraw(3.232);
    assertEquals(2,a.getCounter(),0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    a.withdraw(1.0);
    assertEquals(8.0,a.getBalance(),0);
    a.performMonthlyMaintenance();
    assertEquals(-6.0,a.getBalance(),0);
    assertEquals(0,a.getCounter());
    a.deposit(10);
    assertEquals("$4.00",a.toString());
  }

  /**
   * test exception.
   */
  @Test
  public void testException() {
    Assert.assertThrows(IllegalArgumentException.class,
            () -> {
              b = new SavingsAccount(0.000005);
              c = new SavingsAccount(-10.21);
              b.deposit(-2.23);
            });

  }
}

