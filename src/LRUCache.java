import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanzehao on 2018/3/1.
 * <p>
 * Description：146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 */
public class LRUCache {

    private Map<Integer, Node> map;

    private int capatity, count;

    private Node head,tail;

    public LRUCache(int capacity) {
        this.capatity = capacity;
        map  = new HashMap<Integer, Node>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            add2head(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            add2head(node);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            if(count < capatity){
                add2head(node);
                count++;
            }else{
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                add2head(node);
            }
        }

    }

    private void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void add2head(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}