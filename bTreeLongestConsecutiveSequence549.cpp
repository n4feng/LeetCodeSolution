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
    int longest = 0;
    int longestConsecutive(TreeNode* root) {
        dfsPath(root);
        return longest;
    }
    pair<int, int> dfsPath(TreeNode* root) {
        if(root == NULL) return {0,0};
        //increase path (from left to right)
        int inc = 1;
        //decrease path
        int dec = 1;
        if(root->left != NULL){
            auto leftLP = dfsPath(root->left);
            if(root->val - root->left->val == 1){
                inc = leftLP.first + 1;
            }
            else if(root->val - root->left->val ==-1){
                dec = leftLP.second +1;
            }
        }
        if(root->right != NULL){
            auto rightLP = dfsPath(root->right);
            if(root->val - root->right->val == 1){
                inc = inc >= rightLP.first + 1 ? inc : rightLP.first + 1;
            }
            else if(root->val - root->right->val ==-1){
                dec = dec >= rightLP.second + 1 ? dec : rightLP.second + 1;
            }
        }
        //one thing to notice, if on one side it is increase, than it can not be decrease
        //threrfore if you have inc > 1 and dec > 1, that means they are on 2 different side of root
        longest = longest >= inc + dec - 1? longest : inc + dec - 1;
        return {inc, dec};
    }
};
