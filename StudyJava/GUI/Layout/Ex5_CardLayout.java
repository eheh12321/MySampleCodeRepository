package CodingTestMemory.StudyJava.GUI.Layout;

import javax.swing.*;
import java.awt.*;

class Ex5_CardLayout {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("CardLayout");

            // 수평-수직 간격 10
            this.setLayout(new CardLayout(10, 10));

            this.add(new JButton("버튼 1"));
            this.add(new JButton("버튼 2"));
            this.add(new JButton("버튼 3"));

            setSize(256, 256);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
