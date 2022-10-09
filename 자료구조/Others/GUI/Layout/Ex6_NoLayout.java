package CodingTestMemory.자료구조.Others.GUI.Layout;

import javax.swing.*;

class Ex6_NoLayout {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("No Layout");

            this.setLayout(null);

            JButton btn1 = new JButton("버튼 1");
            btn1.setBounds(50, 50, 70, 60); // 시작 x, y, 폭, 높이
            this.add(btn1);

            JButton btn2 = new JButton("버튼 2");
            btn2.setBounds(80, 80, 70, 60);
            this.add(btn2);

            JButton btn3 = new JButton("버튼 3");
            btn3.setBounds(110, 110, 70, 60);
            this.add(btn3);

            setSize(256, 256);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
