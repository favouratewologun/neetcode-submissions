class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();

        backtracking(nums, res, sol, 0);

        return res;
        
    }

    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> sol, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }

        //add the item
        sol.add(nums[i]);
        backtracking(nums, res, sol, i + 1);
        sol.remove(sol.size() - 1);

        //dont add
        backtracking(nums, res, sol, i + 1);

    }
}
