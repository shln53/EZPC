package view;

import controller.PCBuilderController;
import model.Computer;
import model.CPU;
import model.CPUCooler;
import model.GPU;
import model.Memory;
import model.Motherboard;
import model.PowerSupply;
import model.Storage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentListView extends JFrame {
    private JList<String> componentList;
    private DefaultListModel<String> listModel;
    private List<Object> componentObjects;
    private Computer computer;
    private String componentType;
    private PCBuilderController controller;

    public ComponentListView(Computer computer, PCBuilderController controller , String componentType, String directory) {
        this.computer = computer;
        this.componentType = componentType;
        this.controller = controller;

        setTitle("Component List");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // 화면 중앙에 위치

        componentObjects = new ArrayList<>();  // 부품 객체들을 저장할 리스트 초기화

        // DefaultListModel을 사용하여 JList에 데이터를 추가
        listModel = new DefaultListModel<>();
        componentList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(componentList);
        add(scrollPane, BorderLayout.CENTER);

        // 부품 항목들을 파일에서 불러와 리스트에 표시
        loadComponentsFromFile(directory);

        // JList에서 선택된 항목에 대한 이벤트 리스너 추가
        componentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {  // 사용자 선택이 끝난 후에 이벤트 처리
                int selectedIndex = componentList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Object selectedComponent = componentObjects.get(selectedIndex);
                    System.out.println("Component Selected: " + selectedComponent.getClass().getSimpleName());
                    // 선택된 부품 객체에 맞는 컴퓨터 부품 설정
                    setSelectedComponent(selectedComponent);
                }
            }
        });

        setVisible(true);
    }

    private void loadComponentsFromFile(String directory) {
        File dir = new File(directory);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory or directory does not exist.");
            return;
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".dat"));
        if (files != null) {
            for (File file : files) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                    Object component = in.readObject();
                    componentObjects.add(component);

                    String componentDetails = getComponentDetails(component);
                    listModel.addElement(componentDetails);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Error loading component from file: " + file.getName());
                }
            }
        }
    }

    private String getComponentDetails(Object component) {
        if (component instanceof CPU) {
            CPU cpu = (CPU) component;
            return String.format("CPU: %s - %s - ₩%.2f - %d Cores - %.2f GHz - Socket: %s - TDP: %.2fW",
                    cpu.getName(), cpu.getManufacturer(), cpu.getPrice(), cpu.getCores(),
                    cpu.getClockSpeed(), cpu.getSocketType(), cpu.getTdp());
        } else if (component instanceof CPUCooler) {
            CPUCooler cooler = (CPUCooler) component;
            return String.format("CPU Cooler: %s - %s - ₩%.2f - Socket Type: %s - TDP: %.2fW - Cooling Capacity: %.2f",
                    cooler.getName(), cooler.getManufacturer(), cooler.getPrice(),
                    cooler.getSocketType(), cooler.getTdp(), cooler.getCoolingCapacity());
        } else if (component instanceof GPU) {
            GPU gpu = (GPU) component;
            return String.format("GPU: %s - %s - ₩%.2f - Memory: %d GB - Chipset: %s - PCIe: %s - TDP: %.2fW",
                    gpu.getName(), gpu.getManufacturer(), gpu.getPrice(), gpu.getMemorySize(),
                    gpu.getChipset(), gpu.getPcieVersion(), gpu.getTdp());
        } else if (component instanceof Memory) {
            Memory memory = (Memory) component;
            return String.format("Memory: %s - %s - ₩%.2f - Type: %s - Capacity: %d GB - Speed: %.2f MHz - XMP Supported: %b",
                    memory.getName(), memory.getManufacturer(), memory.getPrice(), memory.getType(),
                    memory.getCapacity(), memory.getClockSpeed(), memory.isXmpSupport());
        } else if (component instanceof Motherboard) {
            Motherboard motherboard = (Motherboard) component;
            return String.format("Motherboard: %s - %s - ₩%.2f - Chipset: %s - Form Factor: %s - PCIe: %s - Max GPU Length: %dmm",
                    motherboard.getName(), motherboard.getManufacturer(), motherboard.getPrice(), motherboard.getChipset(),
                    motherboard.getFormFactor(), motherboard.getPcieVersion(), motherboard.getMaxGpuLength());
        } else if (component instanceof PowerSupply) {
            PowerSupply powerSupply = (PowerSupply) component;
            return String.format("Power Supply: %s - %s - ₩%.2f - Wattage: %dW",
                    powerSupply.getName(), powerSupply.getManufacturer(), powerSupply.getPrice(), powerSupply.getWattage());
        } else if (component instanceof Storage) {
            Storage storage = (Storage) component;
            return String.format("Storage: %s - %s - ₩%.2f - Capacity: %d GB - Type: %s - Interface: %s",
                    storage.getName(), storage.getManufacturer(), storage.getPrice(), storage.getCapacity(),
                    storage.getType(), storage.getInterfaceType());
        }
        return "";
    }

    private void setSelectedComponent(Object selectedComponent) {
        // 선택된 부품 객체를 컴퓨터 객체에 설정
        if (componentType.equals("CPU") && selectedComponent instanceof CPU) {
            computer.setCPU((CPU) selectedComponent);
        } else if (componentType.equals("CPUCooler") && selectedComponent instanceof CPUCooler) {
            computer.setCPUCooler((CPUCooler) selectedComponent);
        } else if (componentType.equals("Motherboard") && selectedComponent instanceof Motherboard) {
            computer.setMotherboard((Motherboard) selectedComponent);
        } else if (componentType.equals("Memory") && selectedComponent instanceof Memory) {
            computer.setMemory((Memory) selectedComponent);
        } else if (componentType.equals("Storage") && selectedComponent instanceof Storage) {
            computer.setStorage((Storage) selectedComponent);
        } else if (componentType.equals("GPU") && selectedComponent instanceof GPU) {
            computer.setGPU((GPU) selectedComponent);
        } else if (componentType.equals("PowerSupply") && selectedComponent instanceof PowerSupply) {
            computer.setPowerSupply((PowerSupply) selectedComponent);
        }
        controller.updateComponentLabels();  // PCBuild 화면 업데이트
        dispose();  // ComponentList 창 닫기
    }
}











