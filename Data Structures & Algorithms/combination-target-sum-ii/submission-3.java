class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();

        Arrays.sort(candidates);

        backtracking(candidates, target, res, new ArrayList<Integer>(), 0, 0);

        return new ArrayList<>(res);

    }

    public void backtracking(int[] candidates, int target, HashSet<ArrayList<Integer>> res, ArrayList<Integer> sol, int i, int sum) {
        if (sum == target) { //good
            res.add(new ArrayList<>(sol));
            return;
        }

        if (sum > target || i >= candidates.length || candidates[i] > target || sum + candidates[i] > target) //fail
            return;

        sol.add(candidates[i]);
        sum += candidates[i];
        backtracking(candidates, target, res, sol, i + 1, sum);
        sum -= candidates[i];
        sol.remove(sol.size() - 1);

        int currVal = candidates[i];
        int count = 0;
        int ind = i;
        while (candidates[ind] == currVal) {
            count++;
            ind++;
            if (ind >= candidates.length)
                return;
        }
        
        backtracking(candidates, target, res, sol, i + count, sum);

    }
}
