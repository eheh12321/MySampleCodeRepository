package CodingTestMemory.자료구조.Others.GUI.Event;

import javax.swing.*;
import java.awt.*;

class Ex1_ButtonEvent {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Event 1");
            this.setLayout(new FlowLayout());

            JButton btn1 = new JButton("버튼 1");
            btn1.addActionListener(e -> btn1.setBackground(Color.RED));
            this.add(btn1);

            setSize(200, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
