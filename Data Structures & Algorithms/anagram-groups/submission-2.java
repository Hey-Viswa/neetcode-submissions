class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String label = new String(arr);
            if (!map.containsKey(label)) {
                map.put(label, new ArrayList<>());
            }
            map.get(label).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
