/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode cur = root;
        while(cur != null){//duplicated link, but make sure the previous levels are all connected
            if(cur.left != null){
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }
            
            if(cur.right != null){
                cur.right.next = getNext(cur);
            }
            
            cur = cur.next;
        }
        
        connect(root.left);
        connect(root.right);
    }
    
    private TreeLinkNode getNext(TreeLinkNode root){
        TreeLinkNode next = root.next;
        
        while(next != null){//check all the avaliable place to see if there is a node to be connect
            if(next.left != null) return next.left;
            if(next.right != null) return next.right;
            
            next = next.next;
        }
        
        return null;
    }
    
    
}