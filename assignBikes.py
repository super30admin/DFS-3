from sortedcontainers import SortedDict
class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        distance = SortedDict()
        for i in range(len(workers)):
            for j in range(len(bikes)):
                if self.findDistance(workers[i], bikes[j]) not in distance:
                    distance[self.findDistance(workers[i], bikes[j])] = []
                
                distance[self.findDistance(workers[i], bikes[j])].append([i,j])
        
        values = (list(distance.keys()))
        
        workerArray = [False]*len(workers)
        bikesArray = [False]*len(bikes)
        count = 0     
        output = [-1]*len(workers)
        for value in values:
            for worker,bike in distance[value]:
                if workerArray[worker]==False and bikesArray[bike]==False: 
                    workerArray[worker] = True
                    bikesArray[bike] = True
                    output[worker] = bike
                    count+=1
                if count == len(workers):
                    return output
        return output  
    def findDistance(self,x,y):
        return abs(x[0]-y[0]) + abs(x[1]-y[1])
Time: O(Number of Worker * Number Of bikes + NlognN)
Space: O(N*M)
    
    
