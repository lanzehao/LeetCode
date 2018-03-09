package xiaoxiang.mssf.linkedList_recursion_stack;

/**
 * Created by lanzehao on 2018/3/8.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/8 16:12
 */
public class ReverseLinkedList {
    public ListNode doReverse(ListNode head, int from, int to){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < from - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;

        for(int i = from; i < to; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummyHead.next;
    }


    class ListNode {
        int val;
        ListNode next;
        public ListNode(int value){
            this.val = value;
        }
        @Override
        public String toString(){
            return (this.next != null) ? this.val + "->" + this.next: String.valueOf(this.val);
        }
    }

    public ListNode getNodeList(int[] arr){
        ListNode pummyHead = new ListNode(0), last = pummyHead;
        for (int i : arr) {
            last.next = new ListNode(i);
            last = last.next;
        }
        return pummyHead.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {64, 62, 58, 78, 24, 69, 0, 34, 67, 41};
        int[] arr = {5};
        ListNode head = r.getNodeList(arr);
        ListNode res = r.doReverse(head,1,1);
        System.out.println(res);
    }
}
