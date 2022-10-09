package CodingTestMemory.자료구조.Queue;

public interface Queue<E> {

    // 큐의 마지막에 요소를 추가하는 offer
    boolean offer(E e);

    // 큐의 첫번째 요소를 제거하고 제거된 요소를 반환하는 poll
    E poll();

    // 큐의 첫번째 원소를 확인하는 peek
    E peek();
}
