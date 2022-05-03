class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        match = False
        s_len, p_len = len(s), len(p)
        s_idx = p_idx= 0
        star_idx = s_idx_tmp = -1
        while s_idx < s_len:
            if p_idx < p_len and p[p_idx] in ['?', s[s_idx]]:
                s_idx += 1
                p_idx += 1
            elif p_idx < p_len and p[p_idx] == '*':
                #* match no character and just go ahead
                s_idx_tmp = s_idx
                star_idx = p_idx
                p_idx += 1
            elif star_idx == -1:
                return False
            #back trace to last *, try let it match 1 char in s
            else:
                s_idx = s_idx_tmp+1
                p_idx = star_idx
                s_tmp_idx = s_idx
        return all(p[i] == '*' for i in range(p_idx, p_len))
