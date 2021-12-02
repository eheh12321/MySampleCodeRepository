package CodingTestMemory.StudyJava.GUI.Layout;

import javax.swing.*;
import java.awt.*;

class Ex2_FlowLayout {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("FlowLayout");

            // this = 현재 윈도우 자체인 JFrame.
            this.setLayout(new FlowLayout());

            this.add(new JButton("버튼 1"));
            this.add(new JButton("버튼 2"));
            this.add(new JButton("버튼 3"));
            this.add(new JButton("버튼 4"));
            this.add(new JButton("버튼 5"));

            setSize(256, 256);
            setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MyGUI();
    }
}
