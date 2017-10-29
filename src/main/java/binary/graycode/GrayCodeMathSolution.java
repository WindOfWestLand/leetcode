package binary.graycode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是利用数学原理解决格雷码的问题，第i个格雷码为G(i)，第i个二进制为B(i)，则:
 * G(i) = B(i)^B(i-1)
 * Created by 孙亮 on 2017/5/5.
 */
public class GrayCodeMathSolution implements GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < 1 << n; i++) {
            result.add(i^(i>>1));
        }
        return result;
    }
}
