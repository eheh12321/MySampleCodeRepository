package CodingTestMemory.StudyJava.GUI.Component;

import javax.swing.*;
import java.awt.*;

class Ex3_JTextComponent {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("JTextComponent");

            this.setLayout(new FlowLayout());

            this.add(new JTextField(10)); // 한줄의 문자열
            
            JTextArea txt1 = new JTextArea(5, 10);// 5행 10열 텍스트박스
            this.add(txt1);
            this.add(new JScrollPane(txt1)); // 스크롤바 붙이기
            
            this.add(new JPasswordField(10)); // PW 입력 필드

            setSize(200, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
