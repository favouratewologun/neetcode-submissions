class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();

        for (int ind = 0; ind < nums.length; ind ++) {
            if (nums[ind] > 0)
                break; 
            sol = twoSum(ind, 0-nums[ind], nums);

            if (sol.size() > 0) {
                for (List<Integer> s : sol)
                    res.add(s);
            }
               


        }

        List<List<Integer>> finalRes = new ArrayList<>(res);

        return finalRes;
        //now sorted from smallest to biggest;
        //for every num, do a two sum 2 on it

        

        
    }

    public List<List<Integer>> twoSum(int ind, int target, int[] nums) {
        
        int l = ind + 1;
        int r = nums.length - 1;
        List<List<Integer>> sol = new ArrayList<>();

        while (l < r) {
           

            int val = nums[l] + nums[r];
            if (val < target)
                l++;
            else if (val > target)
                r--;
            else {
                List<Integer> aSol = Arrays.asList(nums[l], nums[ind], nums[r]);
                sol.add(aSol);
                l++;
                r--;
            }
            
               

        }

        

        return sol;

        // else
        //     return Arrays.asList(nums[l], nums[r], nums[ind]);

    }

   
}
