package CodingTestMemory.BJ.Silv4.P10828;

import java.io.*;
import java.util.Stack;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        int n;
        String[] op;
        for(int t=0; t<T; t++) {
            op = br.readLine().split(" ");
            switch (op[0]) {
                case "push":
                    stack.push(Integer.parseInt(op[1]));
                    break;
                case "top":
                    if(stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(stack.peek()) + "\n");
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()) + "\n");
                    break;
                case "empty":
                    if(stack.empty()) { // 비어있으면 true
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "pop":
                    if(stack.empty()) { // 비어있으면
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(stack.pop()) + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
