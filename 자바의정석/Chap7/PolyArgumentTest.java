package CodingTestMemory.자바의정석.Chap7;

import java.util.Vector;

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }

    Product() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    Vector<Product> item = new Vector<>();
    
    void buy(Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족합니다");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println(p + "을 정상적으로 구매하였습니다.");
    }
    
    void refund(Product p) {
        if(item.remove(p)) {
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println(p + "를 정상적으로 반품하였습니다");
        } else {
            System.out.println("해당 제품을 구입한 기록이 없습니다");
        }
    }
    
    void summary() {
        int sum = 0;
        String itemList = "";
        if(item.isEmpty()) {
            System.out.println("구입하신 제품이 없습니다");
            return;
        }
        
        for(int i = 0; i < item.size(); i++) {
            Product p = (Product) item.get(i);
            sum += p.price;
            itemList += (i == 0) ? "" + p : ", " + p;
        }
        System.out.println("구입하신 물품의 총 금액은 [" + sum + "]만원 입니다");
        System.out.println("구입하신 제품은 [" + itemList + "] 입니다");
    }
}

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Audio());
        b.summary();
        System.out.println("현재 잔액: " + b.money);
        System.out.println("현재 포인트: " + b.bonusPoint);
    }
}
