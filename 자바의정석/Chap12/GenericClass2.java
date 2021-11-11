package CodingTestMemory.자바의정석.Chap12;

import java.util.ArrayList;

class Fruit implements Eatable {
    public String toString() {return "Fruit";}
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    @Override
    public String toString() {
        return "Grape";
    }
}

class Toy {
    public String toString() {
        return "Toy";
    }
}

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {list.add(item);}
    T get(int i) {return list.get(i);}
    int size() {return list.size();}
    public String toString() {return list.toString();}
}

public class GenericClass2 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Grape> grapeBox2 = new FruitBox<Apple>(); // 타입 불일치
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // Toy 클래스는 Fruit 클래스와 Eatable 인터페이스 상속 X
    }
}

