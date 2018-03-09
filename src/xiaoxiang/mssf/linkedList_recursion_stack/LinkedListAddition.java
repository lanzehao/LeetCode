package xiaoxiang.mssf.linkedList_recursion_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanzehao on 2018/3/6.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/6 10:32
 */
public class LinkedListAddition {

    public ListNode linkedListAdd(ListNode head1, ListNode head2){
        int carry = 0;
        ListNode dummyHead = new ListNode(0),
                last = dummyHead, p = head1, q = head2;
        while(p != null || q != null){
            int sum = ((p == null ? 0 : p.val) + (q == null ? 0 : q.val)) + carry;
            carry = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;

            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }
        if (carry > 0) {
            last.next = new ListNode(carry);
        }
        return  dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        LinkedListAddition l = new LinkedListAddition();
        ListNode head1 = l.num2NodeList(342);
        ListNode head2 = l.num2NodeList(465);
        ListNode node = l.linkedListAdd(head1, head2);
        System.out.println(node.toString());
        System.out.println(l.nodeList2Int(node));
    }

    public ListNode num2NodeList(int num){
        List<ListNode> list = new ArrayList<>();
        int tens = 1;
        ListNode last = null;
        ListNode head = null;
        while(num / tens > 0){
            ListNode listNode = last == null ? new ListNode(num % (10 * tens)) : new ListNode(num % (10 * tens) / tens);
            if(last == null){
                head = listNode;
            }else{
                last.next = listNode;
            }
            last = listNode;
            list.add(listNode);
            tens *= 10;
        }
        System.out.println(head.toString());
        return head;
    }

    public int nodeList2Int(ListNode head){
        int tens = 1, sum = 0;
        ListNode listNode = head;
        while (listNode != null){
            sum += listNode.val * tens;
            listNode = listNode.next;
            tens *= 10;
        }
        return sum;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int value) {
            this.val = value;
            this.next = null;
        }

        @Override
        public String toString(){
            return this.next == null ? String.valueOf(this.val) : this.val + "->" + this.next.toString();
        }
    }
}
