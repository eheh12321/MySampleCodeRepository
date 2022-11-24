// Radix Sort (계수 정렬)
// 가장 낮은 자릿수부터 비교하며 정렬하는 방법(LSD, Least-Significant-Digit) vs 큰 자릿수부터 비교하는 방법(Most-Significant-Digit)
// 주로 Radix Sort 하면 LSD를 의미함
// - 배열 원소 중 가장 큰 숫자의 자릿수를 계산하고 가장 작은 자릿수부터 가장 큰 자릿수까지 반복하며 Counting Sort를 반복하는 정렬
// - 시간 복잡도 = 무려 O(dN)
// - Stable Sort
// - 추가적인 메모리 공간이 필요
// - 문자열 / 정수에 대해서 정렬 가능 || 부동 소숫점과 같이 자릿수가 없는 것은 정렬할 수 없음
public class Solution {

    // 배열 내 최댓값 찾기
    private int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private void countSort(int[] arr, int exp) {
        int[] buffer = new int[arr.length];
        int[] count = new int[10];

        // 자릿수에 해당하는 count 증가
        for(int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 누적 합 계산 (0 ~ 9가 최대)
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Counting Sort
        // 뒤에서부터 도는 이유 = Stable Sort를 위해
        for(int i = arr.length - 1; i >= 0; i--) {
            buffer[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 옮겨담기
        for(int i = 0; i < arr.length; i++) {
            arr[i] = buffer[i];
        }
    }

    public int[] radixSort(int[] arr) {
        int max = getMax(arr);

        // 1의 자릿수부터 한자리씩 증가(*10)~~ m의 크기(자릿수)까지
        for(int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
        return arr;
    }
}
