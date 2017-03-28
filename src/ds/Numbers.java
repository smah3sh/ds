package ds;

/**
 * Created by mahesh.subramanian on 1/23/17.
 */
public class Numbers {

  /**
   * Divide two integers without using multiplication, division and mod operator.
   * If it is overflow, return MAX_INT.
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {


    if (divisor == 0|| (dividend == Integer.MIN_VALUE && divisor == -1))
      return Integer.MAX_VALUE;

    int result = 0;
    boolean negate = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? false : true;

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    if (divisor == 1) {
      result = dividend;
    } else {
      while (dividend > divisor) {
        dividend -= divisor;
        result++;
      }
    }

    if (negate)
      return - result;
    else
      return result;
  }

  public static void main(String [] args) {

    Numbers n = new Numbers();

/*
    System.out.println(n.divide(10, 2));
    System.out.println(n.divide(-1, 1));
    System.out.println(n.divide(1, -1));
    System.out.println(n.divide(-2147483648, -1));
    System.out.println(n.divide(2147483647, 1));
*/
    System.out.println(n.divide(2147483647, 2));



  }
}
