"""
# Definition for an Interval.
class Interval:
    def __init__(self, start: int = None, end: int = None):
        self.start = start
        self.end = end
"""

class Solution:
    def findInsertPlace(self, schedule: '[[Interval]]', interval: '[Interval]') -> int:
        left, right = 0, len(schedule)-1
        if right == -1: return 0
        while left <= right:
            mid = left + (right - left) // 2
            if self.wrapInterval(schedule[mid]) == self.wrapInterval(interval):
                return mid
            elif self.wrapInterval(schedule[mid]) < self.wrapInterval(interval):
                left = mid + 1
            else:
                right = mid - 1
        return left
    
    def wrapInterval(self, interval):
        return interval.start * pow(10,8) + interval.end
    
    def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
        if len(schedule) < 2 and len(schedule[0]) < 2: 
            return []
        intervalsAll = []
        for intervals in schedule:
            for i in intervals:
                ithPlace = self.findInsertPlace(intervalsAll, i)
                intervalsAll.insert(ithPlace, i)
        #iInfo = ""
        #for i in intervalsAll:
        #    iInfo += "[{}-{}],".format(i.start, i.end)
        #print(iInfo)
        occupied = []
        for interval in intervalsAll:
            i = self.findInsertPlace(occupied, interval)
            occupied.insert(i, interval)
            if i > 0:
                ptr = i - 1
                while ptr >= 0 and occupied[ptr].start >= interval.start:
                    del occupied[ptr]
                    ptr -= 1
                if ptr >= 0:
                    if occupied[ptr].end >= interval.start:
                        interval.end = max(occupied[ptr].end, interval.end)
                        interval.start = occupied[ptr].start
                        del occupied[ptr]
            if i < len(occupied)-1:
                ptr = i + 1
                while ptr < len(occupied) and occupied[ptr].end <= interval.end:
                    del occupied[ptr]
                if ptr < len(occupied):
                    if occupied[ptr].start <= interval.end:
                        interval.start = min(occupied[ptr].start, interval.start)
                        interval.end = occupied[ptr].end
                        del occupied[ptr]
            #debugInfo = ""
            #for o in occupied:
            #    debugInfo += "[{}-{}],".format(o.start, o.end)
            #print(debugInfo)
        if len(occupied) < 2: 
            return []
        res = []
        pre, ptr = 0, 1
        while ptr < len(occupied):
            if occupied[pre].end < occupied[ptr].start:
                res.append(Interval(occupied[pre].end, occupied[ptr].start))
            ptr+=1
            pre+=1
        return res
                
