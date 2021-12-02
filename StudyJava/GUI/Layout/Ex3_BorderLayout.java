package CodingTestMemory.StudyJava.GUI.Layout;

import javax.swing.*;
import java.awt.*;

class Ex3_BorderLayout {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("BorderLayout");

            this.setLayout(new BorderLayout(10, 10)); // 수평, 수직 간격

            // 상수(static final)은 static 클래스가 아니더라도 클래스명으로 바로 접근가능하다!
            this.add(new JButton("버튼 1"), BorderLayout.NORTH);
            this.add(new JButton("버튼 2"), BorderLayout.WEST);
            this.add(new JButton("버튼 3"), BorderLayout.EAST);
            this.add(new JButton("버튼 4"), BorderLayout.SOUTH);
            this.add(new JButton("버튼 5"), BorderLayout.CENTER);

            setSize(256, 256);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
