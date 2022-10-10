package CodingTestMemory.자료구조.Tree;

/**
 * AVL 트리
 * 코드 참고: https://www.baeldung.com/java-avl-trees
 */
public class AVLTree {

    public class Node {
        Node left;
        Node right;
        int height;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    // 현재 노드의 높이 정보 업데이트 (왼쪽 서브트리와 오른쪽 서브트리 높이 중 더 큰 값을 선택)
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // 현재 노드의 높이 계산 (null인 경우 -1을 리턴, Root = 0)
    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    // 현재 노드의 Balance Factor 계산 (오른쪽 서브트리의 높이 - 왼쪽 서브트리의 높이)
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    /**
     * 외부로는 꼭 필요한 메서드만 노출
     */

    public void insert(int key) {
        root = insertNode(root, key);
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    public Node find(int key) {
        Node currentNode = root;
        while(currentNode != null) {
            if(currentNode.key == key) {
                break;
            }
            currentNode = currentNode.key < key ? currentNode.right : currentNode.left;
        }
        return currentNode;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Top Node는 꼭 Root를 의미하는 것이 아니고 서브트리를 회전 하기 전 서브트리의 가장 상위 노드를 가리키는 용도
     * Top -> Mid -> Bottom 순
     * (회전하고 나면 Mid가 제일 위로 올라오게 됨.)
     */

    private Node rotateRight(Node top) {
        Node mid = top.left;
        Node bottom = mid.right;
        mid.right = top;
        top.left = bottom;
        updateHeight(mid);
        updateHeight(top);
        return mid;
    }

    private Node rotateLeft(Node top) {
        Node mid = top.right;
        Node bottom = mid.left;
        mid.left = top;
        top.right = bottom;
        updateHeight(mid);
        updateHeight(top);
        return mid;
    }

    private Node reBalance(Node top) {
        updateHeight(top);
        int balance = getBalance(top);
        if (balance > 1) { // 오른쪽으로 쏠려있음
            if (height(top.right.right) > height(top.right.left)) { // RR
                top = rotateLeft(top);
            } else { // RL
                top.right = rotateRight(top.right);
                top = rotateLeft(top);
            }
        } else if (balance < -1) { // 왼쪽으로 쏠려있음
            if (height(top.left.left) > height(top.left.right)) { // LL
                top = rotateRight(top);
            } else { // LR
                top.left = rotateLeft(top.left);
                top = rotateRight(top);
            }
        }
        return top;
    }

    private Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key < key) {
            node.right = insertNode(node.right, key);
        } else if (node.key > key) {
            node.left = insertNode(node.left, key);
        } else {
            System.out.printf("이미 [%d] 노드가 존재합니다!\n", key);
            throw new RuntimeException();
        }
        return reBalance(node);
    }

    private Node deleteNode(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.key < key) {
            node.right = deleteNode(node.right, key);
        } else if (node.key > key) {
            node.left = deleteNode(node.left, key);
        } else { // 해당 노드를 찾음
            if (node.left == null || node.right == null) {
                node = node.left == null ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = deleteNode(node.right, node.key);
            }
        }
        if (node != null) {
            node = reBalance(node);
        }
        return node;
    }

    // 서브트리에서 가장 작은 노드 찾기
    private Node mostLeftChild(Node top) {
        Node current = top;
        while (current.left != null) current = current.left;
        return current;
    }
}
