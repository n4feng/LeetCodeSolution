class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        #when true goes right up, false goes left down
        dir = True
        m,n = len(mat), len(mat[0])
        i,j,count = 0,0,m*n
        res = []
        while(count>0):
            res.append(mat[i][j])
            count-=1
            if dir:
                if j == n-1:
                    i += 1
                    dir = False
                elif i == 0:
                    j += 1
                    dir = False
                else:
                    i -= 1
                    j += 1
            else:
                if i == m-1:
                    j += 1
                    dir = True
                elif j == 0:
                    i += 1
                    dir = True
                else:
                    i += 1
                    j -= 1
        return res
