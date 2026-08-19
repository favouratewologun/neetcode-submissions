class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r+1};
            } else if (sum < target) {
                l++;
            } else { //sum > target
                r--;
            }
        }

        return new int[2];

        // [1, 2, 3, 4] target =3
        //start on oppo ends, if smaller than target move l up, if bigger move r down
        
        
    }
}
