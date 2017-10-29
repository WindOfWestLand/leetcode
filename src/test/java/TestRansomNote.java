import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 孙亮 on 2017/5/11.
 */
public class TestRansomNote {
    @Test
    public void test() {
        RansomNote ransomNote = new RansomNote();
        Assert.assertEquals(true, ransomNote.canConstruct("aa", "aab"));
    }
}
