package CodingTestMemory.자료구조.Others.Generic;

abstract class Animal {

    Animal() {
        System.out.println("Animal 객체 생성!");
    }

    abstract void sound();
    abstract void whoAmI();
}
