package CodingTestMemory.자료구조.Bitmask;

public class Bitmask {

    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    static int clearLeftBits(int num, int i) {
        return num & (1 << i) - 1;
    }

    static int clearRightBits(int num, int i) {
        return num & (-1 << (i + 1));
    }

    static int updateBit(int num, int i, boolean val) {
        return (num & (1 << i)) | ((val ? 1 : 0) << i);
    }
}
