package CodingTestMemory.자료구조.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

// 코드 참고: https://st-lab.tistory.com/174?category=856997
public class GenericArrayListStack<E> extends ArrayList<E> {
    public GenericArrayListStack() {
        super();
    }

    public GenericArrayListStack(int initialCapacity) {
        super(initialCapacity);
    }

    public E push(E item) {
        super.add(item);
        return item;
    }

    public E pop() {
        int length = super.size();
        if (length == 0) {
            throw new EmptyStackException();
        }
        return super.remove(length - 1);
    }

    public E peek() {
        int length = super.size();
        if (length == 0) {
            throw new EmptyStackException();
        }
        return super.get(length - 1);
    }

    public int search(Object value) {
        int idx = super.lastIndexOf(value);
        return idx >= 0 ? super.size() - idx : -1;
    }

    public boolean empty() {
        return super.size() == 0;
    }
}
