/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int listsSize = lists.length;
        if(listsSize == 0) return null;
        else if(listsSize == 1) return lists[0];
        return mergeInRange(lists, 0, listsSize-1);
    }
    
    private ListNode mergeInRange(ListNode[] lists, int start, int end){
        if(end - start == 1) return mergeTwoList(lists[start],lists[end]);
        else if(end == start) return lists[start];
        else return mergeTwoList(mergeInRange(lists,start,start+(end-start)/2),mergeInRange(lists,start+(end-start)/2+1,end));
    }
    
    private ListNode mergeTwoList(ListNode ll, ListNode lr){
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        ListNode lptr = ll;
        ListNode rptr = lr;
        while(lptr != null || rptr != null){
            if(lptr != null && rptr != null){
                if(lptr.val > rptr.val){
                    ptr.next = rptr;
                    ptr = ptr.next;
                    rptr = rptr.next;
                }
                else{
                    ptr.next = lptr;
                    ptr = ptr.next;
                    lptr = lptr.next;
                }
            }
            else if(lptr == null){
                ptr.next = rptr;
                rptr = null;
            }
            else if(rptr == null){
                ptr.next = lptr;
                lptr = null;
            }
        }
        return dummy.next;
    }
}