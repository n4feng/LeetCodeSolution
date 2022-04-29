/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int lSize = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail1 = reverseList(l1);
        int list1Size = lSize;
        ListNode tail2 = reverseList(l2);
        int list2Size = lSize;
        if(list1Size < list2Size){
            //swap if list 2 size greater than list 1
            ListNode temp = tail1;
            tail1 = tail2;
            tail2 = temp;
        }
        
        boolean add = false;
        ListNode ptr1 = tail1, ptr2 = tail2;
        while(ptr1 != null){
            if(ptr2 != null){
                ptr1.val = ptr1.val + ptr2.val;
                if(add){
                    ptr1.val+=1;
                    add = false;
                }
                if(ptr1.val >= 10){
                    ptr1.val-=10;
                    add = true;
                }
                ptr2 = ptr2.next;
            }
            else{
                if(add){
                    ptr1.val+=1;
                    add = false;
                }
                if(ptr1.val >= 10){
                    ptr1.val-=10;
                    add = true;
                }
            }
            ptr1 = ptr1.next;
        }
        ListNode res = reverseList(tail1);
        if(add){
            ListNode last = new ListNode(1);
            last.next = res;
            res = last;
        }
        return res;
    }
    
    //reverse the linked list and return new head (original tail)
    //also count size just to save runtime
    //in actual work count should be a sepereate function
    public ListNode reverseList(ListNode l){
        ListNode tail = l, ptr = l.next;
        int size = 1;
        while(ptr != null){
            ptr = ptr.next;
            l.next.next = tail;
            tail = l.next;
            l.next = ptr;
            size++;
        }
        lSize = size;
        return tail;
    }
}
