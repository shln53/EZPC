package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    public MainMenu() {
        //통합 폰트
        String font = "맑은 고딕";

        // JFrame 설정
        setTitle("메인 메뉴");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 수직 배치

        // 버튼 생성
        JLabel label = new JLabel("EZPC", SwingConstants.CENTER);
        JButton pcBuildButton = new JButton("컴퓨터 구성");
        JButton managementButton = new JButton("관리");

        label.setFont(new Font(font, Font.BOLD, 80));
        pcBuildButton.setFont(new Font(font, Font.BOLD, 30));
        managementButton.setFont(new Font(font, Font.BOLD, 30));

        // 컴포넌트 중앙 정렬 설정
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pcBuildButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        managementButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 컴포넌트와의 간격 추가
        panel.add(Box.createVerticalStrut(150)); // 위쪽 여백
        panel.add(label);
        panel.add(Box.createVerticalStrut(100)); // 라벨과 버튼 사이 간격
        panel.add(pcBuildButton);
        panel.add(Box.createVerticalStrut(20)); // 버튼 간 간격
        panel.add(managementButton);
        panel.add(Box.createVerticalStrut(20)); // 아래쪽 여백

        // 버튼 클릭 이벤트 리스너 추가
        pcBuildButton.addActionListener((ActionEvent e) -> {
            // 컴퓨터 구성 화면으로 전환
            new PCBuild(); // 새 창 열기
            dispose(); // 현재 창 닫기
        });

        managementButton.addActionListener((ActionEvent e) -> {
            // 컴퓨터 구성 화면으로 전환
            new Management(); // 새 창 열기
            dispose(); // 현재 창 닫기
        });

        // 패널을 프레임에 추가
        add(panel);

        // JFrame 표시
        setVisible(true);
    }
}
