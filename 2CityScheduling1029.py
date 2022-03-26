class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        #sort by the cost of sending person to A
        #intead of B, how many will save
        #those save most goes to A, Rest goes to B
        #P.S. use x[1]-x[0] and send those to B
        #will be exactly same on opposite direction
        costs.sort(key = lambda x : x[0] - x[1])
        res = 0
        n = len(costs) // 2
        for i in range(n):
            res += costs[i][0] + costs[i+n][1]
        return res
