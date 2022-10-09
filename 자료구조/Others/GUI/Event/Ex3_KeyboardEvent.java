package CodingTestMemory.자료구조.Others.GUI.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Ex3_KeyboardEvent {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Event 3");
            this.setLayout(new FlowLayout());

            JTextField txt = new JTextField(10);
            JTextArea area = new JTextArea(10, 10);
            this.add(txt);
            this.add(area);

            txt.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    int key = e.getKeyCode();
                    if(key == KeyEvent.VK_ENTER) {
                        String str = txt.getText();
                        area.setText(area.getText() + str + "\n");
                        txt.setText("");
                    }
                    if(!(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)) {
                        String str = txt.getText();
                        int strlen = str.length();
                        if(strlen != 0) {
                            txt.setText(str.substring(0, strlen - 1));
                        }
                    }
                }
            });

            setSize(200, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
