package CodingTestMemory.자료구조.Others.GUI.Component;

import javax.swing.*;
import java.awt.*;

class Ex4_JList {

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("JList");
            this.setLayout(new FlowLayout());

            String[] pet = {"고양이", "강아지", "토끼", "코알라", "송아지"};
            JList<String> list = new JList<>(pet);

            JScrollPane sp = new JScrollPane(list);
            Dimension d = list.getPreferredSize();
            d.width = 100;
            d.height = 50;
            sp.setPreferredSize(d);
            this.add(sp);

            JComboBox<String> combo = new JComboBox<>(pet);
            this.add(combo);

            setSize(200, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
