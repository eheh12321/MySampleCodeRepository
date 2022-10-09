package CodingTestMemory.자료구조.Others.GUI.Layout;

import javax.swing.*;

class Ex1_SWING {

    private static class MyGUI extends JFrame {
        MyGUI() {
            // 종료 버튼을 누르면 프로그램이 종료되게 설정함
            // 생락 시 윈도우는 사라지나 프로그램이 종료되지 않음
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setTitle("GUI 연습");
            setSize(500, 500);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
