/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n || n < 1) return head;
        int pos = 1; 
        
        ListNode result = new ListNode(-100);
        result.next = head;
        ListNode cutfrom = result;
        ListNode ptr = head;
        
        while(true){            
            if(pos < m){
                cutfrom = cutfrom.next;
                ptr = ptr.next;
                System.out.println("current pos is " + pos);
            }
            else if(pos == m){
                ListNode newM = ptr;
                ListNode prePtr = ptr;
                ListNode postPtr = ptr.next; //this shold not be null since should be greater than n from previous condition check
                System.out.println("current pos is " + pos);
                while(true){
                    if(pos == n || postPtr == null){//just in case if m does not exist, flip everything after n
                        cutfrom.next = ptr;
                        newM.next = postPtr;
                        break;
                    }
                    else{
                        ptr = postPtr;
                        postPtr = postPtr.next;
                        System.out.println("reverse " + prePtr.val + " and " + ptr.val);
                        ptr.next = prePtr;//reverse the connection
                        prePtr = ptr;
                        pos++;
                    }
                }
            }
            else{
                break;
            }
            pos++;
        }
        return result.next;
    }
}