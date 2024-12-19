package view;

import javax.swing.*;
import java.awt.*;

public class PCBuild extends JFrame {
    private JPanel panel;
    private JLabel totalPriceLabel;
    private JLabel totalPowerLabel;
    private JLabel cpuName;
    private JLabel cpuManufacturer;
    private JLabel cpuPrice;
    private JLabel cpuCoolerName;
    private JLabel cpuCoolerManufacturer;
    private JLabel cpuCoolerPrice;
    private JLabel motherBoardName;
    private JLabel motherBoardManufacturer;
    private JLabel motherBoardPrice;
    private JLabel memoryName;
    private JLabel memoryManufacturer;
    private JLabel memoryPrice;
    private JLabel storageName;
    private JLabel storageManufacturer;
    private JLabel storagePrice;
    private JLabel gpuName;
    private JLabel gpuManufacturer;
    private JLabel gpuPrice;
    private JLabel powerSupplyName;
    private JLabel powerSupplyManufacturer;
    private JLabel powerSupplyPrice;
    private JButton cpuSelectButton;
    private JButton cpuCoolerSelectButton;
    private JButton motherBoardSelectButton;
    private JButton memorySelectButton;
    private JButton storageSelectButton;
    private JButton gpuSelectButton;
    private JButton powerSupplySelectButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton backButton;


    public PCBuild() {
        // 통합 폰트
        String font = "맑은 고딕";

        setTitle("PC Build");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 생성 (BoxLayout 사용)
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 행 단위로 구성

        // 메인 패널을 중앙에 배치
        add(panel, BorderLayout.CENTER);

        // 라벨 초기화
        initializeLabels();

        // 버튼 객체 초기화
        initializeButtons();

        // 제목 행 추가
        addHeaderRow();

        // 부품 행 추가
        addComponentRow("CPU",cpuName, cpuManufacturer, cpuPrice, cpuSelectButton);
        addComponentRow("CPU Cooler",cpuCoolerName, cpuCoolerManufacturer, cpuCoolerPrice, cpuCoolerSelectButton);
        addComponentRow("MotherBoard",motherBoardName, motherBoardManufacturer, motherBoardPrice, motherBoardSelectButton);
        addComponentRow("Memory",memoryName, memoryManufacturer, memoryPrice, memorySelectButton);
        addComponentRow("Storage",storageName, storageManufacturer, storagePrice, storageSelectButton);
        addComponentRow("GPU",gpuName, gpuManufacturer, gpuPrice, gpuSelectButton);
        addComponentRow("Power Supply",powerSupplyName, powerSupplyManufacturer, powerSupplyPrice, powerSupplySelectButton);

        // 총액 및 총전력량 표시 패널 추가
        addSummaryPanel();

        // 저장, 불러오기, 뒤로 버튼 패널 추가
        addButtonPanel();

        // 폰트 설정: "맑은 고딕"
        setCustomFont();
    }

    private void initializeLabels() {
        // 부품에 대한 라벨 초기화
        cpuName = new JLabel("", SwingConstants.CENTER);
        cpuManufacturer = new JLabel("", SwingConstants.CENTER);
        cpuPrice = new JLabel("", SwingConstants.CENTER);

        cpuCoolerName = new JLabel("", SwingConstants.CENTER);
        cpuCoolerManufacturer = new JLabel("", SwingConstants.CENTER);
        cpuCoolerPrice = new JLabel("", SwingConstants.CENTER);

        motherBoardName = new JLabel("", SwingConstants.CENTER);
        motherBoardManufacturer = new JLabel("", SwingConstants.CENTER);
        motherBoardPrice = new JLabel("", SwingConstants.CENTER);

        memoryName = new JLabel("", SwingConstants.CENTER);
        memoryManufacturer = new JLabel("", SwingConstants.CENTER);
        memoryPrice = new JLabel("", SwingConstants.CENTER);

        storageName = new JLabel("", SwingConstants.CENTER);
        storageManufacturer = new JLabel("", SwingConstants.CENTER);
        storagePrice = new JLabel("", SwingConstants.CENTER);

        gpuName = new JLabel("", SwingConstants.CENTER);
        gpuManufacturer = new JLabel("", SwingConstants.CENTER);
        gpuPrice = new JLabel("", SwingConstants.CENTER);

        powerSupplyName = new JLabel("", SwingConstants.CENTER);
        powerSupplyManufacturer = new JLabel("", SwingConstants.CENTER);
        powerSupplyPrice = new JLabel("", SwingConstants.CENTER);
    }
    private void initializeButtons() {
        // 버튼 초기화
        cpuSelectButton = new JButton("Select");
        cpuCoolerSelectButton = new JButton("Select");
        motherBoardSelectButton = new JButton("Select");
        memorySelectButton = new JButton("Select");
        storageSelectButton = new JButton("Select");
        gpuSelectButton = new JButton("Select");
        powerSupplySelectButton = new JButton("Select");

        saveButton = new JButton("저장");
        loadButton = new JButton("불러오기");
        backButton = new JButton("뒤로");
    }
    private void setCustomFont() {
        Font font = new Font("Malgun Gothic", Font.BOLD, 14);

        // 모든 라벨에 폰트 설정
        cpuName.setFont(font);
        cpuManufacturer.setFont(font);
        cpuPrice.setFont(font);
        cpuCoolerName.setFont(font);
        cpuCoolerManufacturer.setFont(font);
        cpuCoolerPrice.setFont(font);
        motherBoardName.setFont(font);
        motherBoardManufacturer.setFont(font);
        motherBoardPrice.setFont(font);
        memoryName.setFont(font);
        memoryManufacturer.setFont(font);
        memoryPrice.setFont(font);
        storageName.setFont(font);
        storageManufacturer.setFont(font);
        storagePrice.setFont(font);
        gpuName.setFont(font);
        gpuManufacturer.setFont(font);
        gpuPrice.setFont(font);
        powerSupplyName.setFont(font);
        powerSupplyManufacturer.setFont(font);
        powerSupplyPrice.setFont(font);

        // 모든 버튼에 폰트 설정
        cpuSelectButton.setFont(font);
        cpuCoolerSelectButton.setFont(font);
        motherBoardSelectButton.setFont(font);
        memorySelectButton.setFont(font);
        storageSelectButton.setFont(font);
        gpuSelectButton.setFont(font);
        powerSupplySelectButton.setFont(font);
        saveButton.setFont(font);
        loadButton.setFont(font);
        backButton.setFont(font);
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

    private void addComponentRow(String component, JLabel nameLabel, JLabel manufacturerLabel, JLabel priceLabel, JButton button) {
        JPanel rowPanel = new JPanel(new GridLayout(1, 5, 10, 0)); // 수평 간격 추가

        rowPanel.add(new JLabel(component, SwingConstants.CENTER));
        rowPanel.add(nameLabel);
        rowPanel.add(manufacturerLabel);
        rowPanel.add(priceLabel);

        button = new JButton("Select");
        rowPanel.add(button);

        panel.add(rowPanel);
    }

    private void addSummaryPanel() {
        JPanel summaryPanel = new JPanel(new GridLayout(1, 2, 10, 0)); // 1행 2열로 구성

        // 총액 및 총전력량 라벨 생성
        totalPriceLabel = new JLabel("Total Price: 0", SwingConstants.CENTER);
        totalPowerLabel = new JLabel("Total Power: 0", SwingConstants.CENTER);

        totalPriceLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
        totalPowerLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));

