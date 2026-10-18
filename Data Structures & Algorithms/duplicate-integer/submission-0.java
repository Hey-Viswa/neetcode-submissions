class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
       for (int currentNum: nums){
        if(seen.contains(currentNum)){
            return true;
        }
        seen.add(currentNum);
       }
       return false;
    }
}