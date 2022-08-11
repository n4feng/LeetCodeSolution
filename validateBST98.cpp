/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include <limits.h>
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return isInRange(root, nullptr, nullptr);
    }
    
    bool isInRange(TreeNode* root, TreeNode* low, TreeNode* up){
        if(root == nullptr) return true;
        else if((low != nullptr && root->val <= low->val) || 
                (up != nullptr && root->val >= up->val)) return false;
        
        return isInRange(root->left, low, root) && isInRange(root->right, root, up);
    }
};
