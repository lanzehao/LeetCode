package xiaoxiang.mssf.linkedList_recursion_stack;


/**
 * Created by lanzehao on 2018/3/9.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/9 14:50
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode p = dummy1, q = dummy2, c = head;
        while(c != null){
            if(c.val < x){
                p.next = c;
                p = p.next;
            }else{
                q.next = c;
                q = q.next;
            }
            c = c.next;
        }
        q.next = null;
        p.next = dummy2.next;
        return dummy1.next;
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
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        return head;
    }

    public static void main(String[] args) {
        PartitionList r = new PartitionList();
        ListNode head = r.getHead();
        System.out.println(r.partition(head,0));
    }
}
