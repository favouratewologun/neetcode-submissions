class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //base case, if =, > or smth else just return
        //else add, dont add

        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> sol = new ArrayList<>();

        backtrack(nums, target, res, sol, 0, 0);

        return new ArrayList<>(res);
        
    }

    private void backtrack(int[] nums, int target, HashSet<List<Integer>> res, List<Integer> sol, int i, int sum) {
        if (i == nums.length || sum > target)
            return; //nothing more to do
        else if (sum == target) { //found a sol
            res.add(new ArrayList<>(sol));
            return;
        }
        
        //don't add the num
        backtrack(nums, target, res, sol, i + 1, sum);

        //add the num and move forward
        sol.add(nums[i]);
        sum += nums[i];
        backtrack(nums, target, res, sol, i + 1, sum);
        sum -= nums[i];
        sol.remove(sol.size() - 1);

        //add the num and stay
        sol.add(nums[i]);
        sum += nums[i];
        backtrack(nums, target, res, sol, i, sum);
        sum -= nums[i];
        sol.remove(sol.size() - 1);

    }
}
