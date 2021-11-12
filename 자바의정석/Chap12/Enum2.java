package CodingTestMemory.자바의정석.Chap12;

enum Direction2 {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value;
    private final String symbol;

    /**
     * 열거형의 생성자는 묵시적으로 private 이다.
     * 생성자가 존재하는 이유는 기존 열거형 상수에 멤버를 추가하기 위함이지 외부에서 생성자를 추가하고자 하는 것이 아니다.
     */
    Direction2(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction2 of(int dir) {
        if(dir < 1 || dir > 4) {
            throw new IllegalArgumentException("Invalid Value : " + dir);
        }
        // ordinal() 은 0부터 저장.
        return DIR_ARR[dir - 1];
    }

    public Direction2 rotate(int num) {
        num %= 4;
        if(num < 0) num += 4;
        return DIR_ARR[(value - 1 + num) % 4];
    }

    public String toString() {
        return name() + " '" + getSymbol() +"'";
    }
}

public class Enum2 {
    public static void main(String[] args) {
        for(Direction2 d : Direction2.values()) {
            System.out.printf("%s=[%d, %s]\n", d.name(), d.getValue(), d.getSymbol());
        }

        Direction2 d1 = Direction2.EAST;
        Direction2 di = Direction2.of(1);

        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
    }
}
