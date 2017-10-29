import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 孙亮 on 2017/5/11.
 */
public class TestBinaryAdd {
    @Test
    public void testBinaryAdd() {
        BinaryAdd binaryAdd = new BinaryAdd();
        String result = binaryAdd.addBinary("11", "1");
        Assert.assertEquals("100", result);
    }
}
