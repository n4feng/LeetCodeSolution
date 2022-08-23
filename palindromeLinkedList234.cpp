/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
//99% double beat
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        int size = 0;
        ListNode* ptr = head;
        while(ptr){
            size+=1;
            ptr = ptr->next;
        }
        if(size == 1) return true;
        ptr = head;
        ListNode* right = ptr->next;
        ptr->next = NULL;
        for(int i = 0; i < size/2 - 1; i++){
            ListNode* temp = right->next;
            right->next = ptr;
            ptr = right;
            right = temp;
        }
        if(size%2 == 1)
            right = right->next;
        for(int i = 0; i < size/2; i++){
            if(right->val != ptr->val) return false;
            right = right->next;
            ptr = ptr->next;
        }
        return true;
    }
};
