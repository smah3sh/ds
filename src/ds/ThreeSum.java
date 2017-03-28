package ds;

import java.util.*;

/**
 * Created by mahesh.subramanian on 1/6/17.
 */
public class ThreeSum {

  public List<List<Integer>> threeSumSlowest(int[] nums) {

    Set<Set<Integer>> unique = new HashSet<Set<Integer>>();
    List<List<Integer>> lols = new ArrayList<List<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1 ; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (i == j || i == k || j == k)
            continue;
          if (nums[i] + nums[j] + nums[k] == 0) {

            Set<Integer> currentSet = new HashSet<Integer>();
            currentSet.add(nums[i]);
            currentSet.add(nums[j]);
            currentSet.add(nums[k]);

            if (!unique.contains(currentSet)) {
              unique.add(currentSet);
              List<Integer> list = new ArrayList<Integer>();
              list.add(nums[i]);
              list.add(nums[j]);
              list.add(nums[k]);
              lols.add(list);
            }
          }
        }
      }
    }
    return lols;
  }

  /**
   * Given an array and an input integer, return the two indexes that add up to this value
   * @param data
   * @param target
   * @return
   */
  public int [] twoSumOld(int [] data, int target) {
    int [] values = new int[2];
    values[0] = values[1] = -1;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < data.length; i++) {
      int compliment = target - data[i];
      if (map.containsKey(compliment)) {
        values[0] = i;
        values[1] = map.get(compliment);
        return values;
      }
      map.put(data[i], i);
    }
    return values;
  }

  public List<int []>  twoSum(int [] nums, int start) {

    List<int []> values = new ArrayList<int[]>();
    int target = -nums[start];

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int j = 0; j < nums.length; j++) {
      if (j == start) continue;
      int compliment = target - nums[j];
      if (map.containsKey(compliment)) {
        int [] pair = new int[2];
        pair[0] = pair[1] = -1;
        pair[0] = j;
        pair[1] = map.get(compliment);
        values.add(pair);
      }
      map.put(nums[j], j);
    }
    return values;
  }


  public List<List<Integer>> threeSumSlow(int[] nums) {

    List<List<Integer>> lols = new ArrayList<List<Integer>>();
    if (nums.length < 3) return lols;
    Set<Set<Integer>> uniqueSets = new HashSet<Set<Integer>>();

    // ds.Sort the arrays
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {

      if (i < nums.length - 1) {
        // skip duplicates
        if (nums[i] == nums[i+1])
          continue;
      }

      List<int []> values = new ArrayList<int[]>();

      int target = -nums[i];

      Map<Integer, Integer> map = new HashMap<Integer, Integer>();

      for (int j = 0; j < nums.length; j++) {
        if (j == i) continue;
        int compliment = target - nums[j];
        if (map.containsKey(compliment)) {
          int [] pair = new int[2];
          pair[0] = pair[1] = -1;
          pair[0] = j;
          pair[1] = map.get(compliment);

          if (nums[i] + nums[pair[0]] + nums[pair[1]] == 0) {

            Set<Integer> currentSet = new HashSet<Integer>();
            currentSet.add(nums[i]);
            currentSet.add(nums[pair[0]]);
            currentSet.add(nums[pair[1]]);

            if (!uniqueSets.contains(currentSet)) {
              uniqueSets.add(currentSet);
              List<Integer> list = new ArrayList<Integer>();
              list.add(nums[i]);
              list.add(nums[pair[0]]);
              list.add(nums[pair[1]]);
              lols.add(list);
            }
          }
          values.add(pair);
        }
        map.put(nums[j], j);
      }
    }
    return lols;
  }

  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums.length < 3) return result;
    Arrays.sort(nums);
    int i = 0;

    while(i < nums.length - 2) {

      if(nums[i] > 0) break;
      int j = i + 1;
      int k = nums.length - 1;

      while(j < k) {
        int sum = nums[i] + nums[j] + nums[k];

        if(sum == 0){
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        }
        if(sum <= 0)
          while(nums[j] == nums[j++] && j < k);
        if(sum >= 0)
          while(nums[k--] == nums[k] && j < k);
      }
      while(nums[i] == nums[++i] && i < nums.length - 2);
    }
    return result;
  }


  public void printlols(List<List<Integer>> lols) {

    if (lols.isEmpty()) {
      System.out.println("Empty");
    } else {
      for (List<Integer> list : lols ) {
        System.out.print("List : ");
        for (Integer i : list) {
          System.out.print(i + " ");
        }
        System.out.println();
      }
    }
  }

  public static void main(String [] args) {

    ThreeSum ts = new ThreeSum();
    // int [] nums = {0, 0};
    // int [] nums = {1,2,-2,-1};
    int [] nums = {-2, 0, 1, 1, 2};
    // int [] nums = {-1, 0, 1, 2, -1, -4};
    // int [] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    // int [] nums = {-13,10,11,-3,8,11,-4,8,12,-13,5,-6,-4,-2,12,11,7,-7,-3,10,12,13,-3,-2,6,-1,14,7,-13,8,14,-10,-4,10,-6,11,-2,-3,4,-13,0,-14,-3,3,-9,-6,-9,13,-6,3,1,-9,-6,13,-4,-15,-11,-12,7,-9,3,-2,-12,6,-15,-10,2,-2,-6,13,1,9,14,5,-11,-10,14,-5,11,-6,6,-3,-8,-15,-13,-4,7,13,-1,-9,11,-13,-4,-15,9,-4,12,-4,1,-9,-5,9,8,-14,-1,4,14};
    long start = System.nanoTime();
    List<List<Integer>> lols = ts.threeSum(nums);
    long end = System.nanoTime();
    ts.printlols(lols);
    System.out.println("Time take in nanos: " + (end - start));

  }
}
