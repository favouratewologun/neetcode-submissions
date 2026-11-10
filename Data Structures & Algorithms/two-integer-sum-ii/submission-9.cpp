class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int l = 0;
        int r = numbers.size() - 1;

        while (l < r) {
            int val = numbers[l] + numbers[r];
            if (val < target)
                l++;
            else if (val > target)
                r--;
            else {
                vector<int> res = {l + 1, r + 1};
                return res;

            }
        }

        vector<int> res = {0};
        return res;

        
    }
};
