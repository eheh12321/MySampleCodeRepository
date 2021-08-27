package CodingTestMemory.StudyJava.Generic;

abstract class Animal {

    Animal() {
        System.out.println("Animal 객체 생성!");
    }

    abstract void sound();
    abstract void whoAmI();
}