        // 라벨 추가
        summaryPanel.add(totalPriceLabel);
        summaryPanel.add(totalPowerLabel);

        // 프레임 하단에 추가
        panel.add(summaryPanel);
    }

    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0)); // 1행 3열로 구성

        // 버튼 생성
        saveButton = new JButton("저장");
        loadButton = new JButton("불러오기");
        backButton = new JButton("뒤로");

        // 버튼 추가
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(backButton);

        // 프레임 하단에 버튼 패널 추가
        panel.add(buttonPanel);
    }
    public JButton getCpuSelectButton() {
        return cpuSelectButton;
    }
    public JButton getCpuCoolerSelectButton() {
        return cpuCoolerSelectButton;
    }
    public JButton getMotherBoardSelectButton() {
        return motherBoardSelectButton;
    }
    public JButton getMemorySelectButton() {
        return memorySelectButton;
    }
    public JButton getStorageSelectButton() {
        return storageSelectButton;
    }
    public JButton getGpuSelectButton() {
        return gpuSelectButton;
    }
    public JButton getPowerSupplySelectButton() {
        return powerSupplySelectButton;
    }
    public JButton getSaveButton() {
        return saveButton;
    }
    public JButton getLoadButton() {
        return loadButton;
    }
    public JButton getBackButton() {
        return backButton;
    }

    //라벨 setter
    public void setTotalPriceLabel(double price) {
        totalPriceLabel.setText("Total Price: ₩" + String.format("%.2f", price));
    }

    public void setTotalPowerLabel(String text) {
        totalPowerLabel.setText(text);
    }

    public void setCpuName(String name) {
        cpuName.setText(name);
    }

    public void setCpuManufacturer(String manufacturer) {
        cpuManufacturer.setText(manufacturer);
    }

    public void setCpuPrice(double price) {
        cpuPrice.setText("₩" + String.format("%.2f", price));
    }

    public void setCpuCoolerName(String name) {
        cpuCoolerName.setText(name);
    }

    public void setCpuCoolerManufacturer(String manufacturer) {
        cpuCoolerManufacturer.setText(manufacturer);
    }

    public void setCpuCoolerPrice(double price) {
        cpuCoolerPrice.setText("₩" + String.format("%.2f", price));
    }

    public void setMotherBoardName(String name) {
        motherBoardName.setText(name);
    }

    public void setMotherBoardManufacturer(String manufacturer) {
        motherBoardManufacturer.setText(manufacturer);
    }

    public void setMotherBoardPrice(double price) {
        motherBoardPrice.setText("₩" + String.format("%.2f", price));
    }

    public void setMemoryName(String name) {
        memoryName.setText(name);
    }

    public void setMemoryManufacturer(String manufacturer) {
        memoryManufacturer.setText(manufacturer);
    }

    public void setMemoryPrice(double price) {
        memoryPrice.setText("₩" + String.format("%.2f", price));
    }

    public void setStorageName(String name) {
        storageName.setText(name);
    }

    public void setStorageManufacturer(String manufacturer) {
        storageManufacturer.setText(manufacturer);
    }

    public void setStoragePrice(double price) {
        storagePrice.setText("₩" + String.format("%.2f", price));
    }

    public void setGpuName(String name) {
        gpuName.setText(name);
    }

    public void setGpuManufacturer(String manufacturer) {
        gpuManufacturer.setText(manufacturer);
    }

    public void setGpuPrice(double price) {
        gpuPrice.setText("₩" + String.format("%.2f", price));
    }

    public void setPowerSupplyName(String name) {
        powerSupplyName.setText(name);
    }

    public void setPowerSupplyManufacturer(String manufacturer) {
        powerSupplyManufacturer.setText(manufacturer);
    }

    public void setPowerSupplyPrice(double price) {
        powerSupplyPrice.setText("₩" + String.format("%.2f", price));
    }
}




