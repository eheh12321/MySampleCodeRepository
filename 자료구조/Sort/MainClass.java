package CodingTestMemory.자료구조.Sort;

import java.io.*;

public class MainClass {

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void bubbleSort(int[] arr) { // O(n^2)
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectedSort(int[] arr) { // O(n^2)
        for(int i = 0; i < arr.length - 1; i++) {
            int minidx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minidx]) {
                    minidx = j;
                }
            }
            swap(arr, i, minidx);
        }
    }

    public static void insertionSort(int[] arr) { // O(n^2)
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int[] tmp;

    public static void merge_sort(int[] arr) {
        tmp = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);
        tmp = null;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int idx = left;
        while(p1 <= mid && p2 <= right) {
            if(arr[p1] <= arr[p2]) {
                tmp[idx++] = arr[p1++];
            } else {
                tmp[idx++] = arr[p2++];
            }
        }
        while(p1 <= mid) {
            tmp[idx++] = arr[p1++];
        }
        while(p2 <= right) {
            tmp[idx++] = arr[p2++];
        }
        for(int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left]; // 제일 왼쪽 원소를 pivot으로 잡는 방법(제일 간단)

        while(lo < hi) {
            while(arr[hi] > pivot && lo < hi) {
                hi--;
            }
            while(arr[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(arr, lo, hi);
        }
        swap(arr, left, lo);
        return lo;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr);
        for(int e : arr) {
            bw.write(String.valueOf(e));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
