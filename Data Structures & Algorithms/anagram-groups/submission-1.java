class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 1. Create the Map of buckets: Key is the sorted label, Value is the list of words
            Map<String, List<String>> map = new HashMap<>();

            // 2. Loop through every word in the input array
            for (String s : strs) {
                // Convert word to char array so Java can sort it
                char[] chars = s.toCharArray();
                Arrays.sort(chars);

                // This sorted string is our bucket label! (e.g. "aet")
                String key = new String(chars);

                // If this bucket doesn't exist yet, create an empty list for it
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }

                // Put the ORIGINAL word into the bucket
                map.get(key).add(s);
            }

            // 3. Return all the buckets
            return new ArrayList<>(map.values());
        }
    }