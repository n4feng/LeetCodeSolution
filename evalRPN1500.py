class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            if tokens[i].isdigit() or tokens[i][1:].isdigit():
                if tokens[i][0] == '-':
                    stack.append(-int(tokens[i][1:]))
                else:
                    stack.append(int(tokens[i]))
            else:
                b = stack.pop()
                if tokens[i] == "+":
                    stack.append(stack.pop()+b)
                elif tokens[i] == "-":
                    stack.append(stack.pop()-b)
                elif tokens[i] == "*":
                    stack.append(stack.pop()*b)
                else:
                    stack.append(int(stack.pop()/b))
        return stack[0]
