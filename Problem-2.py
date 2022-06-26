class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if not matchsticks or len(matchsticks)<4:
            return False
        total=sum(matchsticks)
        if total%4!=0:
            return False
        
        square=[0 for i in range(4)]
        
        return self.backtracking(matchsticks,0,square,total//4)
    
    def backtracking(self,matchsticks, index, square, target):
        if index>len(matchsticks)-1:
            for s in square:
                if s!=target:
                    return False
            return True
                
        for i in range(4):
            if square[i] + matchsticks[index]>target:
                continue
            square[i]+=matchsticks[index]
        
            if self.backtracking(matchsticks,index+1, square, target):
                return True
            square[i]-=matchsticks[index]
        
        return False
            
        
        
        