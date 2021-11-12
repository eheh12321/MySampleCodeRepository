package CodingTestMemory.자바의정석.Chap12;

enum Direction {EAST, SOUTH, WEST, NORTH}

public class Enum1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);

        /////////////

        /**
         * 열거형 상수간의 비교에는 '=='를 사용할 수 있다.
         */
        System.out.println("d1==d2 ? " + (d1 == d2));
        System.out.println("d1==d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3)); // equals = 값이 같은지? || hashcode = 객체가 같은지?
        /**
         * 열거형 상수간에 '<', '>' 와 같은 비교연산자는 사용할 수 없다.
         * compareTo() 메소드를 사용하여 값을 비교할 수는 있다. (왼쪽이 크면 양수, 오른쪽이 크면 음수)
         */
//        System.out.println("d2 > d3 ? " + (d2 > d3)); // ERROR
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));

        switch (d1) {
            case EAST:
                System.out.println("EAST");
                break;
            case WEST:
                System.out.println("WEST");
                break;
            case NORTH:
                System.out.println("NORTH");
                break;
            case SOUTH:
                System.out.println("SOUTH");
                break;
            default:
                System.out.println("ERROR");
                break;
        }

        // values() = 열거형에 정의된 모든 상수를 출력한다.
        Direction[] dArr = Direction.values();

        for (Direction d : dArr) {
            // name() = 열거형 상수 문자열 이름
            // ordinal() = 열거형 상수가 정의된 순서를 정수로 반환(0부터 시작)
            System.out.printf("%s=%d\n", d.name(), d.ordinal());
        }
        /**
         * 참고) ordinal() 메소드를 열거형 상수의 값으로 사용하지 않는 것이 좋다.
         * 열거형 상수의 순서가 바뀌거나 멤버가 변경되거나 하면 코드 전체가 꼬일 수 있기 때문.
         * 문자열 이름으로 꺼내 쓰는 것이 바람직하다.
         * 열거형 상수에 멤버를 추가해 사용할 수도 있다 (Enum2 참고)
         */
    }
}
