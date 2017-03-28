package CtCI_C01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mahesh.subramanian on 2/6/17.
 */
public class Problems {

  /**
   * Determine if a string has unique characters
   * @param s
   * @return
   */
  public boolean isUnique(String s) {

    HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (charCounter.containsKey(ch)) {
        return false;
      }
      charCounter.put(ch, 1);
    }
    return true;
  }

  boolean isUniqueNoHashmap(String s) {
    char [] charArray = s.toCharArray();
    Arrays.sort(charArray);
    String sortedString = new String(charArray);

    for (int i = 0; i < sortedString.length() - 1; i++) {
      if (sortedString.charAt(i) == sortedString.charAt(i + 1))
        return false;
    }
    return true;
  }

  /**
   * Check if the second string is a permutation of the first.
   * Strings with even length (after removing all non-letter characters) must have all even counts of
   * characters. Strings of an odd length must have exactly one character with an odd count. Of course,
   * an "even" string can't have an odd number of exactly one character, otherwise it wouldn't be an
   * even-length string (an odd number+ many even numbers= an odd number). Likewise, a string with
   * odd length can't have all characters with even counts (sum of evens is even). It's therefore
   * sufficient to say that, to be a permutation ot a palindrome, a string can have no more than one
   * character that is odd. This will cover both the odd and the even cases.
   * @param one
   * @param two
   * @return
   */
  public boolean checkPermutation(String one, String two) {

    // TODO - Error checks

    if (one.length() != two.length())
      return false;

    HashMap<Character, Integer> mapOfChars = new HashMap<Character, Integer>();

    for (int i = 0; i < one.length(); i++) {
      char ch = one.charAt(i);
      if (mapOfChars.containsKey(ch)) {
        // Increment
        int count = mapOfChars.get(ch);
        mapOfChars.put(ch, ++count);
      } else {
        // Put
        mapOfChars.put(ch, 1);
      }
    }

    // For the second map, do the opposite
    for (int j = 0; j < two.length(); j++) {
      char ch = two.charAt(j);
      if (mapOfChars.containsKey(ch)) {
        // Decrement or remove
        int count = mapOfChars.get(ch);
        if (count > 1) {
          mapOfChars.put(ch, --count);
        } else {
          mapOfChars.remove(ch);
        }
      } else {
        return false;
      }
    }
    return mapOfChars.isEmpty() ? true : false;
  }

  /**
   * Replace all spaces with %20, assume string has extra spaces. Perform operation in place
   * No not assume that input string has enough characters
   * @return
   */
  public void urlifyString(char [] url, int trueLen) {

    int insertAt = url.length - 1;
    for (int i = trueLen - 1; i >= 0; i--) {
      if (url[i] == ' ') {
        url[insertAt--] = '0';
        url[insertAt--] = '2';
        url[insertAt--] = '%';
      } else {
        url[insertAt--] = url[i];
      }
    }
  }


  public void palindromePermuatation(String s) {
    // Looks similar to check permutations
  }

  public boolean nAway(String one, String two, int numAway) {

    int oneLen = one.length();
    int twoLen = two.length();
    int counter = oneLen < twoLen ? oneLen : twoLen;

    if (Math.abs(oneLen - twoLen) > numAway)
      return false;

    int oneDelta = 0, twoDelta = 0;

    for (int i = 0; i < counter; i++) {

      if (one.charAt(i + oneDelta) == two.charAt(i + twoDelta)) {
        ;
      } else {
        if (one.charAt(i + oneDelta + 1) == two.charAt(i + twoDelta)) {
          // One is missing a char
          twoDelta++;
        } else if (one.charAt(i + oneDelta) == two.charAt(i + twoDelta + 1)) {
          // two is missing a char
          oneDelta++;
        } else {
          // both are missing a char, so they level each other out
        }
        numAway--;
        if (numAway < 0)
          return false;
      }
    }
    return true;
  }

  /**
   * Compress input String, if compressed string not smaller, return original string
   * @param s
   * @return
   */
  public String compress(String s) {

    StringBuilder compressed = new StringBuilder();

    int count = 1;
    char lastChar = s.charAt(0);

    for (int i = 1; i < s.length(); i++) {

      if (s.charAt(i) == lastChar) {
        count++;
      } else {
        compressed.append(lastChar);
        compressed.append(count);
        count = 1;
      }
      lastChar = s.charAt(i);
    }
    compressed.append(lastChar);
    compressed.append(count);
    return compressed.length() < s.length() ? compressed.toString() : s;
  }

  /**
   * Incorrect - Lookup answer
   * Rotate an MxN matrix by 90 degrees
   * @param matrix
   */
  public int [] [] rotateMatrix(int [] [] matrix, int length, int width) {
    int [] [] rotatedMatrix = new int [width] [length];

    for (int i = 0; i < matrix.length; i++) { // Number of rows
      for (int j = 0; j < matrix[i].length; j++) {  // Number of columns in this row
        rotatedMatrix[j][i] = matrix[i] [j];
      }
    }
    return rotatedMatrix;
  }

  /**
   * If any element of a matrix is 0, make all elements of that row and column 0
   * @param matrix
   */
  public void zeroMatrix(int [] [] matrix) {

    List<int []> indices = new ArrayList<int []>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          int [] index = new int[2];
          index[0] = i;
          index[1] = j;
          indices.add(index);
        }
      }
    }
    // Zero out the rows and cols
    for (int [] index : indices) {
      zeroOutRowAndCol(matrix, index[0], index[1]);
    }
  }

  public void zeroOutRowAndCol(int [] [] matrix, int row, int col) {

    // Zero out column
    for (int i = 0; i < matrix[row].length; i++) {
      matrix[row][i] = 0;
    }

    // Zero out row
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  /**
   * Helper function to print matrix
   * @param matrix
   */
  public void printMatrix(int [] [] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
        System.out.print(' ');
      }
      System.out.println();
    }
  }

  /**
   * Rotate square matrix by 90 degrees
   */
  public void rotateSquareMatrix(int [] [] matrix) {

  }


  public void stringRotation() {

  }



  public static void main(String [] args) {
    Problems p = new Problems();

/*

    System.out.println("isUnique");
    System.out.println("abcd is unique: " + p.isUnique("abcd"));
    System.out.println("abcda is unique: " + p.isUnique("abcda"));
    System.out.println("abcd is unique: " + p.isUniqueNoHashmap("abcd"));
    System.out.println("abcda is unique: " + p.isUniqueNoHashmap("abcda"));
    System.out.println();
    System.out.println("checkPermutations");
    System.out.println("abcde and cbdae are permuatations: " + p.checkPermutation("abcde", "cbdae"));
    System.out.println("aabbcde and ebacbad are permuatations: " + p.checkPermutation("aabbcde", "ebacbad"));
    System.out.println("abcde and abcd are permuatations: " + p.checkPermutation("abcde", "abcd"));
    System.out.println("abcd and abcde are permuatations: " + p.checkPermutation("abcd", "abcde"));
    System.out.println("abcd and pqrs are permuatations: " + p.checkPermutation("abcd", "pqrs"));
    System.out.println("aaaa and aaaa are permuatations: " + p.checkPermutation("aaaa", "aaaa"));
    System.out.println();
    System.out.println("urlify");
    String s = "Mr John Smith    ";
    char [] input = s.toCharArray();
    p.urlifyString(input, 13);
    System.out.println("URLified string: " + new String(input));
    s = "MrJohnSmith";
    input = s.toCharArray();
    p.urlifyString(input, 11);
    System.out.println("URLified string: " + new String(input));
    System.out.println();
    System.out.println("one AWay");
    // One Away - does not work, check answers later
    System.out.println("pale, ple 1 :" + p.nAway("pale", "ple", 1));
    System.out.println("pale, ple 0 :" + p.nAway("pale", "ple", 0));
    System.out.println("pales, pale 1 :" + p.nAway("pales", "pale", 1));
    System.out.println("pales, pale 2 :" + p.nAway("pales", "pale", 2));
    System.out.println("pale, bale 1 :" + p.nAway("pale", "bale", 1));
    System.out.println("pale, bale 2 :" + p.nAway("pale", "bale", 0));
    System.out.println("pale, bake 1 :" + p.nAway("pale", "bake", 1));
    System.out.println("pale, bake 2 :" + p.nAway("pale", "bake", 2));
    System.out.println();

    // Compress
    System.out.println("Compress aabcccccaaa:" + p.compress("aabcccccaaa"));
    System.out.println("Compress abcdef:" + p.compress("abcdef"));
    System.out.println("Compress aabccccca:" + p.compress("aabccccca"));

    // Matrix rotate
    int [] [] matrix = new int [] [] {{1, 1, 1}, {0, 0, 0}};
    int [] [] rotatedMatrix = p.rotateMatrix(matrix, 3, 2);
    System.out.println(rotatedMatrix);
    System.out.println();
*/

    // Zero matrix
    int [] [] zeroMatrix;

    zeroMatrix = new int [] [] {{1,1,1}, {2,2,2}, {3,3,3}};
    p.printMatrix(zeroMatrix);
    System.out.println();
    p.zeroMatrix(zeroMatrix);
    p.printMatrix(zeroMatrix);
    System.out.println();
    System.out.println();

    zeroMatrix = new int [] [] {{0,1,1}, {2,2,2}, {3,3,3}};
    p.printMatrix(zeroMatrix);
    System.out.println();
    p.zeroMatrix(zeroMatrix);
    p.printMatrix(zeroMatrix);
    System.out.println();
    System.out.println();

    zeroMatrix = new int [] [] {{1,1,0}, {2,2,2}, {3,3,3}};
    p.printMatrix(zeroMatrix);
    System.out.println();
    p.zeroMatrix(zeroMatrix);
    p.printMatrix(zeroMatrix);
    System.out.println();
    System.out.println();

    zeroMatrix = new int [] [] {{1,1,0}, {0,2, 2}, {3, 3, 3}};
    p.printMatrix(zeroMatrix);
    System.out.println();
    p.zeroMatrix(zeroMatrix);
    p.printMatrix(zeroMatrix);
    System.out.println();
    System.out.println();

    zeroMatrix = new int [] [] {{0,1,1}, {2,2,2}, {3,3,0}};
    p.printMatrix(zeroMatrix);
    System.out.println();
    p.zeroMatrix(zeroMatrix);
    p.printMatrix(zeroMatrix);
    System.out.println();
    System.out.println();
    System.out.println();

  }
}
