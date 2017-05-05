package binary.gradcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一种比较笨的方法，通过上一个格雷码尝试变换每一位(0->1, 1->0)，
 * 然后检查生成的数字是否已经出现过
 *
 * Created by 孙亮 on 2017/5/5.
 */
public class GrayCodeImpl implements GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int latest = 0;

        for(int i=1; i < 1 << n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = latest ^ (1<<j);
                if(!result.contains(temp)) {
                    result.add(temp);
                    latest = temp;
                    break;
                }
            }
        }
        return result;
    }
}
