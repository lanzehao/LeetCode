package xiaoxiang.mssf.linkedList_recursion_stack;

import java.util.Random;

/**
 * Created by lanzehao on 2018/3/9.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/9 10:58
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummyHead = new ListNode(0 == head.val ? -1 : 0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode curr = dummyHead.next;
        while(curr != null && curr.next != null){
            if(pre.val == curr.val || curr.val == curr.next.val){
                pre.next = curr.next;
            }
            pre = pre.next;
            curr = pre.next;
        }
        if(pre.val == curr.val){
            pre.next = curr.next;
        }

        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString(){
            return (this.next != null) ? this.val + "->" + this.next: String.valueOf(this.val);
        }
    }

    public ListNode getHead(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        return head;
    }

    public static void main(String[] args) {
//        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
//        ListNode head = r.getHead();
//        System.out.println(r.deleteDuplicates(head));
        Random random = new Random();
        int i = random.nextInt(1);
        System.out.println(i);
    }
}
