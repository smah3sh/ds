package ds;

/**
 * Created by mahesh.subramanian on 1/5/17.
 */
public class ZigZagConversion {

  public String convert(String s, int numRows) {

    if (numRows == 1) return s;

    StringBuilder [] stringBuilders = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      stringBuilders[i] = new StringBuilder();
    }

    boolean increasing = true;
    int index = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      stringBuilders[index].append(c);
      if (increasing)
        index++;
      else
        index--;
      if (index == numRows-1)
        increasing = false;
      else if (index == 0)
        increasing = true;
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      result.append(stringBuilders[i]);
    }
    return result.toString();
  }

  public static void main(String [] args) {

    String s = "PAYPALISHIRING";
    String result3 = "PAHNAPLSIIGYIR";
    String result4 = "PINALSIGYAHRPI";
    String result5 = "PHASIYIRPLIGAN";


    ZigZagConversion zzc = new ZigZagConversion();
    String response = zzc.convert(s, 3);
    System.out.println("Result3 == Response : " + result3.equals(response));
    System.out.println(result3);
    System.out.println(response);
    System.out.println();

    response = zzc.convert(s, 4);
    System.out.println("Result4 == Response : " + result4.equals(response));
    System.out.println(result4);
    System.out.println(response);
    System.out.println();

    response = zzc.convert(s, 5);
    System.out.println("Result5 == Response : " + result5.equals(response));
    System.out.println(result5);
    System.out.println(response);
    System.out.println();

    String result6 = "AB";
    response = zzc.convert(result6, 1);
    System.out.println(result6);
    System.out.println(response);
    System.out.println();


  }

}
