/**
 * Problem: https://leetcode.com/problems/nested-list-weight-sum-ii/
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
class Solution {
    class ResultTriplet {
        int maxDepth;
        int sum;
        int weightedProduct;
        
        public ResultTriplet(int m, int s, int p) {
            this.maxDepth = m;
            this.sum = s;
            this.weightedProduct = p;
        }
        
        public void print() {
            int ans = ((maxDepth + 1) * sum - weightedProduct);
            System.out.println("Result: " + ans + ", maxDepth: " + maxDepth + ", sum: " + sum + ", weightedProduct: " + weightedProduct);
        }
    }
    
    ResultTriplet res = null;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        res = new ResultTriplet(0, 0, 0);
        helper(nestedList, 1);
        // res.print();
        
        return ((res.maxDepth + 1) * res.sum - res.weightedProduct);
    }
    
    private void helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList.isEmpty()) {
            return;
        }
        
        res.maxDepth = Math.max(res.maxDepth, depth);
        
        
        for (int i = 0; i < nestedList.size(); ++i) {
            if (nestedList.get(i).isInteger()) {
                int val = nestedList.get(i).getInteger();
                res.sum += val;
                res.weightedProduct += (val * depth);
            } else {
                helper(nestedList.get(i).getList(), depth + 1);
            }
        }
        
    }
}