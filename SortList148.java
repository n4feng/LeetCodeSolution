/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //put all node into array, sort in arry and rebuild the list
        ListNode ptr = head;
        List<Integer> temp = new ArrayList<>();
        while(ptr != null){
            if(temp.size() == 0){
                temp.add(ptr.val);
            }
            else if(temp.size() == 1){
                if(ptr.val >= temp.get(0))
                    temp.add(ptr.val);             
                else
                    temp.add(0, ptr.val);
            }
            else{
                binaryInsert(temp, ptr.val, 0, temp.size()-1);
            }
            ptr = ptr.next;
        }
        ListNode resultHead = new ListNode(100);//whatever
        ptr = resultHead;
        for(int i:temp){
            ListNode tempPtr = new ListNode(i);
            ptr.next = tempPtr;
            ptr = ptr.next;
        }
        return resultHead.next;
    }
    private void binaryInsert(List<Integer> temp, int val, int lower, int upper){
        if(upper - lower >= 2){
            int mid = (upper - lower)/2 + lower;
            if(temp.get(mid) == val){
                temp.add(mid, val);
                /*for(int i:temp){
                    System.out.print(i + "-");
                }
                System.out.println();*/
            }
                
            else if(temp.get(mid) > val){
                //System.out.println("call insert for value " + val + " at mid: " + mid);
                binaryInsert(temp, val, lower, mid);
            }
            else{
                binaryInsert(temp, val, mid, upper);
            }
        }
        else{
            if(temp.get(lower) > val)
                temp.add(lower, val);
            else if(temp.get(upper) < val){
                
                if(upper == temp.size())
                    temp.add(val);
                else
                    temp.add(upper+1, val);
            }
            else{
                //System.out.println("add value " + val + " at upper: " + upper);
                temp.add(upper,val);
            }
                
            /*for(int i:temp){
                System.out.print(i + "-");
            }
            System.out.println();*/
        }

        
    }
}