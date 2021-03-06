package binary;

import binary.graycode.GrayCodeImpl;
import binary.graycode.GrayCodeMathSolution;
import binary.graycode.GrayCodeTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 孙亮 on 2017/5/5.
 */
public class TestGrayCode {
    @Test
    public void testGrayCode_1() {
        GrayCodeTest tester = new GrayCodeTest(new GrayCodeImpl());
        Assert.assertEquals(true, tester.checkGrayCode(3));
    }

    @Test
    public void testGrayCode_2() {
        GrayCodeTest tester = new GrayCodeTest(new GrayCodeMathSolution());
        Assert.assertEquals(true, tester.checkGrayCode(3));
    }
}
