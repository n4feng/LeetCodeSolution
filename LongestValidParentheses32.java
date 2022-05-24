class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        //a stack with a dummy header
        //rest elemts are the position of previous bracket
        Stack<Integer> stack = new Stack<>();
        //a dummy holder indicate last Parentheses end up at index -1
        
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                //close current bracket
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    ans = Math.max(ans, i-stack.peek());
                }
            }
        }
        return ans;
    }
}
