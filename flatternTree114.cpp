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
class Solution {
public:
    void flatten(TreeNode* root) {
        move(root);
    }
    
    //flatten current node, return last element of flattened sub-tree
    TreeNode* move(TreeNode* root){
        if (!root) return NULL;
        TreeNode* right = root->right;
        if(root->left){
            root->right = root->left;
            root->left = NULL;
            TreeNode* last = move(root->right);
            last->right = right;
        }
        if(root->right)
            return move(root->right);
        else
            return root;
    }
};
