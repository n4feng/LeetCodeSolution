/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode ptr = head;
        int size = 1;
        while(ptr.next != null){
            ptr = ptr.next;
            size++;
        }
        if(k%size == 0){
            ptr = head;
            return ptr;
        }
        int pos = size - (k%size);
        
        ListNode newHead = head;
        ListNode pre = null;
        for(int i = 0; i < pos; i++){
            pre = newHead;
            newHead = newHead.next;
        }
        if(pre != null) pre.next = null;
        ptr.next = head;
        return newHead;
    }
}