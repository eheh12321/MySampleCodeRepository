package CodingTestMemory.자바의정석.Chap7;

// 외부 클래스
class InnerEx2 {
    // 내부 클래스
    class InstanceInner {} // 인스턴스 클래스 - 인스턴스 멤버처럼 다뤄진다
    static class StaticInner {} // static 클래스 - static 멤버처럼 다뤄진다.
    
    // 인스턴스 멤버 간에는 서로 직접 접근 가능
    InstanceInner iv = new InstanceInner();
    // static 멤버 간에는 서로 직접 접근 가능
    static StaticInner cv = new StaticInner();
    
    static void staticMethod() {
        StaticInner obj2 = new StaticInner();

        // static 메서드는 인스턴스 멤버에 직접 접근 불가
        // InstanceInner obj1 = new InstanceInner();
        
        // 외부 클래스의 인스턴스를 먼저 생성한 이후에야 접근 가능.
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
    }

    void myMethod() {
        class LocalInner{} // 지역 클래스 - 선언된 영역 안에서만 사용 가능.
        LocalInner lv = new LocalInner();
    }
}
