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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* result = new ListNode(0);
        ListNode* iterator1;
        ListNode* iterator2;
        int adder = 0;
        iterator1 = l1->next;
        iterator2 = l2->next;
        result->val = (l1->val + l2->val)%10; //non empty
        (l1->val + l2->val >= 10)?adder = 1:adder = 0;
        ListNode* iteratorR = result;
        while(iterator1 != NULL || iterator2 != NULL){
            ListNode* temp = new ListNode(0);
            if(iterator1 != NULL){
                if(iterator2 != NULL){
                    temp->val = (iterator1->val + iterator2->val +adder)%10;
                    (iterator1->val + iterator2->val +adder >= 10)?adder = 1:adder = 0;
                    //cout<< iterator1->val << " + " << iterator2->val << " adder: " << adder << endl;
                }
                else{
                    temp->val = (iterator1->val +adder)%10;
                    adder = ((iterator1->val +adder)>=10) ? 1:0;
                }
            }
            else{
                temp->val = (iterator2->val + adder)%10; // can't be both null
                adder = ((iterator2->val +adder)>=10) ? 1:0;
            }
            if(iterator1 != NULL)
                iterator1 = iterator1->next;
            if(iterator2 != NULL)
                iterator2 = iterator2->next;
            iteratorR->next = temp;
            iteratorR = iteratorR->next;
        }
        if(adder){
            ListNode* temp = new ListNode(1);
            iteratorR->next = temp;
        }
        return result;
    }
};