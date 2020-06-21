package 面试题;

import java.util.*;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution3{
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        for(Node cur = head;cur != null;cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        //再遍历一次，找到结点间的对应关系
        for(Node cur = head;cur != null;cur = cur.next){
            Node newcur = map.get(cur);
            newcur.next = map.get(cur.next);
            newcur.random = map.get(cur.random);
        }
        return map.get(head);
    }
}