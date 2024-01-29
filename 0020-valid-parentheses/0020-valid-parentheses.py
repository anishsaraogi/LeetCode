class Solution:
    def isValid(self, s: str) -> bool:
        input = []
        for c in s:
            if input and ((c == ')' and input[-1] == '(') or (c == '}' and input[-1] == '{') or (c == ']' and input[-1] == '[')):
                input.pop()
            else:
                input.append(c)
        if len(input) == 0:
            return True
        else:
            return False