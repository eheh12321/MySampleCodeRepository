package CodingTestMemory.자료구조.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;

// 코드 참고: https://st-lab.tistory.com/174?category=856997
public class GenericArrayStack<E> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public GenericArrayStack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public GenericArrayStack(int size) { // 지정된 크기의 스택을 사용하고 싶은 경우
        this.array = new Object[size];
        this.size = size;
    }

    // 배열의 크기를 재조정해 메모리 사용 최적화
    private void resize() {
        // 스택이 비어있으면 기본 배열을 사용한다
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        int arrayCapacity = array.length;

        // 스택이 가득 찼다면 배열의 길이를 두배 늘린다
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;
            array = Arrays.copyOf(array, newSize);
            return;
        }

        // 스택이 절반 미만으로 사용되고 있다면 배열의 길이를 반으로 줄인다
        if (size < (arrayCapacity / 2)) {
            int newSize = arrayCapacity / 2;
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newSize)); // 스택의 크기가 최솟값보다 작지는 않도록 함
            return;
        }
    }

    public E push(E item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
        return item;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E item = (E) array[size - 1];

        array[size - 1] = null;
        size--;
        resize();

        return item;
    }

    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    public int search(E value) {
        for (int idx = size - 1; idx >= 0; idx--) {
            if (array[idx].equals(value)) {
                return size - idx;
            }
        }
        return -1; // 찾지 못한 경우 -1을 반환
    }

    public int size() {
        return size;
    }

    // 배열 내부 모든 원소를 null로 초기화 한 다음 배열의 길이를 절반으로 줄인다
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        resize();
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GenericArrayStack<?> cloneStack = (GenericArrayStack<?>) super.clone(); // 단순 복사 객체 생성 (얕은 복사)
        cloneStack.array = new Object[size]; // 내부 값 복사 (깊은 복사)
        System.arraycopy(array, 0, cloneStack.array, 0, size);
        return cloneStack;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public void sort() {
        sort(null);
    }

    public void sort(Comparator<? super E> comparator) {
        // 값이 있는 부분까지만 정렬!!
        Arrays.sort((E[]) array, 0, size, comparator);
    }
}
