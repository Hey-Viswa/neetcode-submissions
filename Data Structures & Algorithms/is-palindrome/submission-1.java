class Solution {
    public boolean isPalindrome(String s) {
         int left = 0, right = s.length() - 1;

    while (left < right) {
        // 1. Skip non-alphanumeric
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        // 2. Compare lowercase
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        left++;
        right--;
    }

    return true;
    }
}
