package CodingTestMemory.자바의정석.Chap12;

import java.util.ArrayList;
import java.util.List;

class Product{}
class Tv extends Product {}
class Audio extends Product {}

public class GenericClass1 {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Tv> tvList = new ArrayList<>();

        // OK (ArrayList는 List에 상속관계)
        List<Tv> tvList2 = new ArrayList<Tv>();

        // 참조변수에 지정해준 제네릭 타입과 생성자에 지정한 제네릭 타입은 일치해야 한다.
        // Product가 Tv의 조상 관계에 있더라도 제네릭 타입이 일치하지 않으면 에러가 발생한다.
//      ArrayList<Product> productList2 = new ArrayList<Tv>();

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());

//      tvList.add(new Audio());
//      tvList.add(new Product());

        printAll(productList);
    }

    public static void printAll(ArrayList<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}
