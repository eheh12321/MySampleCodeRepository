package CodingTestMemory.자바의정석.Chap11;


import java.util.*;

public class Prob1 {
    
    static class Student implements Comparable<Student>{
        String name;
        int ban;
        int no;
        int kor, eng, math;

        public Student(String name, int ban, int no, int kor, int eng, int math) {
            this.name = name;
            this.ban = ban;
            this.no = no;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        
        int getTotal() {
            return kor + eng + math;
        }
        
        double getAverage() {
            return (getTotal() / 3.0);
        }
        
        public String toString() {
            return name + "," + ban + "," + no + ",[" + kor + "," + eng + "," + math + "] " + String.format("%.2f", getAverage());
        }

        @Override
        public int compareTo(Student student) {
            double val = student.getAverage() - this.getAverage();
            return (int)val;
        }
    }

    static class BanNoAscending implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.name.equals(o2.name)) {
                if(o1.ban == o2.ban) {
                    return o1.no - o2.no;
                } else {
                    return o1.ban - o2.ban;
                }
            } else {
                return o1.name.compareTo(o2.name);
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("AAA", 1, 1, 100, 100, 100));
        list.add(new Student("AAA", 2, 1, 90, 100, 100));
        list.add(new Student("BBB", 1, 2, 90, 70, 80));
        list.add(new Student("CCC", 1, 3, 80, 80, 90));
        list.add(new Student("ABC", 1, 4, 70, 90, 70));
        list.add(new Student("BAB", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator<Student> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("------");

        Collections.sort(list, new BanNoAscending());
        Iterator<Student> iter2 = list.iterator();
        while(iter2.hasNext()) {
            System.out.println(iter2.next());
        }

    }
}
