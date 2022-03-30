class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m,n = len(matrix), len(matrix[0])
        left, right = 0, m*n-1
        while left <= right:
            pivot = left + (right - left) // 2
            if matrix[pivot//n][pivot%n] == target:
                return True
            elif matrix[pivot//n][pivot%n] < target:
                left = pivot+1
            else:
                right = pivot-1
        return False
