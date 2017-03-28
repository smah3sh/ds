package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahesh.subramanian on 1/12/17.
 */
public class PhoneLetterCombinations {

  char[][] numbers = {
          {},   //  0
          {},   // 1
          {'a', 'b', 'c'},  // 2
          {'d', 'e', 'f'},  // 3
          {'g', 'h', 'i'},  // 4
          {'j', 'k', 'l'},  // 5
          {'m', 'n', 'o'},  // 6
          {'p', 'q', 'r', 's'}, // 7
          {'t', 'u', 'v'},  // 8
          {'w', 'x', 'y', 'z'}, // 9
          {} // 10
  };


  public List<String> letterCombinationsNR(String digits) {

    List<String> results = new ArrayList<String>();

    if (digits == null || digits.length() == 0)
      return results;

    for (char ch : digits.toCharArray()) {

      List<String> temp = new ArrayList<String>();
      int number = Character.getNumericValue(ch);

      if (results.isEmpty()) {
        for (int i = 0; i < numbers[number].length; i++) {
          results.add(String.valueOf(numbers[number][i]));
        }
      } else {
        for (int i = 0; i < numbers[number].length; i++) {
          for (int j = 0; j < results.size(); j++) {
            StringBuilder s = new StringBuilder();
            s.append(results.get(j));
            s.append(numbers[number][i]);
            temp.add(s.toString());
          }
        }
        results.clear();
        results.addAll(temp);
      }
    }
    return results;
  }


  /**
   * Recursive function to perform the same task
   * @param digits
   * @param results
   * @return
   */
  public List<String> letterCombinations(StringBuilder digits, List<String> results) {

    if (digits == null || digits.length() == 0)
      return results;
    else {
      char ch = digits.charAt(0);
      digits.deleteCharAt(0);
      List<String> temp = new ArrayList<String>();
      int number = Character.getNumericValue(ch);

      if (results.isEmpty()) {
        for (int i = 0; i < numbers[number].length; i++) {
          results.add(String.valueOf(numbers[number][i]));
        }
      } else {
        for (int i = 0; i < numbers[number].length; i++) {
          for (int j = 0; j < results.size(); j++) {
            StringBuilder s = new StringBuilder();
            s.append(results.get(j));
            s.append(numbers[number][i]);
            temp.add(s.toString());
          }
        }
        results.clear();
        results.addAll(temp);
      }
      return letterCombinations(digits, results);
    }
  }

  String alphabets = "abcdefghijklmnopqrstuvwxyz";
  public List<String> permutations(int number, List<String> results) {
    if (number == 0)
      return results;
    else {
      List<String> temp = new ArrayList<String>();
      for (int i = 0; i < results.size(); i++) {
        temp.add(results.get(i) + alphabets.charAt(number));
      }
      results.clear();
      results.addAll(temp);
      return permutations(--number, results);
    }
  }

  public static void main(String[] args) {

    String numbers = "3568";
    PhoneLetterCombinations plc = new PhoneLetterCombinations();
    List<String> results = new ArrayList<String>();
    StringBuilder sb = new StringBuilder("3568");
    plc.letterCombinations(sb, results);
    List <String> results2 = plc.letterCombinationsNR(numbers);
/*
    // Print data
    System.out.println("Size: " + results.size() + ", " + results2.size());
    for (int i = 0; i < results.size(); i++) {
      System.out.println(results.get(i) + ", " + results2.get(i));
    }
*/
    List<String> permutations = plc.permutations(3, results);
    for (int i = 0; i < results.size(); i++) {
      System.out.println(permutations.get(i));
    }


  }

}
