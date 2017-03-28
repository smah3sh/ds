package ds;

/**
 * Created by mahesh.subramanian on 1/3/17.
 */
public class MedianOfTwoSortedArrays {

  public double findMSA(int[] nums1, int[] nums2) {

    double median = ((nums1.length + nums2.length) / 2.0);
    boolean odd = (nums1.length + nums2.length) % 2 == 0 ? false : true;

    if (nums1.length == 0 && nums2.length == 0) {
      return 0;
    } else if (nums1.length == 0 && nums2.length == 1) {
      return nums2[0] / 2.0;
    } else if (nums1.length == 0 && nums2.length > 1) {
      if (odd)
        return nums2[nums2.length / 2];
      else
          return ((nums2[(nums2.length-1) / 2] + nums2[nums2.length / 2]) / 2.0);
    } else if (nums2.length == 0 && nums1.length == 1) {
      return nums1[0] / 2.0;
    } else if (nums2.length == 0 && nums1.length > 0) {
      if (odd)
        return nums1[nums1.length / 2];
      else
        return ((nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2]) / 2.0);
    } else {
      int index_one = 0, index_two = 0;
      while ((index_one + index_two) < (median - 1)) {
        if (nums1.length == 0 || nums1[index_one] > nums2[index_two]) {
          index_two++;
        } else {
          index_one++;
        }
      }

      int val1 = 0, val2 = 0;

      if (nums1.length > 0) {
        if (index_one < nums1.length )
          val1 = nums1[index_one];
        else
          val1 = nums2[index_two];
      }
      if (nums2.length > 0) {
        if (index_two < nums2[index_two])
          val2 = nums2[index_two];
        else
          val2 = nums1[index_one];
      }

      if (nums1.length == 0 && nums2.length > index_two + 1) {
        val1 = nums2[index_two + 1];
      }
      if (nums2.length == 0 && nums1.length > index_one + 1) {
        val2 = nums1[index_one + 1];
      }

      if (odd) {
        // Return smaller value
        return val1 > val2 ? val2 : val1;
      } else {
        // Return mid value
        return (val1 == 0 || val2== 0) ? (val1 + val2) : (val1 + val2) / 2.0;
      }
    }


  }


  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    double median = 0.0;
    int index = (nums1.length + nums2.length) / 2;
    int index_one = 0, index_two = 0;

    int first = 0, second = 0;
    if ((nums1.length + nums2.length) % 2 != 0) {

      // Odd, find middle number
      while ((index_one + index_two) <= index) {
        if (index_one < nums1.length && (nums1.length == 0 || nums1[index_one] > nums2[index_two])) {
          index_two++;
        } else {
          index_one++;
        }
      }
      if (index_one < nums1.length) {
        first = nums1[index_one];
      }
      if (index_two < nums2.length) {
        second = nums2[index_two];
      }
      median = first < second? first : second;

    } else {
      // even, find 2 middle numbers
      while ((index_one + index_two) < index) {
        if (index_one < nums1.length && (nums1.length == 0 || nums1[index_one] > nums2[index_two])) {
          index_two++;
        } else {
          index_one++;
        }
      }
      if (index_one < nums1.length) {
        first = nums1[index_one];
      }
      if (index_two < nums2.length) {
        second = nums2[index_two];
      }
      if (++index_one < nums1.length) {
        if (second > nums1[index_one])
          second = nums1[index_one];
      }
      median = first + second / 2.0;
    }
    return median;
  }

  public int removeDuplicates(int[] nums) {

    if (nums.length < 2) return nums.length;

    int uniques = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] != nums[i]) {
        nums[uniques - 1] = nums[i - 1];
        nums[uniques] = nums[i];
        uniques++;
      }
    }
    return uniques;
  }

  /**
   * Remove the value from the array and return the remaining values
   * For example, [3,2,2,3], val = 3 should return length = 2 and first two elements 2,2
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {

    int removed = 0;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] != val) {
        nums[removed] = nums[i];
        removed++;
      }
    }
    return removed;

  }

  public int removeElement2(int[] nums, int val) {
    int i = 0, removed = 0;

    while (i < nums.length) {

      if (nums[i] == val) {
        // remove by bringing next one forward one place
        if (i != nums.length - 1) {
          nums[i - removed] = nums[i + 1];
        }
        removed++;
      }
      i++;
    }
    return removed;

  }

  public void printArray(int [] data){
    for (int i : data) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String [] args) {

    MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();

    /*
    int [] data = {1,2,3,3,3,5};
    int [] data = {1,1};
    int uniques = motsa.removeDuplicates(data);
    System.out.println("Uniques: " + uniques);
    motsa.printArray(data);
    */

    // int [] data = {1,2,3,3,3,5};
    int [] data = {3,2,2,3};
    // int duplicates = motsa.removeElement(data, 3);
    //int [] data = {1};
    int duplicates = motsa.removeElement(data, 2);

    System.out.println("Duplicates: " + duplicates);
    motsa.printArray(data);



/*
    int [] nums1 = {1,2,3,4};
    int [] nums2 = {};
    System.out.println("Motsa 2.5 :" + motsa.findMedianSortedArrays(nums1, nums2));

    int [] nums3 = {1,2,3,4,5};
    int [] nums4 = {};
    System.out.println("Motsa : 3.0 " + motsa.findMedianSortedArrays(nums3, nums4));

    int [] nums5 = {};
    int [] nums6 = {1,2,3,4,5};
    System.out.println("Motsa : 3.0 " + motsa.findMedianSortedArrays(nums5, nums6));

    int [] nums7 = {};
    int [] nums8 = {1,2,3,4};
    System.out.println("Motsa : 2.5 " + motsa.findMedianSortedArrays(nums7, nums8));

    int [] nums9 = {};
    int [] nums10 = {};
    System.out.println("Motsa : 0.0 " + motsa.findMedianSortedArrays(nums9, nums10));

    int [] nums11 = {2,4,6,8};
    int [] nums12 = {1,3,5,7,11};
    System.out.println("Motsa : 5.0 " + motsa.findMedianSortedArrays(nums11, nums12));

    int [] nums13 = {1,3,5,7,11};
    int [] nums14 = {2,4,6,8};
    System.out.println("Motsa : 5.0 " + motsa.findMedianSortedArrays(nums13, nums14));

    int [] nums15 = {};
    int [] nums16 = {1};
    System.out.println("Motsa : 0.5 " + motsa.findMedianSortedArrays(nums15, nums16));

    int [] nums17 = {1,3,5,7};
    int [] nums18 = {2,4,6,8};
    System.out.println("Motsa : 4.5 " + motsa.findMedianSortedArrays(nums17, nums18));
*/
    int [] nums19 = {2,2,2};
    int [] nums20 = {2,2,2,2};
    // System.out.println("Motsa : 2.0 " + motsa.findMedianSortedArrays(nums19, nums20));

  }
}
