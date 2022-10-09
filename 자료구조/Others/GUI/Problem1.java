package CodingTestMemory.자료구조.Others.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

class Problem1 {

    static String[] imgName = {"eclair", "froyo", "gingerbread", "honeycomb", "icecream",
            "jellybean", "kitkat", "lollipop", "marshmallow"};
    static JButton[] imgBtn = new JButton[9];

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Android 이미지");
            this.setLayout(new GridLayout(3, 3, 10, 10));

            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu menu = new JMenu("내 메뉴");
            menuBar.add(menu);

            JMenuItem shuffleItem = new JMenuItem("이미지 섞기");
            JMenuItem closeItem = new JMenuItem("닫기");
            menu.add(shuffleItem);
            menu.add(closeItem);

            shuffleItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_0);

                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            });

            closeItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    getContentPane().removeAll();
                    int[] randNum = makeRandomNo();
                    for(int i = 0; i < 9; i++) {
                        imgBtn[i] = new JButton(new ImageIcon("image/android/" + imgName[randNum[i]] + ".jpg"));
                        MyGUI.this.add(imgBtn[i]);
                    }
                    validate();
                }
            });

            setSize(280, 280);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }

    static int[] makeRandomNo() {
        int val;
        int[] nums = new int[9];

        for(int i = 0; i < 9; i++) {
            val = (int)(Math.random() * 9);
            nums[i] = val;
            for(int j = 0; j < i; j++) {
                if(nums[j] == val) {
                    i -= 1;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
