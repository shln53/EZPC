package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Management extends JFrame {
    public Management () {

        //통합 폰트
        String font = "맑은 고딕";
        // JFrame 설정
        setTitle("Management");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // 버튼 생성
        JButton partsManagementButton = new JButton("부품 관리");
        JButton gameSpecManagementButton = new JButton("게임 사양 관리");
        JButton backButton = new JButton("뒤로");

        // 폰트 설정
        partsManagementButton.setFont(new Font(font, Font.BOLD, 30));
        gameSpecManagementButton.setFont(new Font(font, Font.BOLD, 30));
        backButton.setFont(new Font(font, Font.BOLD, 30));

        // 버튼 중앙 정렬
        partsManagementButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameSpecManagementButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 버튼과 여백 추가
        panel.add(Box.createVerticalStrut(220)); // 위쪽 여백
        panel.add(partsManagementButton);
        panel.add(Box.createVerticalStrut(20)); // 버튼 간 간격
        panel.add(gameSpecManagementButton);
        panel.add(Box.createVerticalStrut(20)); // 버튼 간 간격
        panel.add(backButton);
        panel.add(Box.createVerticalStrut(50)); // 아래쪽 여백

        // 버튼 이벤트 리스너 추가
        partsManagementButton.addActionListener((ActionEvent e) -> {
            new PartsManagement();
            dispose();
        });

        gameSpecManagementButton.addActionListener((ActionEvent e) -> {
            new GameSpecManagement();
            dispose();
        });

        backButton.addActionListener((ActionEvent e) -> {
            new MainMenu();
            dispose();
        });

        // 패널 추가
        add(panel);

        // JFrame 표시
        setVisible(true);
    }
}
