package CodingTestMemory.자료구조.Graph.AdjArr;

class ArrGraph {
    private int[][] arrGraph;

    public ArrGraph(int initSize) {
        this.arrGraph = new int[initSize+1][initSize+1];
    }
    public int[][] getGraph() {
        return this.arrGraph;
    }
    public void put(int x, int y) { // 양방향 추가
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }
    public void putSingle(int x, int y) { // 단방향 추가
        arrGraph[x][y] = 1;
    }
    public void printGraph() {
        for(int i = 1; i < arrGraph.length; i++) {
            for(int j = 1; j < arrGraph[i].length; j++) {
                System.out.print(arrGraph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class MainClass {
    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph adjArr = new ArrGraph(initSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);

        adjArr.printGraph();
    }
}
