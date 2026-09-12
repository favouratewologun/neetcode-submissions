class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();

        HashSet<Integer> used = new HashSet<>();

        backtracking(res, sol, nums, used);

        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> sol, int[] nums, HashSet<Integer> used) {
        if (sol.size() == nums.length) {//done perm 
            res.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < nums.length; i++) { //each of the options
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                sol.add(nums[i]);
                backtracking(res, sol, nums, used);
                used.remove(nums[i]);
                sol.remove(sol.size() - 1);
            }
        }

        return;

    }
}
