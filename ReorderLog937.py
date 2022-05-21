class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letterStart = -1;
        for i in range(len(logs)):
            if self.isDigit(logs[i]):
                if letterStart != -1:
                    logs[letterStart], logs[i] = logs[i], logs[letterStart]
                    letterStart += 1
            elif letterStart == -1 and self.isLetter(logs[i]):
                letterStart = i
        def get_key(log):
            _id, content = log.split(" ", maxsplit=1)
            return (content, _id)
        
        return logs if letterStart == -1 else sorted(logs[letterStart:],key=get_key)+logs[:letterStart]
            
    
    
    def isLetter(self, s:str) -> bool:
        slist = s.split()
        for i in range(1, len(slist)):
            if any(j.isdigit() for j in slist[i]):
                return False
        return True
    
    def isDigit(self, s:str) -> bool:
        slist = s.split()
        for i in range(1, len(slist)):
            if not slist[i].isnumeric():
                return False
        return True
