package ds;

/**
 * Created by smahesh on 1/8/17.
 * The two main components required for every recursive call
 * 1. The base case.
 *  a. Returns a value without making any subsequent recursive calls.
 *  b. This is done for one or more input values for which the function can be evaluated without recursion.
 *  c. For factorial() base case is n = 1,
 * 2. The reduction step
 *  a. This is central part of the recursive function
 *  b. It relates to the value of the function at one (or more) input values to the value of the function at one (or more) other input values
 *  c. The sequence of input values must converge to the base case
 *  d. For factorial() the value of n decreases by 1 for each call, so the sequence of input calls converges to the base case
 */
public class Recursion {

  public long factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n-1);
  }

  /**
   * GCD - Euclid's algorithm - if (p > q, gcd of p and q is the same as the gcd of (q, p % q) )
   * @param p
   * @param q
   * @return
   */
  public long gcd(long p, long q) {
    // base case
    if (p % q == 0)
      return  q;
    else
      return gcd(q, p % q);
  }

  /**
   * Satisfies the following rules
   * 1. Moves only one disc at a time
   * 2. Never place a larger disc on a smaller one
   * Algorithm
   * a. Move top n - 1 discs to an empty pole
   * b. Move the largest disc to the other empty pole
   * c. Complete the job by moving the n - 1 discs on to the largest disc
   * @param n
   * @param left
   */
  public void toh(int n, boolean left) {

    if (n == 0) return;
    toh(n - 1, !left);
    if (left)
      System.out.println(n + " left");
    else
      System.out.println(n + " right");
    toh(n - 1, !left);
  }

  /**
   * Fibonacci series
   * @param n
   * @return
   */
  public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public void perm(String prefix, String s, int len) {
    if (prefix.length() == len) {
      System.out.println(prefix);
    }
    for (int i = 0; i < s.length(); i++) {
      perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()), len);
    }
  }

  /**
   * Top down dynamic programming solution for calculating fibonacci
   * @param n
   * @param cache
   * @return
   */
  public int topdownFibonacci(int n, int [] cache) {

    if (n <= 1) return n;
    if (cache[n] > 0) return cache[n];

    // Compute fibonacci
    cache[n] = topdownFibonacci(n - 1, cache) + topdownFibonacci(n - 2, cache);
    return cache[n];
  }

  public long bottomupFibonacci(int n) {
    long[] f = new long[n+1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++)
      f[i] = f[i-1] + f[i-2];
    return f[n];
  }

  /**
   * Given an input string, print out all the letter combinations of this string
   * @param prefix
   * @param s
   */
  public void letterCombinations(String prefix, String s) {
    int length = s.length();
    if (s.length() == 0) {
      System.out.println(prefix);
    }
    for (int i = 0; i < s.length(); i++) {
      letterCombinations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, length));
    }
  }

  /**
   * Reverse a string
   * @param s
   * @param temp
   * @return
   */
  public StringBuilder reverse(StringBuilder s, StringBuilder temp) {
    if (s.length() == 0)
      return temp;
    temp.append(s.charAt(0));
    s.deleteCharAt(0);
    return reverse(s, temp);
  }

  public void printReverse(StringBuilder s) {
    if (s.length() == 0)
      return;
    System.out.print(s.charAt(s.length() - 1));
    s.deleteCharAt(s.length() - 1);
    printReverse(s);
  }


  /**
   * Return number of occurences
   * @param sb
   * @param ch
   * @return
   */
  public int countOccurances(StringBuilder sb, char ch, int count) {

    if (sb.length() == 0)
      return count;
    if (sb.charAt(0) == ch)
      count++;
    return countOccurances(sb.deleteCharAt(0), ch, count);
  }

  public void isPerfectNumber(int number, int counter, int total) {

    if (counter == number - 1) {
      if (number == total)
        System.out.println(number + " is perfect number");
      else
        System.out.println(number + " is not a perfect number");
      return;
    }
    counter++;
    if (number % counter == 0)
      total += counter;
    isPerfectNumber(number, counter, total);
  }

  public void anagrams(String prefix, String s) {
    if (s.length() == 0)
      System.out.println(prefix);
    for (int i = 0; i < s.length(); i++) {
      anagrams(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
    }
  }

  public static void main(String [] args) {
    Recursion r = new Recursion();
/*
    // Factorial
    System.out.println("Factorial 10: "+ r.factorial(10));
    // GCD
    System.out.println("GCD 10, 25: "+ r.gcd(10, 25));
    // Towers of hanoi
    r.toh(3, true);

    // Fibonacci
    int fibonacci = 20;
    long start = System.nanoTime();
    long result = r.fibonacci(fibonacci);
    long stop = System.nanoTime();
    System.out.println("Fibonacci of " + fibonacci + " : " + result + ", Millis taken: " + (stop - start));

    // Top Down Fibonacci
    start = System.nanoTime();
    int [] cache = new int[fibonacci + 1];
    for (int i = 0; i < cache.length; i++) {
      cache[i] = 0;
    }
    result = r.topdownFibonacci(fibonacci, cache);
    stop = System.nanoTime();
    System.out.println("Top down Fibonacci of " + fibonacci + " : " + result + ", Millis taken: " + (stop - start));

    // Bottom Fibonacci
    start = System.nanoTime();
    result = r.bottomupFibonacci(fibonacci);
    stop = System.nanoTime();
    System.out.println("Bottom up Fibonacci of " + fibonacci + " : " + result + ", Millis taken: " + (stop - start));
*/

    //r.letterCombinations("", "dog");
    System.out.println();
    //r.perm("", "dog", 2);
/*
    StringBuilder in = new StringBuilder("abc"), out = new StringBuilder();
    r.reverse(in, out);
    System.out.println(in + ", " + out);
    r.printReverse(new StringBuilder("abcdef"));
*/
    // System.out.println("Number of occurances :" + r.countOccurances(new StringBuilder("abcaea"), 'a', 0));

/*
    r.isPerfectNumber(6, 0, 0);
    r.isPerfectNumber(8, 0, 0);
    r.isPerfectNumber(28, 0, 0);
    r.isPerfectNumber(248, 0, 0);
    r.isPerfectNumber(496, 0, 0);
*/
    r.anagrams("", "abcd");

  }

}