class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        light, heavy = 0, len(people)-1
        res = 0
        while(light <= heavy):
            if people[light] + people[heavy] <= limit:
                light+=1
            res+=1
            heavy-=1
        return res
