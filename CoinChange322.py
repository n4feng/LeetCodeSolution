class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        coins.sort()
        mem = {}
        res = self.dpCoin(tuple(coins), amount, mem)
        
        return res if res < pow(10,5) else -1
    
    def dpCoin(self, coins, amount, mem):
        if amount in coins:
            return 1
        minCoin = pow(10,5)
        for c in coins:
            if c < amount:
                if(amount-c in mem):
                    minCoin = min(minCoin, mem[amount-c]+1)
                else:
                    minCoin = min(minCoin, self.dpCoin(coins, amount-c, mem)+1)
            else:
                break
        mem[amount] = minCoin
        return minCoin
