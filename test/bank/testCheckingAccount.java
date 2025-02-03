package bank;
import static org.junit.Assert.assertEquals;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * beginning of test.
 */
public class testCheckingAccount {
  CheckingAccount a;
  CheckingAccount b;
  CheckingAccount c;
  private final double delta = 0.01;

  /**
   * set up.
   */
  @Before
  public void setup() {
    a = new CheckingAccount(20.345);
  /**
   * general test.
   */
  }
  @Test
  public void testGeneral() {
    a.deposit(1.1);
    assertEquals(21.445, a.getBalance(),delta);
    assertEquals(true,a.withdraw(1.445));
    assertEquals(20.0, a.getBalance(),delta);
    assertEquals(false,a.withdraw(30.232));
    assertEquals(20.0, a.getBalance(),delta);
    a.performMonthlyMaintenance();
    assertEquals(15.0, a.getBalance(),delta);
    a.deposit(100);
    a.performMonthlyMaintenance();
    assertEquals(110.0, a.getBalance(),delta);

    assertEquals("$110.00", a.toString());
  }

  /**
   * test exception.
   */
  @Test
  public void testException() {
    Assert.assertThrows(IllegalArgumentException.class,
              ()->{
        b = new CheckingAccount(0.000005);
        c = new CheckingAccount(-10.21);
        b.deposit(-2.23);
    });

  }
}
