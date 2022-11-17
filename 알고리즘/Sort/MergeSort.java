// 합병(병합) 정렬
// 분할 정복 기반 정렬 방식
// 시간복잡도 = O(nlogn)
// 안정 정렬 (중복값의 경우 입력순서를 유지하는 정렬)
// 제자리 정렬 X (추가 저장공간을 사용하는 정렬)

public class Solution {
    public int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // arr = {1, 2, 3, 4, 5} 배열인 경우
        // left = 0, mid = 2, right = 4
        // n1 = 3, n2 = 2
        // L = {1, 2, 3}
        // R = {4, 5}
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 두 개의 서브 배열 생성
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) { // 두 개의 서브 배열 중 하나가 전부 끝나기 전까지
            if(L[i] <= R[j]) { // 오름차순 정렬 (작은게 앞에)
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        // 나머지 처리 (두 개의 서브 배열 중 남아있는 배열)
        while(i < n1) {
            arr[k++] = L[i++];
        }
        while(j < n2) {
            arr[k++] = R[j++];
        }
    }
}
