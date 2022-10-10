package CodingTestMemory.자료구조.Tree;

import java.util.Stack;

/**
 * BST
 * 코드 참고
 * - https://yaboong.github.io/data-structures/2018/02/12/binary-search-tree/
 * - https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
 */
public class BinarySearchTree {
    public class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    private static Node root;

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node parent;
            Node current = root;
            while (true) {
                parent = current;
                if (current.key == key) {
                    throw new RuntimeException("이미 해당 노드가 존재하고 있습니다.");
                } else if (key < current.key) {
                    current = parent.left;
                    if (current == null) { // 단말노드이면 삽입
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = parent.right;
                    if (current == null) { // 단말노드이면 삽입
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        Node parent = root; // 삭제될 노드의 부모 노드
        Node current = root; // 삭제될 노드

        while (current.key != key) { // 삭제될 노드를 먼저 탐색하는 과정
            parent = current;
            if (key < current.key) {
                current = parent.left;
            } else {
                current = parent.right;
            }

            if (current == null) {
                throw new RuntimeException("해당 노드를 찾을 수 없습니다.");
            }
        }

        Node replaceNode;
        // Case 1. 단말 노드인 경우
        if (current.left == null && current.right == null) {
            if (current == root) root = null; // Root 노드를 삭제하는 경우
            else if (parent.left != null) parent.left = null; // 왼쪽 자식 노드를 삭제하는 경우
            else parent.right = null; // 오른쪽 자식 노드를 삭제하는 경우

            return;
        }

        // Case 2. 왼쪽 서브트리만 있는 경우
        if (current.right == null) {
            replaceNode = current.left;
            if (current == root) root = replaceNode; // Root 노드를 삭제하는 경우
            else if (parent.left != null) parent.left = replaceNode; // 왼쪽 자식 노드를 삭제하는 경우
            else parent.right = replaceNode; // 오른쪽 자식 노드를 삭제하는 경우

            return;
        }

        // Case 3. 오른쪽 서브트리만 있는 경우
        if (current.left == null) {
            replaceNode = current.right;
            if (current == root) root = replaceNode; // Root 노드를 삭제하는 경우
            else if (parent.left != null) parent.left = replaceNode; // 왼쪽 자식 노드를 삭제하는 경우
            else parent.right = replaceNode; // 오른쪽 자식 노드를 삭제하는 경우

            return;
        }

        // Case 4. 양쪽 서브트리가 모두 있는 경우
        Node rightSubTree = current.right;
        replaceNode = getRightMinNode(current.right); // 오른쪽 서브트리 안에서 최소 노드

        // replaceNode를 Current Node 자리로 대체
        if (current == root) root = replaceNode; // Root 노드를 삭제하는 경우
        else if (parent.left != null) parent.left = replaceNode; // 왼쪽 자식 노드를 삭제하는 경우
        else parent.right = replaceNode; // 오른쪽 자식 노드를 삭제하는 경우

        replaceNode.right = current.right; // 나머지 서브트리를 오른쪽 자식에 이어붙임
        if (replaceNode == rightSubTree) replaceNode.right = null; // 우측 서브트리의 루트 노드가 가장 최솟값이었던 경우
        replaceNode.left = current.left; // 대체 노드의 왼쪽 자식은 기존에 있던 왼쪽 서브트리를 이어붙임
    }

    // 오른쪽 서브트리에서 가장 작은 노드를 리턴하고, 서브트리에서 해당 노드를 null 처리 하는 것 까지 같이 진행
    // 단, 우측 서브트리에서 루트 노드가 가장 최소 노드인 경우는 null 처리가 되지 않으므로 바깥에서 체크해줘야함
    private Node getRightMinNode(Node rightChildRootNode) {
        Node focusNode = rightChildRootNode;
        Node parent = rightChildRootNode;
        while (focusNode.left != null) {
            parent = focusNode;
            focusNode = focusNode.left;
        }
        parent.left = focusNode.right;
        return focusNode;
    }

    /**
     * (심화 중 심화) 재귀 대신 스택을 사용하는 트리 순회 방법
     */

    public void preorder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            System.out.println(" " + current.key);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void inorder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) { // 왼쪽으로 끝까지 진행
                stack.push(current);
                current = current.left;
            }
            Node top = stack.pop();
            System.out.print(" " + top.key); // 방문
            current = top.right; // 오른쪽으로 이동
        }
    }

    public void postorder() {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (current != null || !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                System.out.println(" " + current.key);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }
}
