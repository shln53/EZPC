package view;

import javax.swing.*;
import java.awt.*;

public class PartsManagementView extends JFrame {
    private JButton cpuButton;
    private JButton cpuCoolerButton;
    private JButton gpuButton;
    private JButton memoryButton;
    private JButton motherboardButton;
    private JButton powerSupplyButton;
    private JButton storageButton;
    private JButton backButton;

    public PartsManagementView() {
        setTitle("Parts Management");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new GridLayout(8, 1));

        cpuButton = new JButton("CPU");
        cpuCoolerButton = new JButton("CPU Cooler");
        gpuButton = new JButton("GPU");
        memoryButton = new JButton("Memory");
        motherboardButton = new JButton("Motherboard");
        powerSupplyButton = new JButton("Power Supply");
        storageButton = new JButton("Storage");
        backButton = new JButton("뒤로");

        // 버튼을 화면에 추가
        add(cpuButton);
        add(cpuCoolerButton);
        add(motherboardButton);
        add(memoryButton);
        add(storageButton);
        add(gpuButton);
        add(powerSupplyButton);
        add(backButton);

        setVisible(true);
    }

    // 각 부품 버튼 리스너를 설정할 수 있도록 getter 제공
    public JButton getCpuButton() {
        return cpuButton;
    }

    public JButton getCpuCoolerButton() {
        return cpuCoolerButton;
    }

    public JButton getGpuButton() {
        return gpuButton;
    }

    public JButton getMemoryButton() {
        return memoryButton;
    }

    public JButton getMotherboardButton() {
        return motherboardButton;
    }

    public JButton getPowerSupplyButton() {
        return powerSupplyButton;
    }

    public JButton getStorageButton() {
        return storageButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}


