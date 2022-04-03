class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        n=len(nums)
        memo = [[0 for x in range(m)] for y in range(n)]
        i2jSum = [[0 for x in range(n)] for y in range(n)]
        #initialize sum memory, which is the sum from ith index to jth index in nums
        for x in range(n):
            if x == 0:
                i2jSum[0][0] = nums[0]
                for y in range(1,n):
                    i2jSum[x][y] = i2jSum[x][y-1] + nums[y]
            else:
                for y in range(n):
                    if y >= x:
                        i2jSum[x][y] = i2jSum[x-1][y] - nums[x-1]
        
        #use dp to find minmium max that:
        #try every possible array from start to n-m
        def dp_find_min_largest_split_sum(start: int, m: int) -> int:
            #print(start, m)
            #m==1 is base case, means we don't divide anymore
            #return the sum of rest since we only have 1 array
            if m == 1:
                return i2jSum[start][n-1]
            
            res = float('inf')
            for i in range(start, n-m+1):
                #print("i is {}".format(i))
                if memo[i+1][m-2] != 0:
                    res = min(res, max(i2jSum[start][i], memo[i+1][m-2]))
                else:
                    memo[i+1][m-2]= dp_find_min_largest_split_sum(i+1, m-1)
                    res = min(res, max(i2jSum[start][i], memo[i+1][m-2]))
            #print(res)
            memo[start][m-1] = res
            return res
                    
        return dp_find_min_largest_split_sum(0, m)
                
        