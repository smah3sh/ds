package ds;

/**
 * Created by mahesh.subramanian on 1/3/17.
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {

    String longest = null;
    for (String str : strs) {
      if (longest == null) {
        longest = str;
      } else {
        if (longest.startsWith(str)) {
          longest = str;
        } else if (str.startsWith(longest)) {
          ;
        } else {
          do {
            longest = longest.substring(0, longest.length() - 1);
          } while (longest.length() > 0 && !str.startsWith(longest));
        }
      }
    }
    return longest == null ? "" : longest;
  }

  public static void main(String [] args) {
    // String [] data = {"abcd", "ab", "abdef", "abdegasf"};
    // String [] data = {};
    // String [] data = {"a"};
    // String [] data = {"", "b"};
    // String [] data = {"ca", "a"};
    String [] data = {"abc", "abcde", "abdef", "abdegasf"};

    LongestCommonPrefix lcp = new LongestCommonPrefix();
    System.out.println("Longest Common Prefix: " + lcp.longestCommonPrefix(data));

  }

}
