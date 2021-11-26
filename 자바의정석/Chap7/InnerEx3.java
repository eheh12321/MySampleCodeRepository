package CodingTestMemory.자바의정석.Chap7;

class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv; // 외부 클래스의 private 멤버도 접근이 가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // static 클래스는 외부 클래스의 인스턴스 멤버에 접근 불가.
        static int svc = outerCv;
    }

    void myMethod () {
        int lv = 0;
        final int LV = 0;

        class LocalInner {
            int iiv = outerIv;
            int iiv2 = outerCv;
            int iiv3 = LV;
            int iiv4 = lv;
        }
    }
}
