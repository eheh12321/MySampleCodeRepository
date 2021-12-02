package CodingTestMemory.StudyJava.GUI.Component;

import javax.swing.*;
import java.awt.*;

class Ex2_AbstractButton {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("AbstractButton Component");
            this.setLayout(new FlowLayout());

            ImageIcon img1 = new ImageIcon("image/java1.png");
            ImageIcon img2 = new ImageIcon("image/java2.png");

            this.add(new JButton("버튼 1", img1));

            JLabel lbl1 = new JLabel("레이블 1입니다");
            JLabel lbl2 = new JLabel(img2);
            this.add(lbl1);
            this.add(lbl2);

            this.add(new JCheckBox("C++"));
            this.add(new JCheckBox("JAVA", true));
            this.add(new JCheckBox("C#"));

            JRadioButton rdo1 = new JRadioButton("고래");
            JRadioButton rdo2 = new JRadioButton("새우");
            JRadioButton rdo3 = new JRadioButton("상어");
            this.add(rdo1);
            this.add(rdo2);
            this.add(rdo3);

            ButtonGroup group = new ButtonGroup();
            group.add(rdo1);
            group.add(rdo2);
            group.add(rdo3);

            setSize(200, 300);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
