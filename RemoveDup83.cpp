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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* ptr = head;
        if(head == NULL) return ptr;
        //int cval = ptr->val;
        
        while(ptr->next != NULL){
            if(ptr->next->val == ptr->val){
                ptr->next = ptr->next->next;
            }
            else if(ptr->next != NULL)
                ptr = ptr->next;
        }
        return dummy->next;
    }
};