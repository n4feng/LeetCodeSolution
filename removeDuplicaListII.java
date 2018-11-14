/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Hashtable<Integer, ListNode> record = new Hashtable<Integer, ListNode>(); //key is int value, value is previous ptr to that value;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        ListNode ptr = head;
        int index = 0;
        while(ptr != null){
            if(!record.containsKey(ptr.val)){
                ListNode temp = new ListNode(-1);
                temp.next = pre;
                record.put(ptr.val, temp);
                //System.out.println(ptr.val + " has been put at position "+index);
                pre = pre.next;
            }
            else{
                pre.next = ptr.next;
                //System.out.println(ptr.val + " has been removed at position "+index);
                ListNode first = record.get(ptr.val);
                if(first.next.next != null){
                    if(first.next.next.val == ptr.val){
                        //System.out.println("first value is " + first.next.next.val);
                        if(first.next.next == pre){
                            pre = first.next;//put the prev to the right place if it will happen to be removed by next step
                        }
                        first.next.next = first.next.next.next; //remove the first item of this value if it is not being removed yet
                    }
                }
            }            
            ptr = ptr.next;
            index++;
        }
        return result.next;
    }
}