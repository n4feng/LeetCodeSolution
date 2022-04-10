class Solution:
    def calPoints(self, ops: List[str]) -> int:
        score = []
        currentSum = 0
        for i in ops:
            if i.lstrip('-').isnumeric():
                currentSum+=int(i)
                score.append(int(i))
            elif i == "+":
                pre2 = 0
                for j in range(2):
                    pre2+=int(score[-1-j])
                currentSum+=pre2
                score.append(pre2)
            elif i == "D":
                currentSum+=score[-1]*2
                score.append(score[-1]*2)
            elif i == "C":
                currentSum-=score.pop()
        return currentSum
