class Solution {
    public int[] productExceptSelf(int[] nums) {
        System.out.println("starting");
        HashMap<Integer, Integer> allNums = new HashMap<Integer, Integer>();
        for (int i : nums) 
            allNums.put(i, allNums.getOrDefault(i, 0) + 1);
        
        int [] product = new int[nums.length];

        System.out.println(allNums);

        for (int i = 0; i < product.length; i++) {
            int prodVal = 1;
            for (Integer key : allNums.keySet()) {
                if (key == nums[i]) {
                    System.out.println("equal!");
                    for (int j = 0; j < allNums.get(key) - 1; j++)
                        prodVal *= key;
                } else {
                    System.out.println("not equal!");
                    for (int j = 0; j < allNums.get(key); j++)
                        prodVal *= key;
                }
            }
            product[i] = prodVal;
            }

        return product;
    }
}
  
