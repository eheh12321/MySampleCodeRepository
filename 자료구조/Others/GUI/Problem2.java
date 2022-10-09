package CodingTestMemory.자료구조.Others.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Problem2 {

    static JButton[] numBtn = new JButton[10];
    static JButton[] funcBtn = new JButton[6];
    static JLabel label_ans;
    static int num1, num2, ans;
    static String op;

    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Calculator");
            setLayout(new BorderLayout());
            setFocusable(true);

            /*
             * 계산기 계산결과 라벨
             */
            label_ans = new JLabel("0");
            label_ans.setFont(new Font("맑은고딕", Font.BOLD, 30));
            label_ans.setHorizontalAlignment(SwingConstants.RIGHT);
            this.add(label_ans, BorderLayout.NORTH);

            /*
             * 계산기 버튼 레이아웃 패널
             */
            JPanel p = new JPanel(new GridLayout(4, 4, 3, 3));
            this.add(p, BorderLayout.CENTER);

            /*
              숫자 버튼 구현
             */
            for(int i = 0; i <= 9; i++) {
                numBtn[i] = new JButton(Integer.toString(i));
                numBtn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ans = label_ans.getText();
                        try {
                            int tmp = Integer.parseInt(ans);
                            if(tmp == 0) {
                                ans = "";
                            }
                        } catch (NumberFormatException ne) {
                            ans = "";
                        }
                        ans += e.getActionCommand();
                        label_ans.setText(ans);
                    }
                });
            }

            /*
             * 연산자 버튼 구현
             */
            String[] funcStr = new String[] {"+", "-", "*", "AC", "=", "/"};

            for(int i = 0; i < 6; i++) {
                funcBtn[i] = new JButton(funcStr[i]);
                funcBtn[i].setBackground(Color.GRAY);
                funcBtn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String func = e.getActionCommand();
                        int tmp;
                        switch (func) {
                            case "=":
                                try {
                                    num2 = Integer.parseInt(label_ans.getText());
                                    switch (op) {
                                        case "+":
                                            ans = num1 + num2;
                                            break;
                                        case "-":
                                            ans = num1 - num2;
                                            break;
                                        case "*":
                                            ans = num1 * num2;
                                            break;
                                        case "/":
                                            ans = num1 / num2;
                                            break;
                                    }
                                    label_ans.setText(Integer.toString(ans));
                                }
                                catch (NullPointerException ne) { }
                                catch (NumberFormatException ne) { label_ans.setText(Integer.toString(num1)); }
                                catch (ArithmeticException ae) { label_ans.setText("ERROR"); }
                                break;
                            case "AC":
                                init(); break;
                            default:
                                try {
                                    tmp = Integer.parseInt(label_ans.getText());
                                    num1 = tmp;
                                    op = func;
                                    label_ans.setText(op);
                                } catch (NumberFormatException ne) {
                                    label_ans.setText(func);
                                    op = func;
                                }
                                break;
                        }
                        MyGUI.this.requestFocus(true); // 포커스 반환
                    }
                });
            }

            /*
             * 키보드 이벤트 리스너
             */
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("키 입력 발생: " + e.getKeyCode());
                    int key = e.getKeyCode();
                    if(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9) {
                        numBtn[key - 48].doClick();

                    } else if (key == 107) { // Plus
                        funcBtn[0].doClick();
                    } else if (key == 109) { // Minus
                        funcBtn[1].doClick();
                    } else if (key == 106) { // Multiply
                        funcBtn[2].doClick();
                    } else if (key == 27) {// ESC
                        funcBtn[3].doClick();
                    } else if (key == 10) { // Enter
                        funcBtn[4].doClick();
                    } else if (key == 111) { // Divide
                        funcBtn[5].doClick();
                    }
                    validate();
                }
            });

            /*
             * 레이아웃에 버튼 배치
             */
            for(int j = 0, cnt = 7; j < 3; j++) {
                for(int i = 0; i < 3; i++) {
                    p.add(numBtn[cnt + i]);
                }
                cnt -= 3;
                p.add(funcBtn[j]);
            }
            p.add(numBtn[0]);
            for(int i = 3; i < 6; i++) {
                p.add(funcBtn[i]);
            }
            setSize(300, 450);
            setVisible(true);
        }
    }

    private static void init() {
        num1 = num2 = ans = 0;
        op = null;
        label_ans.setText("0");
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
