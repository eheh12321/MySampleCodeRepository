package CodingTestMemory.자료구조.Others.Generic;

public class Cat extends Animal {

    String name;
    int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Cat 객체 생성!");
    }

    @Override
    public void sound() {
        System.out.println("냐옹이다냥");
    }

    @Override
    public void whoAmI() {
        System.out.println("나는 [" + this.name +"] 냐옹이당");
    }

    public void catMethod() {
        System.out.println("Cat에만 있는 메소드");
    }
}
