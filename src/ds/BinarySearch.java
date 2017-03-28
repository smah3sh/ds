package ds; /**
 * Created by mahesh.subramanian on 10/20/16.
 */

import java.util.Arrays;

public class BinarySearch {

  private BinarySearch() {
  }

  public static int binarySearch(int[] a, int key) {

    int l = 0;
    int r = a.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (key < a[mid])
        r = mid - 1;
      else if (key > a[mid])
        l = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {

    int[] data = new int[]{1, 5, 6, 7, 8, 11, 15, 12};

    // sort the array
    Arrays.sort(data);
    System.out.println("Sorted data : " + Arrays.toString(data));

    for (int i = 0; i < 20; i++) {
      int index = BinarySearch.binarySearch(data, i);
      if (index != -1)
        System.out.println("Index of number : " + i + " is : " + index);
    }

  }
}
