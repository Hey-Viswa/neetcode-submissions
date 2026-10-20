class Solution {
     public int[] topKFrequent(int[] nums, int k) {
            // 1. Count frequencies of each number
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // 2. Bucket array where index = frequency (max frequency is nums.length)
            List<Integer>[] buckets = new List[nums.length + 1];
            for (int key : countMap.keySet()) {
                int freq = countMap.get(key);
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(key);
            }

            // 3. Pull the top K elements starting from the highest frequency
            int[] result = new int[k];
            int index = 0;
            for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
                if (buckets[i] != null) {
                    for (int num : buckets[i]) {
                        result[index++] = num;
                        if (index == k) {
                            break;
                        }
                    }
                }
            }

            return result;
        }
}
