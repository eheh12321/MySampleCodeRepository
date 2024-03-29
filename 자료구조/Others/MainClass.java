package CodingTestMemory.자료구조.Others;

class StudentInfo {
    public int grade;
    StudentInfo(int grade) {
        this.grade = grade;
    }
}

class EmployeeInfo {
    public int rank;
    EmployeeInfo(int rank) {
        this.rank = rank;
    }
}

class Person<T, S> {
    public T info;
    public S id;
    Person(T info, S id) {
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info) {
        System.out.println(info);
    }
}

public class MainClass {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
        // Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i); ** 생략 가능
        Person p1 = new Person(e ,i);
        // p1.<EmployeeInfo>printInfo(e); ** 생략 가능
        p1.printInfo(e);
    }
}
