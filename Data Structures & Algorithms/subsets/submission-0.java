class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();

        List<Integer> sol = new ArrayList<>();

        backtrack(nums, 0, sol, res);

        List<List<Integer>> finalRes = new ArrayList<>(res);

        return finalRes;
        
        
    }

    public void backtrack(int[] nums, int i, List<Integer> sol, HashSet<List<Integer>> res ) {
        if (i == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }

        //don't add num
        backtrack(nums, i + 1, sol, res);

        //add num
        sol.add(nums[i]);
        backtrack(nums, i + 1, sol, res);
        sol.remove(sol.size() - 1);
    }
}
