package CodingTestMemory.자료구조.Stack;

public class IntStack {
    private int max;
    private int ptr;
    private int[] stk;

    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() {};
    }

    public class OverflowStackException extends RuntimeException {
        public OverflowStackException() {};
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowStackException {
        if(ptr >= max) {
            throw new OverflowStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyStackException {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public int peek() throws EmptyStackException { // 마지막에 있는 원소 출력
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[ptr - 1];
    }

    public int indexOf(int x) {
        for(int i = ptr - 1; i >= 0; i--) {
            if(stk[i] == x) {
                return i;
            }
        }
        return -1; // 검색실패
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void printStack() {
        if(ptr <= 0) {
            System.out.println("스택이 비어있습니다");
        } else {
            for(int i = 0; i < ptr; i++) {
                System.out.println(stk[i]);
            }
        }
    }
}
