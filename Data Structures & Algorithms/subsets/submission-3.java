class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();

        ArrayList<Integer> sol = new ArrayList<>();

        backtracking(res, sol, 0, nums);

        List<List<Integer>> f = new ArrayList<>(res);

        return f;

    }

    private void backtracking(HashSet<ArrayList<Integer>> res, ArrayList<Integer> sol, int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }
            

        //add number and cont
        sol.add(nums[i]);
        backtracking(res, sol, i + 1, nums);
        //dont add and cont
        sol.remove(sol.size() - 1);
        backtracking(res, sol, i + 1, nums);

    }
}
