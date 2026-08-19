

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> numsAndCounts = new HashMap <Integer, Integer>();
        int[] allCounts = new int[nums.length];
        int[] sortCounts = new int[k];
        int[] result = new int[k];

        for (int num : nums) 
            numsAndCounts.put(num, numsAndCounts.getOrDefault(num, 0) + 1);

        System.out.println("Hashmap created");

        int count = 0;
        for (Map.Entry<Integer, Integer> item : numsAndCounts.entrySet()) {
            int i = item.getKey();
            System.out.println("i is " + i);
            allCounts[count] = numsAndCounts.get(i);
            count++;
        }

        // for (int i = 0; i < numsAndCounts.size(); i++)
        //     allCounts[i] = numsAndCounts.get(i);

        System.out.println("all counts ");

        
        for (int i = 0; i < k; i++) {
            int max = allCounts[0];
            int max_ind = 0;
            for (int j = 0; j < allCounts.length; j++) {
                System.out.println("minding max");
                if (allCounts[j] > max) {
                    max = allCounts[j];
                    max_ind = j;
                }
            
            }
            allCounts[max_ind] = -20000;
            sortCounts[i] = max;
            System.out.println("max foiund");
        }

        HashSet<Integer> appeared = new HashSet<Integer>();
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> item: numsAndCounts.entrySet()) {
                int num = item.getKey();
                //deal with when same length
                if (numsAndCounts.get(num) == sortCounts[i] && !appeared.contains(num)) {
                    result[i] = num;
                    appeared.add(num);
                    sortCounts[i] = -1;
                }
                    
            }
        }

        return result;

        
    }
}
