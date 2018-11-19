class Solution {
    public int numTrees(int n) {
        //no.Tree(n) = sum(allpossible(givenRoot, n))
        int[] noTree = new int[n+1];
        //if have no or 1 element, the tree only have one format
        noTree[0] = 1;
        noTree[1] = 1;
        //mathmatical deduction, i means n at that time
        for(int i = 2; i <= n; i++){
            //for any given number, the tree is sum of left possible times right possible
            //of all its possible roots
            for(int givenRoot = 1; givenRoot <= i; givenRoot++){
                noTree[i] += noTree[givenRoot - 1]*noTree[i - givenRoot];
            }
        }
        return noTree[n];
    }
    
    
}