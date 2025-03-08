#Time Complexity: O(NlogN), as we generate up to O(N) numbers and check each in O(logN) time.
#Space Complexity: O(N), due to the BFS queue storing up to O(N) numbers.
class Solution:
    def confusingNumberII(self, n: int) -> int:
        def isConfusing(num):
            temp = num
            result = 0
            while(num>0):
                lastdigit = num % 10
                #To check if the digit is invalid
                if(lastdigit not in hashmap):
                    return False
                #To form the new number
                result = result * 10 + hashmap[lastdigit]
                #To eliminate the last digit
                num = num//10
            #If the result is not equal to the actual number then the num has confusing number(result)
            return temp!=result
        hashmap = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        count = 0
        q = deque()
        q.append(0)
        while q:
            currNum = q.popleft()
            #If the currNum has a valid confusing number then add it to the count
            if(isConfusing(currNum)):
                count+=1
            #Generate the newNum
            for key in hashmap.keys():
                newNum = currNum * 10 + 
                #Edge case : 0 and if we reached n range then we should stop the loop and return count
                if(newNum!=0 and newNum<=n):
                    q.append(newNum)
        return count


        
        