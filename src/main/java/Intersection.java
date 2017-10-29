import java.util.*;

/**
 * Created by 孙亮 on 2017/5/5.
 */
public class Intersection {
    public  int[] intersectionWithNoDuplicate(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> result = new HashSet<Integer>();
        for(int num : nums2) {
            if(set1.contains(num)) {
                result.add(num);
            }
        }
        int[] intersection = new int[result.size()];

        int i = 0;
        for(Integer num : result) {
            intersection[i]=num;
            i ++;
        }
        return intersection;
    }

    public int[] intersectWithDuplicate(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersList = new ArrayList<Integer>();
        int i = 0, j =0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                intersList.add(nums1[i]);
                i ++;
                j ++;
            } else if(nums1[i] > nums2[j]) {
                j ++;
            } else if(nums1[i] < nums2[j]) {
                i ++;
            }
        }
        int[] result = new int[intersList.size()];
        for(int k = 0; k < result.length; k++) {
            result[k] = intersList.get(k);
        }
        List<Character> list = new ArrayList<Character>(){{ add('1');}};

        return result;
    }
}
