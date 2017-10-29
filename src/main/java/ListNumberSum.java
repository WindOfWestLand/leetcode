/**
 * Created by 孙亮 on 2017/5/11.
 */
public class ListNumberSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode pointer = header;
        int jinwei = 0;
        while(l1 != null && l2 !=null ) {
            int sum = l1.val + l2.val + jinwei;
            int val = sum % 10;
            jinwei = sum / 10;

            ListNode tmp = new ListNode(val);
            pointer.next = tmp;
            pointer = tmp;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode other = l1;
        if(l1 != null) {
            other = l1;
        }
        if(l2 != null) {
            other = l2;
        }

        while(other != null) {
            int sum = other.val + jinwei;
            int val = sum % 10;
            jinwei = sum / 10;

            ListNode tmp = new ListNode(val);
            pointer.next = tmp;
            pointer = tmp;

            other = other.next;
        }

        if(jinwei != 0) {
            ListNode tmp = new ListNode(jinwei);
            pointer.next = tmp;
        }

        pointer = header.next;
        header = null;

        return pointer;
    }
}
