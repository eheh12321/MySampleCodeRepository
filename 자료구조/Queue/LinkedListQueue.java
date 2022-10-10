package CodingTestMemory.자료구조.Queue;

import java.util.*;

// 코드 참고: https://st-lab.tistory.com/184?category=856997
public class LinkedListQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public boolean offer(E e) { // enqueue (Tail에 삽입)
        Node<E> newNode = new Node<E>(e);

        if(size == 0) { // 큐가 비어있을 경우
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    public E poll() { // dequeue (Head의 데이터 제거)
        if(size == 0) {
            return null;
        }
        E element = head.data;
        Node<E> nextNode = head.next;

        head.next = null;
        head.data = null;

        head = nextNode;
        size--;
        return element;
    }

    public E peek() {
        if(size == 0) {
            return null;
        }
        return head.data;
    }

    public E element() {
        E element = peek();
        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public E remove() { // dequeue (exception을 던지는 버전)
        E element = poll();
        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E value) {
        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for(Node<E> x = head; x != null; x = x.next) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        size = 0;
        head = tail = null;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int idx = 0;
        for(Node<E> x = head; x != null; x = x.next) {
            array[idx++] = (E) x.data;
        }
        return array;
    }

    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);

        int i = 0;
        for (Node<E> x = head; x != null; x = x.next, i++) {
            x.data = (E) a[i]; // 정렬된 a 배열을 큐로 복사.
        }
    }
}
