package CodingTestMemory.자료구조.Others.GUI.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Ex2_MouseEvent {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Event 2");
            this.setLayout(new FlowLayout());

            JTextField textX = new JTextField(10);
            textX.setEnabled(false);
            textX.setDisabledTextColor(Color.BLACK);
            JTextField textY = new JTextField(10);
            textY.setEnabled(false);
            textY.setDisabledTextColor(Color.BLACK);
            this.add(textX);
            this.add(textY);

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textX.setText(Integer.toString(e.getX()));
                    textY.setText(Integer.toString(e.getY()));
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

            setSize(500, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
