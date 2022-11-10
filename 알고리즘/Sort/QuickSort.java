// QuickSort -> Divide & Conquer (분할 정복) 기반 정렬
// 1. 배열 중 하나의 요소를 고른다 (이를 Pivot이라 한다)
// 2. Pivot을 기준으로 Pivot보다 작은 요소는 Pivot보다 왼쪽에, 더 큰 요소는 오른쪽으로 옮긴다
// 3. Pivot을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
// 3-1. Pivot 왼쪽/오른쪽 리스트도 각각 Pivot을 잡고 쪼갠 다음 정렬 ---> 부분 배열이 더이상 분할이 불가능 할 때까지 반복

// 재귀적 정렬 - Stack 사용. 
// Pivot 값을 어떻게 잡느냐에 따라 시간 복잡도 평균 O(nlogn) ~ 최악 O(n^2)

public class Solution { 
  
	public int[] quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		int pivot = partition(arr, left, right); // 피봇 기준으로 작은 값은 왼쪽에 / 큰 값은 오른쪽에 배치 (정렬 상태는 아님)
		quickSort(arr, left, pivot - 1); // 피봇보다 작은 왼쪽 배열 분할 정렬
		quickSort(arr, pivot + 1, right); // 피봇보다 큰 오른쪽 배열 분할 정렬
	}

	private int partition(int[] arr, int left, int right) {
		int low = left;
		int high = right;
		int pivot = arr[left]; // 가장 왼쪽에 있는 원소를 pivot으로 잡는 방법 (가장 단순)

    // Low >= High인 경우 포인터가 중간 Pivot을 이미 지났다는 뜻이기 때문에 더이상 정렬하면 안됨
		while(low < high) {
			while(arr[high] > pivot && low < high) {
				high--; // Pivot보다 작은 값 발견할 때까지 아래로
			}
			while(arr[low] <= pivot && low < high) {
				low++; // Pivot과 같거나 큰 값 발견할 때까지 위로
			}
			swap(arr, low, high); // 둘을 Swap 
		}
		swap(arr, left, low);
		return low;
	}

	private void swap(int[] arr, int num1, int num2) {
		int tmp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = tmp;
	}
}
