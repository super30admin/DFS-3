

#Time Complexity: O(5 ^#digits) #digits is len of range

#Space Complexity: O(#digits)) 

from collections import deque
class Solution:
    def confusingNumberII(self, n: int) -> int:
        if n<6:
            return 0
        self.result = 0
        self.hashmap = {}
        self.hashmap[0] = 0
        self.hashmap[1] = 1
        self.hashmap[6] = 9
        self.hashmap[8] = 8
        self.hashmap[9]=6
        
        self.bfs(n,0)
        return self.result
    
    def bfs(self,num,cur):
        #base
        queue = deque()
        queue.append(0)
        while(queue):
            for i in range(len(queue)):
                cur = queue.popleft()
                if cur <= num:
                    if self.isconfusing(cur):
                        self.result+=1
                    for key in self.hashmap.keys():
                        next_num = 10*cur+key
                        if next_num !=0 :
                            queue.append(next_num)


    def isconfusing(self,number):

        reverse = 0
        n = number
        while(n>0):

            reverse = reverse*10+self.hashmap[n%10]
            n = n//10

        return reverse!=number
        