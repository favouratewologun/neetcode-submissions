class Solution {
    public boolean hasDuplicate(int[] nums) {
        java.util.HashSet<Integer> unique = new java.util.HashSet<Integer>();

        for (int number : nums) {
            unique.add(number);
        }

        return !(unique.size() == nums.length);

        
 
    }
}
