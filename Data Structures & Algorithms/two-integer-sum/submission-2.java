class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> prevMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            int complement = target - currentNum;

            if(prevMap.containsKey(complement)){
                return new int[]{prevMap.get(complement),i };
            }
            prevMap.put(currentNum,i);
        }
        return new int[]{};
    }
}