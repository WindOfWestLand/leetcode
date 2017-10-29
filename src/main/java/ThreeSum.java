import java.util.*;

/**
 * Created by 孙亮 on 2017/5/12.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> threeSums = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            List<List<Integer>> twoSums = twoSum(nums, 0-nums[i], i);
            for(List<Integer> twoSum : twoSums) {
                twoSum.add(nums[i]);
                threeSums.add(twoSum);
            }
        }

        return threeSums;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int skipIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = skipIndex+1, j = nums.length-1; i < j;) {
            // [0,0,2,2]
            if(i > skipIndex+1 && nums[i] == nums[i-1]) {
                i ++;
                continue;
            }
            if(j < nums.length-1 && nums[j] == nums[j+1]) {
                j --;
                continue;
            }

            if(nums[j] == (target-nums[i])) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                result.add(tmp);
            }

            if(nums[j] > (target-nums[i])) j --;
            else if(nums[j] < (target-nums[i])) i ++;
            else {
                i++;
                j--;
            }
        }
        return result;
    }
}
