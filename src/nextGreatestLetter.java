public class nextGreatestLetter {
    //solution 1 brute force
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
    //solution 2 binary search
    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return letters[right % letters.length];
    }

}
