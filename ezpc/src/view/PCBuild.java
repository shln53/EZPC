package view;

import javax.swing.*;
import java.awt.*;

public class PCBuild extends JFrame {
    private JPanel panel;
    private JLabel totalPriceLabel;
    private JLabel totalPowerLabel;

    public PCBuild() {
        setTitle("PC Build");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 생성 (BoxLayout 사용)
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 행 단위로 구성

        // 제목 행 추가
        addHeaderRow();

        // 부품 행 추가
        addComponentRow("CPU", "Intel i9", "Intel", "$500");
        addComponentRow("CPU Cooler", "Noctua NH-D15", "Noctua", "$100");
        addComponentRow("Motherboard", "ASUS ROG STRIX", "ASUS", "$300");
        addComponentRow("Memory", "Corsair Vengeance 16GB", "Corsair", "$120");
        addComponentRow("Storage", "Samsung 970 EVO 1TB", "Samsung", "$150");
        addComponentRow("GPU", "NVIDIA RTX 3080", "NVIDIA", "$800");
        addComponentRow("Power Supply", "Corsair RM850x", "Corsair", "$150");

        // 스크롤 패널 추가
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        // 총액 및 총전력량 표시 패널 추가
        addSummaryPanel();

        // 저장, 불어오기, 뒤로 버튼 패널 추가
    }

    private void addHeaderRow() {
        JPanel headerPanel = new JPanel(new GridLayout(1, 5, 10, 0)); // 수평 간격 추가

        headerPanel.add(new JLabel("Component", SwingConstants.CENTER));
        headerPanel.add(new JLabel("Name", SwingConstants.CENTER));
        headerPanel.add(new JLabel("Manufacturer", SwingConstants.CENTER));
        headerPanel.add(new JLabel("Price", SwingConstants.CENTER));
        headerPanel.add(new JLabel("", SwingConstants.CENTER)); // 빈 열 (버튼 열을 위한 자리)

        headerPanel.setBackground(Color.LIGHT_GRAY); // 제목 행의 배경색
        panel.add(headerPanel);
    }

    private void addComponentRow(String component, String name, String manufacturer, String price) {
        JPanel rowPanel = new JPanel(new GridLayout(1, 5, 10, 0)); // 수평 간격 추가

        rowPanel.add(new JLabel(component, SwingConstants.CENTER));
        rowPanel.add(new JLabel(name, SwingConstants.CENTER));
        rowPanel.add(new JLabel(manufacturer, SwingConstants.CENTER));
        rowPanel.add(new JLabel(price, SwingConstants.CENTER));

        JButton selectButton = new JButton("Select");
        rowPanel.add(selectButton);

        panel.add(rowPanel);
    }

    private void addSummaryPanel() {
        JPanel summaryPanel = new JPanel(new GridBagLayout());
        summaryPanel.setPreferredSize(new Dimension(1280, 100)); // 하단 패널 크기 증가

        // 총액 및 총전력량 라벨 생성
        totalPriceLabel = new JLabel("Total Price: $2120", SwingConstants.CENTER); // 초기값 설정
        totalPowerLabel = new JLabel("Total Power: 750W", SwingConstants.CENTER); // 초기값 설정

        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 18)); // 라벨 글꼴 크기 증가
        totalPowerLabel.setFont(new Font("Arial", Font.BOLD, 18)); // 라벨 글꼴 크기 증가

        // GridBagConstraints 설정
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;

        // 총액 라벨 추가
        gbc.gridx = 0;
        summaryPanel.add(totalPriceLabel, gbc);

        // 경계선 추가
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        gbc.gridx = 1;
        gbc.weightx = 0.0;
        summaryPanel.add(separator, gbc);

        // 총전력량 라벨 추가
        gbc.gridx = 2;
        gbc.weightx = 0.5;
        summaryPanel.add(totalPowerLabel, gbc);

        // 프레임 하단에 추가
        add(summaryPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PCBuild pcBuild = new PCBuild();
            pcBuild.setVisible(true);
        });
    }
}



