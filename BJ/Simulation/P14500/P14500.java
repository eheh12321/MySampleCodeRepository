package CodingTestMemory.BJ.Simulation.P14500;

import java.io.*;
import java.util.StringTokenizer;

public class P14500 {

    static class Shape { // 폴리노미오 모양을 저장할 클래스
        int x, y;
        int[][] shape;
        Shape(int[][] arr) {
            this.shape = arr;
            this.y = arr.length;
            this.x = arr[0].length;
        }
    }

    static Shape[] shapes = new Shape[5];
    static int N, M;
    static int[][] board;

    public static void initShape() {
        shapes[0] = new Shape(new int[][]{{1, 1, 1, 1}});
        shapes[1] = new Shape(new int[][]{{1, 1}, {1, 1}});
        shapes[2] = new Shape(new int[][]{{1, 0}, {1, 0}, {1, 1}});
        shapes[3] = new Shape(new int[][]{{1, 0}, {1, 1}, {0, 1}});
        shapes[4] = new Shape(new int[][]{{1, 1, 1}, {0, 1, 0}});
    }

    public static Shape rotate(Shape e) {
        Shape newShape = new Shape(new int[e.x][e.y]);

        for(int y = 0; y < e.x; y++) {
            for(int x = 0; x < e.y; x++) {
                newShape.shape[y][x] = e.shape[e.y - 1 - x][y];
            }
        }

        return newShape;
    }

    public static Shape conversion_ud(Shape e) {
        Shape newShape = new Shape(new int[e.y][e.x]);

        for(int y = 0; y < e.y; y++) {
            for(int x = 0; x < e.x; x++) {
                newShape.shape[y][x] = e.shape[e.y - 1 - y][x];
            }
        }
        return newShape;
    }

    public static Shape conversion_lr(Shape e) {
        Shape newShape = new Shape(new int[e.y][e.x]);

        for(int y = 0; y < e.y; y++) {
            for(int x = 0; x < e.x; x++) {
                newShape.shape[y][x] = e.shape[y][e.x - 1 - x];
            }
        }
        return newShape;
    }
    public static void printShape(Shape shape) {
        for(int y = 0; y < shape.y; y++) {
            for(int x = 0; x < shape.x; x++) {
                System.out.printf("%d ", shape.shape[y][x]);
            }
            System.out.println();
        }
    }

    public static int checkShape(int y, int x, Shape e) {
        int sum = 0;
        if(y + e.y > N || x + e.x > M) {
            return -1;
        }
        for(int j = 0; j < e.y; j++) {
            for(int i = 0; i < e.x; i++) {
                sum += (board[j + y][i + x] * e.shape[j][i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        initShape();
        int value, max = 0;
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new int[N][M];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        ////
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                // shapes[0]은 rotate 1회만 해보면 된다
                value = checkShape(y, x, shapes[0]);
                max = Math.max(value, max);
                value = checkShape(y, x, rotate(shapes[0]));
                max = Math.max(value, max);
                // shapes[1]은 아무것도 안해도 된다
                value = checkShape(y, x, shapes[1]);
                max = Math.max(value, max);
                // shapes[2]부터는 상하 / 좌우 대칭, 3회 회전 모두 다 대보기
                for(int i = 2; i < shapes.length; i++) {
                    Shape e = shapes[i];

                    for(int a = 0; a < 2; a++) {
                        for (int b = 0; b < 4; b++) { // 90도씩 회전 * 4회
                            value = checkShape(y, x, e);
                            max = Math.max(value, max);
                            e = rotate(e);
                        }
                        if(a == 0) e = conversion_lr(e); // 좌우 대칭 후 다시
                        if(a == 1) e = conversion_ud(e); // 상하 대칭 후 다시
                    }
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
