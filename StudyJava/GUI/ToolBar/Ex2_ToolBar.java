package CodingTestMemory.StudyJava.GUI.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ex2_ToolBar {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("툴바 만들기");
            this.setLayout(new FlowLayout());

            JToolBar toolBar = new JToolBar();

            JButton newItem = new JButton("새 문서");
            JButton openItem = new JButton("열기");
            JButton closeItem = new JButton(new ImageIcon("image/exit.png"));

            Container c = getContentPane();
            c.setBackground(Color.MAGENTA);

            add(toolBar, BorderLayout.NORTH);
            toolBar.add(newItem);
            toolBar.add(openItem);
            toolBar.addSeparator(new Dimension(20, 10));
            toolBar.add(closeItem);

            JLabel label = new JLabel("이 글자가 바뀝니다");
            this.add(label);

            newItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("[새 문서]를 선택하였습니다");
                }
            });
            newItem.setToolTipText("새 문서");

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("[열기]를 선택하였습니다");
                }
            });
            openItem.setToolTipText("열기");

            closeItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            closeItem.setToolTipText("닫기");
            
            setSize(300, 200);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
