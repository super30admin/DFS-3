def confusingNumberII(self, N: int) -> int:
        
        dict = {'0':'0','1':'1','6':'9','8':'8','9':'6'}
        count = 0
        for i in range(N+1):
            res =''            
            string = str(i)  
            j = len(string)-1
            while j!=-1:
                if string[j] in dict:
                    res += dict[string[j]]
                    j-=1
                else:
                    res = 'None'
                    break
            if res != string and res != 'None':
                count+=1
            
        return count
        
        
        #getting TLE for now. o(n^2). Will implement optimal solution after class
            
