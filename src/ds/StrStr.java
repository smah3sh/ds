package ds;

import java.util.*;

/**
 * Created by mahesh.subramanian on 1/17/17.
 */
public class StrStr {

  public List<Integer> strStr(String haystack, String needle) {
    List<Integer> results = new ArrayList<Integer>();
    int index = strStrInt(haystack, needle, 0);
    if (index >= 0) {
      results.add(index);
      while (index >= 0 && (index < (haystack.length() - needle.length()))) {
        index = strStrInt(haystack, needle, index + 1);
        if (index != -1)
          results.add(index);
      }
    }
    return results;
  }


  public int strStrOld(String haystack, String needle) {
    return strStrInt(haystack, needle, 0);
  }


  public int strStrInt(String haystack, String needle, int i) {

    if (i + needle.length() > haystack.length())
      return -1;
    if (strcmp(haystack.substring(i, i + needle.length()), needle) == 0) {
      return i;
    }
    return strStrInt(haystack, needle, ++i);
  }

  public int strcmp(String one, String two) {

    if (one.length() != two.length()) return -1;

    for (int i = 0; i < one.length(); i++) {
      if (one.charAt(i) != two.charAt(i))
        return -1;
    }
    return 0;
  }

  /**
   * Given "barfoothefoobarman" and inputwords: ["foo", "bar"], You should return the indices: [0,9].
   * @param s
   * @param words
   * @return
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<Integer>();
    Set<String> results = new HashSet<String>();

    permuteWords("", new ArrayList<String>(Arrays.asList(words)), results);

    for (String result : results) {
      List<Integer> integerList = strStr(s, result);
      indices.addAll(integerList);
    }

    return indices;
  }


  public void permuteWords(String prefix, List<String> words, Set<String> results) {
    int n = words.size();
    if (n == 0) {
      results.add(prefix);
    }
    else {
      for (int i = 0; i < n; i++) {
        List<String> prepost = new ArrayList<String>();
        for (int j = 0; j < i; j++) {
          prepost.add(words.get(j));
        }
        for (int j = i + 1; j < n; j++) {
          prepost.add(words.get(j));
        }
        permuteWords(prefix + words.get(i), prepost, results);
      }
    }
  }


  public void printList(List<?> results) {
    for (Object o  : results) {
      System.out.println(o);
    }
    System.out.println();
  }

  public static void main(String [] args) {

    StrStr s = new StrStr();
/*
    String haystalk = "";
    String needle = "";
    int currentIndex = 0;

    haystalk = "knaweoahaha,asdfop";
    needle = "haha";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);

    haystalk = "hahahasdf;qeruohawhahaZXcmeOIASDNZXCV";
    needle = "haha";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);

    haystalk = "abcdhaha";
    needle = "haha";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);

    haystalk = "abcdhah";
    needle = "haha";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);

    haystalk = "mississippi";
    needle = "issip";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);

    haystalk = "bash";
    needle = "as";

    currentIndex = s.strStr(haystalk, needle);
    System.out.println("Index: " + currentIndex);
 */
/*
    List<String> words = new ArrayList<String>();
    words.add("a");
    words.add("b");
    words.add("c");
    words.add("d");
    List<String> results = new ArrayList<String>();
    //s.permuteWords("", words, results);
    //s.printList(results);
*/

    String a;
    String [] b;
    List<Integer> indexes = null;

    //a = "barfoothefoobarman";
    //[] b = {"foo", "bar"};
    //a = "barfoofoobarthefoobarman";
    //[] b = {"bar","foo","the"};


    //a = "wordgoodgoodgoodbestword";
    //b = new String [] {"word","good","best","good"};


    a = "foobarfoobar";
    b = new String [] {"foo","bar"};

    indexes = s.findSubstring(a, b);
    s.printList(indexes);



/*
    List<String> words = new ArrayList<String>();
    List<String> results = new ArrayList<String>();
    words.add("bar");
    words.add("foo");
    words.add("the");
    s.permuteWords("", words, results);
    s.printList(results);
*/
    //List<Integer> indices = s.findSubstring(a, b);
    //s.printList(indices);
    // s.permuteLetters("", "abcd");


    }
}
