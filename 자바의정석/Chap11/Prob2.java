package CodingTestMemory.자바의정석.Chap11;

import java.util.HashSet;

public class Prob2 {

    static class SutdaCard {
        int num;
        boolean isKwang;

        SutdaCard() {
            this(1, true);
        }

        public SutdaCard(int num, boolean isKwang) {
            this.num = num;
            this.isKwang = isKwang;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof SutdaCard) {
                SutdaCard c = (SutdaCard) obj;
                return num == c.num && isKwang == c.isKwang;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public String toString() {
            return num + (isKwang ? "K" : "");
        }
    }

    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        SutdaCard c3 = new SutdaCard(1, true);

        HashSet<SutdaCard> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
