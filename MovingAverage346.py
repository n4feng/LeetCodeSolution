class MovingAverage:
    
    def __init__(self, size: int):
        self.window = []
        self.size = size
        self.sum = 0

    def next(self, val: int) -> float:
        self.window.insert(0, val)
        self.sum+=val
        if len(self.window) > self.size:
            self.sum -= self.window.pop()
        return self.sum / len(self.window)


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)
