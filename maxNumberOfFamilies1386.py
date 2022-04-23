class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        #1 is avaliable, 0 is unavaliable

        seat = {}
        for r in reservedSeats:
            if r[1]>1 and r[1]<10:
                if r[0]-1 in seat:
                    seat[r[0]-1][r[1]-1] = 0
                else:
                    seat[r[0]-1] = {r[1]-1:0}
        #use minus because timelimit test case is mo
        res = 2*n
        for row in seat:
            flag = 0
            flag = flag + (1 in seat[row] or 2 in seat[row])
            flag = flag + ((3 in seat[row] or 4 in seat[row])<<1)
            flag = flag + ((5 in seat[row] or 6 in seat[row])<<2)
            flag = flag + ((7 in seat[row] or 8 in seat[row])<<3)
            if (flag >=0 and flag < 5) or flag == 8 or flag == 9 or flag == 12:
                res-=1
            else:
                res-=2
        return res
