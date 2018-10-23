/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode *result = head;
        if(head == NULL || head->next == NULL)
            return result;
        ListNode *ptr = head;
        ListNode *holder = head;
        ListNode *preTail = head;
        while(ptr != NULL){
            if(ptr->next == NULL)
                return result;
            ptr = ptr->next;
            holder->next = ptr->next;
            ptr->next = holder;
            if(holder == result)
                //to switch result to new header
                result = ptr;
            else{
                preTail->next = ptr;
                //since when next switch, the front one will become back one
                preTail = holder;
            }
                
            //restore both ptr and holder to the head of next pair
            ptr = holder->next;
            holder = holder->next;
        }
        return result;
    }
};