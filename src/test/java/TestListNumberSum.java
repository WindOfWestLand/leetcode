import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 孙亮 on 2017/5/11.
 */
public class TestListNumberSum {
    @Test
    public void test() {
        ListNumberSum lns = new ListNumberSum();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(5);

        ListNode node = lns.addTwoNumbers(l1, l2);

        Assert.assertEquals(node.val, 0);
        node = node.next;
        Assert.assertEquals(node.val, 0);
        node = node.next;
        Assert.assertEquals(node.val, 1);
        node = node.next;
        Assert.assertEquals(true, node == null);
    }
}
