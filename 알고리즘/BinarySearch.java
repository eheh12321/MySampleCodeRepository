// https://www.baeldung.com/java-binary-search

public class Solution {
  
    private int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            // int mid = (low + high) / 2
            int mid = low + ((high - low) / 2); // Overflow 방지
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
