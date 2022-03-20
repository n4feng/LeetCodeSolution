class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        stack = [0]
        score = 0
        for c in s:
            
            #e.g.
            # initial [0], it means if no bracket, _ will stand for 0 score
            # (()(()))
            # ( : [0,0]
            # ( : [0,0,0]
            # ) : [0,1] 1 is the score for bracker in index 1 and 2 since they closed
            # added into the credit of '(' in index 0
            # ( : [0,1,0]
            # ( : [0,1,0,0]
            # ) : [0,1,1] here 1,1 -> ()(()), since it has extra 0 
            # means there is still 1 bracket layer outset, so that is (()(()))
            # ) : [0,3] 3 = 1+1*2
            # ) : [6]
            if c == '(':
                # a new '(' means right now we only know there is 0 score
                # so we append 0 indicate it                
                stack.append(0)
            
            else:
                # once we find ')', we update the nearest score
                # if that score says 0 
                # means it is directly after a '(', we assign 1
                # if it is not 0, it will be the result of 
                # every thing within front bracket and itself
                # so we double it
                s = stack.pop()
                stack[-1] += max(2*s, 1)
        return stack.pop()
                
