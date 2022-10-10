package CodingTestMemory.자료구조.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 재귀로 구현된 BST
 * 코드 참고: https://www.baeldung.com/java-binary-tree
 */
public class BinarySearchTreeByRecursive {

    public class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    private static Node root;

    /**
     * 꼭 필요한 메서드만 외부로 노출
     */

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    public boolean containsNode(int key) {
        return containsNodeRecursive(root, key);
    }

    public void add(int key) {
        root = addRecursive(root, key);
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    public void preorder(Node node) {
        if(node != null) {
            System.out.println(" " + node.key);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(" " + node.key);
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(" " + node.key);
        }
    }

    public void levelOrder() { // BFS 스타일
        if(root == null) {
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();

            System.out.println(" " + node.key);
            if(node.left != null) {
                nodeQueue.add(node.left);
            }
            if(node.right != null) {
                nodeQueue.add(node.right);
            }
        }
    }

    private int getSizeRecursive(Node node) {
        return node == null ? 0 : getSizeRecursive(node.left) + getSizeRecursive(node.right) + 1;
    }

    private boolean containsNodeRecursive(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }

        return node.key < key
                ? containsNodeRecursive(node.right, key)
                : containsNodeRecursive(node.left, key);
    }

    private Node addRecursive(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key < key) {
            node.right = addRecursive(node.right, key);
        } else if (node.key > key) {
            node.left = addRecursive(node.left, key);
        } else {
            System.out.printf("이미 [%d] 노드가 존재합니다!", key);
            throw new RuntimeException();
        }
        return node;
    }

    private Node deleteRecursive(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.key == key) {
            // Case 1. 자식이 없는 경우
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2. 한쪽에만 자식이 있는 경우
            if (node.left == null) { // 오른쪽 자식만 있는 경우
                return node.right;
            }
            if (node.right == null) { // 왼쪽 자식만 있는 경우
                return node.left;
            }

            // Case 3. 양쪽 모두 자식이 있는 경우
            int smallestValue = findSmallestValue(node.right);
            node.key = smallestValue;
            node.right = deleteRecursive(node.right, smallestValue);
        } else if (node.key < key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            node.left = deleteRecursive(node.left, key);
        }
        return node;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.key : findSmallestValue(root.left);
    }
}
