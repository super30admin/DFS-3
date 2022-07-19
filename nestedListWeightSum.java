/**
 * Problem: https://leetcode.com/problems/nested-list-weight-sum/
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Approach 1: DFS
class Solution {
    int result;
    public int depthSum(List<NestedInteger> nestedList) {
        result = 0;
        depthSum(nestedList, 1);
        return result;
    }
    
    private void depthSum(List<NestedInteger> nestedList, int depth) {
        
        for (int i = 0; i < nestedList.size(); ++i) {
            if (nestedList.get(i).isInteger()) {
                result = result + (nestedList.get(i).getInteger() * depth);
            } else {
                depthSum(nestedList.get(i).getList(), depth + 1);
            }
        }
    }
}

// Approach 2: BFS
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>();
        
        for (NestedInteger el : nestedList) {
            queue.add(el);
        }
        
        int depth = 1;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    sum = sum + cur.getInteger() * depth;
                } else {
                    for (NestedInteger el : cur.getList()) {
                        queue.add(el);
                    }
                }
            }
            ++depth;
        }
        
        return sum;
    }
}