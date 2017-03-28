package ds;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mahesh.subramanian on 1/24/17.
 */
public class PartitionKSubsets {


  public HashMap<Integer, Integer> partition (int [] input, int numPartitions) {
    HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

    int arraySum = 0;
    for (int i : input) {
      arraySum += i;
    }

    int mod = arraySum % numPartitions;
    if (mod > 0)
      return results;

    int partitionSum = arraySum / numPartitions;

    // ds.Sort the array
    Arrays.sort(input);


    return results;
  }

  public static void main(String [] args) {

    PartitionKSubsets pks = new PartitionKSubsets();

    int [] data;
    int numPartitions = 0;

    data = new int [] {2,1,4,5,6};
    numPartitions = 3;

    HashMap<Integer, Integer> results = pks.partition(data, numPartitions);



  }

}
