package CodingTestMemory.StudyJava.Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;
    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = this.rear = 0;
    }

    public ArrayQueue(int size) {
        this.array = new Object[size];
        this.size = 0;
        this.front = this.rear = 0;
    }

    @Override
    public boolean offer(E item) {
        if((rear + 1) % array.length == front) {
            System.out.println("큐가 가득찼습니다");
            return false;
        }
        rear = (rear + 1) % array.length;
        array[rear] = item;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(size == 0) {
            return null;
        }
        front = (front + 1) % array.length;
        E item = (E) array[front];
        array[front] = null;
        size--;
        return item;
    }

    public E remove() {
        E item = poll();
        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null;
        }
        E item = (E) array[(front + 1) % array.length];
        return item;
    }

    public E element() {
        E item = peek();

        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    private void resize(int newCapacity) {
        int arrayCapacity = array.length;
        Object[] newArray = new Object[newCapacity];

        for(int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }

        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        int start = (front + 1) % array.length;
        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if(array[idx].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for(int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        front = rear = size = 0;
    }

    public Object[] toArray() {
        int start = (front + 1) % array.length;
        Object[] arrCopy = new Object[size];

        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            arrCopy[i] = (E) array[idx];
        }
        return arrCopy;
    }

    public void sort(Comparator<? super E> c) {
        Object[] res = toArray();
        Arrays.sort((E[]) res, c);
    }
}
