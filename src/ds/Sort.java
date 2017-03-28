package ds;

import java.util.Arrays;

/**
 * Created by mahesh.subramanian on 10/20/16.
 */
public class Sort {

  public void bubble(int [] data) {
    for (int i = 0; i < data.length - 1; i++) {
      for (int j = 0; j < data.length - 1; j++) {
        // Swap data[i], data[j]
        if (data[j] > data[j + 1]) {
          int temp = data[j];
          data[j] = data[j + 1];
          data[j + 1]= temp;
        }
        System.out.println(Arrays.toString(data));
      }
    }
  }

  public static void main(String [] args) {

    Sort sort = new Sort();
    int [] data = new int [] {5, 6, 2, 54, 23, 52, 17};
    System.out.println(Arrays.toString(data));
    sort.bubble(data);
    System.out.println(Arrays.toString(data));

  }

}
