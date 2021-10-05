#TIme:O(5^N)
#Space:O(len(n))
class Solution:
    def confusingNumberII(self, n: int) -> int:
        
        self.conf_numbers = {0:0,1:1,6:9,8:8,9:6}
        self.count=0
        self.len_n = len(str(n))
        
        
        
        
        def dfs(num):
            if self.len_n<len(num):
                return
            if int("".join(str(i) for i in num))>n:
                return
            if reverse_check(num):
                self.count+=1
            
            for number in self.conf_numbers:
                num.append(number)
                dfs(num)
                num.pop()
        
        def reverse_check(num):
            reverse_num = []
            for val in num:
                reverse_num.append(self.conf_numbers[val])
            if num == reverse_num[::-1]:
                return False
            return True
        
        for number,conf_number in self.conf_numbers.items():
            if number!=0:
                num = [number]
                dfs(num)
                num.pop()
        
        return self.count