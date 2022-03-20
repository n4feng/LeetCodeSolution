class Solution:
    def removeDuplicateLetters(self, s) -> int:

        stack = []

        # this lets us keep track of what's in our solution in O(1) time
        seen = set()

        # this will let us know if there are no more instances of s[c] left in s
        # by comparing current position i and last seen postion s[c]
        last_occurrence = {c: i for i, c in enumerate(s)}


        for i, c in enumerate(s):

            # we can only try to add c if it's not already in our solution
            # this is to maintain only one of each character
            if c not in seen:
                # if the last letter in our solution:
                #    1. exists
                #    2. is greater than c so removing it will make the string smaller
                #       we maintain the lexicographical if applicable (judge by rule3)
                #       in stack every (unique) character behind is greater than front
                #    3. it's not the last occurrence
                # we remove it from the solution to keep the solution optimal
                # we assume the last one in the stack is the smallest character
                # in the series we could manage
                while stack and c < stack[-1] and i < last_occurrence[stack[-1]]:
                    seen.discard(stack.pop())
                seen.add(c)
                stack.append(c)
        return ''.join(stack)
