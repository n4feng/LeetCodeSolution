class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort()
        while len(stones) > 1:
            s1 = stones.pop()
            s2 = stones.pop()
            if s1 != s2:
                bisect.insort(stones, s1 - s2)
        return stones[0] if stones else 0
