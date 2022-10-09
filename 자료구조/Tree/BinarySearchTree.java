package CodingTestMemory.자료구조.Tree;

import java.util.Scanner;

public class BinarySearchTree {

    public static class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    public static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===================");
            System.out.println("BST Tree");
            System.out.println("1: 탐색");
            System.out.println("2: 삽입");
            System.out.println("3: 삭제");
            System.out.println("4: 순회");
            System.out.println("0: 종료");
            System.out.println("===================");
            System.out.print(">> 명령어를 입력해주세요: ");
            int op = sc.nextInt();
            switch (op) {
                case 0:
                    System.out.println("시스템을 종료합니다");
                    return;
                case 1:
                    System.out.print(">> 탐색할 키값을 입력해주세요: ");
                    findNode(sc.nextInt());
                    break;
                case 2:
                    System.out.print(">> 삽입할 키값을 입력해주세요: ");
                    addNode(sc.nextInt());
                    break;
                case 3:
                    System.out.print(">> 삭제할 키값을 입력해주세요: ");
                    deleteNode(sc.nextInt());
                    break;
                case 4:
                    System.out.print(">> 순회 방법을 입력하세요 (1=preorder, 2=inorder, 3=postorder): ");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("[전위 순회]");
                            System.out.print("[ ");
                            preorder(root);
                            System.out.println("]");
                            break;
                        case 2:
                            System.out.println("[중위 순회]");
                            System.out.print("[ ");
                            inorder(root);
                            System.out.println("]");
                            break;
                        case 3:
                            System.out.println("[후위 순회]");
                            System.out.print("[ ");
                            postorder(root);
                            System.out.println("]");
                            break;
                    }
                    break;
                default:
                    System.out.println("잘못된 명령어입니다");
                    break;
            }
        }
    }

    public static Node findNode(int key) {
        if (root == null) {
            System.out.println(">> 트리가 비어있습니다!");
            return null;
        }
        Node focusNode = root;
        int height = 0;
        while (focusNode.key != key) {
            if (focusNode.key < key) focusNode = focusNode.right;
            else focusNode = focusNode.left;
            height++;
            if (focusNode == null) {
                System.out.println(">> 해당 노드가 존재하지 않습니다 :P");
                return null;
            }
        }
        System.out.printf(">> 값이 [%d] 높이에 존재합니다!\n", height);
        return focusNode;
    }

    public static void addNode(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            System.out.printf(">> [%d] 노드를 트리에 삽입했습니다\n", key);
        } else {
            Node parent;
            Node focusNode = root;
            while (true) {
                parent = focusNode;
                if (focusNode.key == key) {
                    System.out.println(">> 이미 값이 존재합니다!");
                    return;
                } else if (key < focusNode.key) {
                    focusNode = parent.left;
                    if (focusNode == null) { // 단말노드이면 삽입
                        System.out.printf(">> [%d] 노드를 트리에 삽입했습니다\n", key);
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = parent.right;
                    if (focusNode == null) { // 단말노드이면 삽입
                        System.out.printf(">> [%d] 노드를 트리에 삽입했습니다\n", key);
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public static void deleteNode(int key) {
        if (root == null) {
            System.out.println(">> 트리가 비어있습니다!");
            return;
        }
        Node parent = root; // 삭제될 노드의 부모 노드
        Node focusNode = root; // 삭제될 노드
        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key) focusNode = parent.left;
            else focusNode = parent.right;

            if (focusNode == null) {
                System.out.println(">> 해당 노드가 없습니다!");
                return;
            }
        }
        Node replaceNode;
        // 단말 노드인 경우
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root) root = null;
            else if (parent.left != null) parent.left = null;
            else parent.right = null;
        }
        // 왼쪽 서브트리만 있는 경우
        else if (focusNode.right == null) {
            replaceNode = focusNode.left;
            if (focusNode == root) root = replaceNode;
            else if (parent.left != null) parent.left = replaceNode;
            else parent.right = replaceNode;
        }
        // 오른쪽 서브트리만 있는 경우
        else if (focusNode.left == null) {
            replaceNode = focusNode.right;
            if (focusNode == root) root = replaceNode;
            else if (parent.left != null) parent.left = replaceNode;
            else parent.right = replaceNode;
        }
        // 양쪽 서브트리가 모두 있는 경우
        else {
            Node rightSubTree = focusNode.right;
            replaceNode = getRightMinNode(focusNode.right); // 오른쪽 서브트리 안에서 최소 노드

            if (focusNode == root) root = replaceNode;
            else if (parent.left != null) parent.left = replaceNode;
            else parent.right = replaceNode;

            replaceNode.right = rightSubTree;
            if (replaceNode == rightSubTree) replaceNode.right = null; // 우측 서브트리에 노드가 하나밖에 없는 경우
            replaceNode.left = focusNode.left;
        }
        System.out.printf(">> [%d] 노드를 트리에서 삭제했습니다\n", key);
    }

    private static Node getRightMinNode(Node rightChildRootNode) {
        Node parent = rightChildRootNode;
        Node focusNode = rightChildRootNode;

        while (focusNode.left != null) {
            parent = focusNode;
            focusNode = focusNode.left;
        }
        parent.left = null;
        return focusNode;
    }

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }
}
