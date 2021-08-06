package CodingTestMemory.BJ.Sliv3.P11399;

import java.io.*;
import java.util.Arrays;

public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int prev = arr[0], sum = arr[0];
        for(int i = 1; i < N; i++) {
            prev = (arr[i] + prev);
            sum += prev;
        }
        System.out.println(sum);
    }
}
