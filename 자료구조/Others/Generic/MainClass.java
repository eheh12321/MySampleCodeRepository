package CodingTestMemory.자료구조.Others.Generic;

import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        LinkedList<Animal> animals = new LinkedList<>();

        animals.addFirst(new Dog("점박이", 1));
        animals.addFirst(new Dog("콩순이", 2));
        animals.addFirst(new Cat("얼룩이", 7));
        animals.addFirst(new Cat("냥아치", 3));

        animals.peek().whoAmI();

    }
}
