package CodingTestMemory.StudyJava.DFSBFS;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null) { // 큐가 비었을때
            last = null;
        }
        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

class Graph {
    class Node { // 그래프 노드 :D
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node (int data) { // 생성자
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size) { // 생성자
        nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1, int i2) { // 노드 연결
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) { // n1노드와 n2노드가 연결되어 있지 않다면
            n1.adjacent.add(n2); // 연결 추가
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.addFirst(n1);
        }
    }
    void dfs() {
        dfs(0);
    }
    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    void bfs() {
        bfs(0);
    }
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }
    void visit(Node r) {
        System.out.print(r.data + " ");
    }
    void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent) {
            if(n.marked == false) {
                dfsR(n);
            }
        }
    }
    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR() {
        dfsR(0);
    }
}

public class MainClass {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.dfsR();
    }
}
