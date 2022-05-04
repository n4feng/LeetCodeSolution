#count case
#[[5,6], [4,6],[0,4], [0,5]]
#can't be done on the fly in nlogn time

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        meetingRooms = []
        res = 1
        defaultRoom = []
        
        meetingRooms.append(defaultRoom)
        for interval in intervals:
            find = False
            for room in meetingRooms:
                startAt = self.insertTo(room, interval, True)
                endAt = self.insertTo(room, interval, False)
                if endAt == startAt:
                    room.insert(startAt, interval)
                    find = True
                    break
            if not find:
                res+=1
                newRoom = [interval]
                meetingRooms.append(newRoom)
        return res
        
    def insertTo(self, intervals, interval, sortOn):
        def startOrEnd(i, sortOn):
            if sortOn:
                return i[0]
            else:
                return i[1]
        
        left, right = 0, len(intervals) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if startOrEnd(intervals[mid], not sortOn) == startOrEnd(interval, sortOn):
                if sortOn:
                    return mid+1
                else:
                    return mid
            elif startOrEnd(intervals[mid], not sortOn) < startOrEnd(interval, sortOn):
                left = mid + 1
            else:
                right = mid - 1
        return left

                
