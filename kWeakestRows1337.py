class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        rowKeyBySoldier = {}
        soldierNbr = []
        for i, row in enumerate(mat):
            soldier = 0
            for col in row:
                if col == 1:
                    soldier+=1
            if soldier in rowKeyBySoldier:
                rowKeyBySoldier[soldier].append(i)
            else:
                rowKeyBySoldier[soldier] = [i]
                soldierNbr.append(soldier)
        
        soldierNbr.sort()
        res = []
        snIndex = 0
        while k > 0:
            snLen = len(rowKeyBySoldier[soldierNbr[snIndex]])
            if k > snLen:
                res+=rowKeyBySoldier[soldierNbr[snIndex]]
                k -= snLen
                snIndex+=1
            else:
                res+=rowKeyBySoldier[soldierNbr[snIndex]][:k]
                k = 0
        return res
