package CodingTestMemory.자바의정석.Chap7;

interface Repairable {}

class Unit {
    int hitPoint;
    final int MAX_HP;
    Unit(int hp) {
        MAX_HP = hp;
    }

    int attacked(int damage) {
        int val = hitPoint - damage;
        if(val <= 0) {
            System.out.println("사망하였습니다");
            return 0;
        } else {
            hitPoint = val;
            return 1;
        }
    }

    int getHP() {
        System.out.println("HP: " + hitPoint);
        return hitPoint;
    }
}

class GroundUint extends Unit {
    GroundUint(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit {
    public AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUint implements Repairable {
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
}

class DropShip extends AirUnit implements Repairable {
    DropShip() {
        super(125);
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "DropShip";
    }
}

class Marine extends GroundUint {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
}

class SCV extends GroundUint implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r) {
        if(r instanceof Unit) {
            Unit u = (Unit) r;
            while(u.hitPoint != u.MAX_HP) {
                u.hitPoint++;
            }
            System.out.println(u.toString() + "의 수리가 끝났습니다.");
        }
    }
}

class InterfaceRepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        DropShip dropShip = new DropShip();
        Marine marine = new Marine();
        SCV scv = new SCV();

        tank.attacked(20);
        tank.getHP();

        scv.repair(tank);
        scv.repair(dropShip);
    }
}
