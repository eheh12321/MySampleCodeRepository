package CodingTestMemory.StudyJava.Generic;

public class Dog extends Animal {

    String name;
    int age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Dog 객체 생성!");
    }

    @Override
    public void sound() {
        System.out.println("멍멍!");
    }

    @Override
    public void whoAmI() {
        System.out.println("나는 [" + this.name +"] 강아지당");
    }
    
    public void dogMethod() {
        System.out.println("Dog에만 있는 메소드");
    }
}
