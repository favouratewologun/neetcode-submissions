class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<Integer>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, res, sol, used);

        return res;
        
        //back tracking for if assign a number to it or not? 
        //back tracking the int we're on, the number we're on,
        //then if empty, remove number

        //go through each, either add the index we're on now (remove it), or move it to the back

    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> sol, boolean[] used) {
        if (sol.size() == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == false) { 
                //add the num
                sol.add(nums[i]);
                used[i] = true;
                backtrack(nums, res, sol, used);
                used[i] = false;
                sol.remove(sol.size() - 1);

            }

        }

                  

        

    }

    //assign next number to curr index, or continue

}
