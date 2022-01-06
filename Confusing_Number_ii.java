class Solution{
  HashMap<Integer, Integer> map;
  int count;
  public int confusingNumberII(int N){
      map = new HashMap<>();
      map.put(0,0);
      map.put(1,1);
      map.put(6,9);
      map.put(8,8);
      map.put(9,6);
    
      dfs(N, 0);
      return count;
  }
  
  private void dfs(int N, long curr){
      if(curr > N || curr == 0) return;
      if(isValid(curr)) count++;
      
      for(int key; map.keySet()){
          long next = curr * 10 + key;
          dfs(N, next);
        
      }
  }
  
  private boolean isValid(long num){
      long original = num;
      int result = 0;
      
      while(num > 0){
          result = result * 10 + map.get((int)num % 10);
          num = num /10;
      }
      return original != result;
  }
}

//TC:O(n)
//SC: O(1);
