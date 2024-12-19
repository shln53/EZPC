import javax.swing.*;
import java.awt.*;

public class PCBuild extends JFrame {
    private Computer computer;

    public PCBuild() {
        // 초기화된 Computer 객체 (부품들은 null로 시작)
        computer = new Computer(null, null, null, null, null, null, null);

        setTitle("PC Build");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //패널 생성
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(8, 2));

        add(Panel);

        setVisible(true);
    }
}
