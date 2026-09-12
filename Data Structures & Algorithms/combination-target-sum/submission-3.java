class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();

        backtracking(res, sol, nums, target, 0, 0);

        return res;
        
    }

    private void backtracking(List<List<Integer>> res, List<Integer> sol, int[] nums, int target, int i, int sum) {
        if (sum == target) { //success
            res.add(new ArrayList<>(sol));
            return;
        }
        if (i == nums.length || sum > target) //auto fail
            return; 
        
        //still using num
        sol.add(nums[i]);
        sum += nums[i];
        backtracking(res, sol, nums, target, i, sum);
        sum -= nums[i];
        sol.remove(sol.size() - 1);

        //not using num
        backtracking(res, sol, nums, target, i + 1, sum);
        

    }
}
