class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        #given a number, check if it is possible to rotate to
        def check(x):
            topSteps = 0
            botSteps = 0
            for i, top in enumerate(tops):
                #print(i, top)
                if top != x and bottoms[i] != x:
                    return -1
                elif top != x:
                    topSteps+=1
                elif bottoms[i] != x:
                    botSteps+=1
            return min(topSteps,botSteps)
            
        top1step = check(tops[0])
        if(top1step != -1 or tops[0]==bottoms[0]):
            return top1step
        
        else:
            return check(bottoms[0])
            
