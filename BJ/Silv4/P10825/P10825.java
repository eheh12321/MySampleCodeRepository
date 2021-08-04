package CodingTestMemory.BJ.Silv4.P10825;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if(this.kor < o.kor) {
            return 1;
        } else if (this.kor == o.kor) {
            if(this.eng > o.eng) {
                return 1;
            } else if(this.eng == o.eng) {
                if(this.math < o.math) {
                    return 1;
                } else if (this.math == o.math){
                    return this.name.compareTo(o.name);
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return name + " " + kor + " " + eng + " " + math;
    }
}

public class P10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int kor, eng, math;
        Student[] arr = new Student[N];
        String[] inputTmp;
        for(int i=0; i<N; i++) {
            inputTmp = sc.nextLine().split(" ");
            kor = Integer.parseInt(inputTmp[1]);
            eng = Integer.parseInt(inputTmp[2]);
            math = Integer.parseInt(inputTmp[3]);
            arr[i] = new Student(inputTmp[0], kor, eng, math);
        }
        Arrays.sort(arr);

        for(Student student : arr) {
            System.out.println(student.name);
        }
    }
}
