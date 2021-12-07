package CodingTestMemory.StudyJava.GUI.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ex1_Menu {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("메뉴 만들기");
            this.setLayout(new FlowLayout());

            JLabel label = new JLabel("이 글자가 바뀝니다");
            label.setToolTipText("툴팁도 나옵디다");
            this.add(label);

            Container c = this.getContentPane();
            c.setBackground(Color.CYAN);

            JMenuBar menuBar = new JMenuBar();

            JMenu fileMenu = new JMenu("파일");
            JMenu editMenu = new JMenu("편집");

            JMenuItem newItem = new JMenuItem("새 문서");
            JMenuItem openItem = new JMenuItem("열기");
            JMenuItem closeItem = new JMenuItem("닫기");

            setJMenuBar(menuBar);

            menuBar.add(fileMenu);
            menuBar.add(editMenu);

            fileMenu.add(newItem);
            fileMenu.add(openItem);
            fileMenu.addSeparator();
            fileMenu.add(closeItem);

            newItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("[새 문서]를 선택했습니다.");
                }
            });

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("[열기]를 선택했습니다.");
                }
            });

            closeItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            setSize(300, 300);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
