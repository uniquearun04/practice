/**
 * Created by achaudhary on 6/8/18.
 */
public class SumTwoNumersAsReversedListNodes {


    public static void main(String ...args) {
        SumTwoNumersAsReversedListNodes sumTwoNumersAsReversedListNodes = new SumTwoNumersAsReversedListNodes();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = sumTwoNumersAsReversedListNodes.addTwoNumbers(l1, l2);
        System.out.println("result: "+ listNode);
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            ListNode cn = this;
            while(cn != null) {
                sb.append(cn.val).append("->");
                cn = cn.next;
            }
            return sb.substring(0, sb.length() -2).toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode r = null;
        ListNode rh = r;
        int sum = 0;
        int rem = 0;
        while(l1 != null || l2 != null) {

            if(l1 != null) {
                sum = sum + l1.val + carry;
                l1 = l1.next;
                carry = 0;
            }
            if(l2 != null) {
                sum = sum + l2.val + carry;
                l2 = l2.next;
            }
            carry = sum / 10;
            rem = sum % 10;
            sum = 0;
            if(r == null) {
                r = new ListNode(rem);
                rh = r;
            } else {
                r.next = new ListNode(rem);
                r = r.next;
            }
        }
        if( carry > 0) {
            r.next = new ListNode(carry);
        }

        return rh;
    }
}
