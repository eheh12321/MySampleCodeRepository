package CodingTestMemory.자료구조.Others.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

class Problem3 {
    private static class MyGUI extends JFrame {
        MyGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("POS 프로그램");
            setLayout(new BorderLayout());

            JLabel label_name = new JLabel("담당직원: 홍길동");
            JLabel label_time = new JLabel("현재시간: " + new Date());

            JPanel panel1 = new JPanel(new BorderLayout());
            panel1.add(label_name, BorderLayout.LINE_START);
            panel1.add(label_time, BorderLayout.LINE_END);

            JPanel info1 = new JPanel();
            ButtonGroup sales = new ButtonGroup();
            JCheckBox chk_normal = new JCheckBox("정상");
            JCheckBox chk_discount = new JCheckBox("할인");
            sales.add(chk_normal);
            sales.add(chk_discount);
            info1.add(new JLabel("판매유형: "));
            info1.add(chk_normal);
            info1.add(chk_discount);

            JPanel info2 = new JPanel();
            ButtonGroup member = new ButtonGroup();
            JRadioButton radio_member = new JRadioButton("회원");
            JRadioButton radio_nonmember = new JRadioButton("비회원");
            member.add(radio_member);
            member.add(radio_nonmember);
            info2.add(new JLabel("회원구분: "));
            info2.add(radio_member);
            info2.add(radio_nonmember);

            JPanel panel2 = new JPanel(new GridLayout(2, 1, 10, 10));
            panel2.add(info1, BorderLayout.NORTH);
            panel2.add(info2, BorderLayout.CENTER);

            String[] colNames = {"번호","상품 이름","단가","수량","금액"};
            Object[][] data = {
                    {"1","맛있는 고구마칩","2,000","1","2,000"},
                    {"2","브라이트 칫솔","1,500","2","3,000"},
                    {"3","호호 호빵","1,000", "3", "3,000"}
            };

            JTable table = new JTable(data, colNames);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            this.add(panel1, BorderLayout.NORTH);
            this.add(panel2, BorderLayout.LINE_START);
            this.add(scrollPane, BorderLayout.LINE_END);

            setSize(700, 150);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
