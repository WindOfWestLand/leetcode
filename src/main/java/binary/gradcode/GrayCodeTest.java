package binary.gradcode;

import java.util.List;

/**
 * Created by 孙亮 on 2017/5/5.
 */
public class GrayCodeTest {
    private GrayCode grayCode;

    public GrayCodeTest(GrayCode grayCode) {
        this.grayCode = grayCode;
    }

    /**
     * 1. GrayCode相邻的差值为2的n次方
     * 2. 结果长度为2的n次方
     * 3. 任意值的范围再[0, 2^n)之间
     * 4. 结果集合不重复
     * 5. 第一个数字为0
     * @param n
     */
    public boolean checkGrayCode(int n) {
        List<Integer> result = grayCode(n);
        printGrayCode(result);

        if(result.get(0) != 0) {
            return false;
        }
        if(result.size() != 1 << n) {
            return false;
        }

        int max = 0;
        int min = 0;
        int pri = 0;
        for(int i = 1; i < 1<<n; i++ ) {
            int integer = result.get(i);
            if(integer > max) {
                max = integer;
            }
            if(integer < min) {
                min = integer;
            }
            // 相邻两个数字取异或，结果应为2的n次方，在二进制中也就是只有一个1出现其他全为0
            int andOr = integer ^ pri;
            boolean mark = false;
            for(int j = 0; j < n; j++) {
                if(andOr == 1 << j) {
                    mark = true;
                    break;
                }
            }
            if(mark == false) {
                return false;
            }

            pri = integer;
        }
        return true;
    }

    public List<Integer> grayCode(int n) {
        return this.grayCode.grayCode(n);
    }

    public void printGrayCode(List<Integer> grayCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < grayCode.size(); i++) {
            sb.append(grayCode.get(i)).append(",");
        }
        sb.deleteCharAt(sb.length()-1); // delete the last ","
        sb.append("]");
        System.out.println(sb.toString());
    }
}
