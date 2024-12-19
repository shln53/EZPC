package controller;

import view.ComponentList;
import view.MainMenu;
import view.PCBuild;
import model.Computer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class PCBuildController {
    private PCBuild view;
    private Computer computer;

    public PCBuildController(PCBuild view, Computer computer) {
        this.view = view;
        this.computer = computer;

        // 부품 속성 가져와서 라벨 업데이트
        updateComponentLabels();

        view.getCpuSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"CPU","ComPonentData/CPU");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getCpuCoolerSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cpu쿨러 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"CPUCooler","ComPonentData/CPU Cooler");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getMotherBoardSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //마더보드 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"Motherboard","ComPonentData/MotherBoard");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getMemorySelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //메모리 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"Memory","ComPonentData/Memory");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getStorageSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //저장소 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"Storage","ComPonentData/Storage");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getGpuSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //그래픽카드 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"GPU","ComPonentData/GPU");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getPowerSupplySelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //파워서플라이 리스트
                ComponentList componentList = new ComponentList(computer, PCBuildController.this,"PowerSupply","ComPonentData/Power Supply");
                componentList.setVisible(true);  // ComponentList 창을 보이게 설정
            }
        });
        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //컴퓨터 저장
                // 컴퓨터 객체를 저장할 파일 이름을 사용자로부터 입력받기
                String fileName = JOptionPane.showInputDialog(view, "Enter the file name to save the computer:", "Save Computer", JOptionPane.QUESTION_MESSAGE);

                if (fileName != null && !fileName.trim().isEmpty()) {
                    String directoryPath = "saves/";
                    File directory = new File(directoryPath);
                    if (!directory.exists()) {
                        directory.mkdirs();  // 폴더가 없다면 생성
                    }
                    String filePath = directoryPath + fileName + "_computer.dat";  // 파일 경로 생성
                    saveComputerToFile(filePath);  // 컴퓨터 객체 저장
                    System.out.println("Computer saved as " + filePath);
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid file name. Please try again.");
                }
            }
        });
        view.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //컴퓨터 로드
                loadComputers();
            }
        });
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 메인 메뉴로 돌아가기
                MainMenu mainMenu = new MainMenu();
                new MainMenuController(mainMenu);
                mainMenu.setVisible(true);
                view.dispose(); // 현재 창 닫기
            }
        });

    }
    // 컴퓨터 부품들의 속성을 가져와서 라벨에 업데이트
    public void updateComponentLabels() {
        // 총액과 총전력량 초기화
        double totalPrice = 0.0;
        int totalPower = 0;

        // CPU 정보 업데이트
        if (computer.getCPU() != null) {
            view.setCpuName(computer.getCPU().getName());
            view.setCpuManufacturer(computer.getCPU().getManufacturer());
            view.setCpuPrice(computer.getCPU().getPrice());
            totalPrice += computer.getCPU().getPrice();
            totalPower += computer.getCPU().getTdp();
        } else {
            view.setCpuName("");
            view.setCpuManufacturer("");
            view.setCpuPrice(0.0); // 빈 가격 처리
        }

        // CPU Cooler 정보 업데이트
        if (computer.getCPUCooler() != null) {
            view.setCpuCoolerName(computer.getCPUCooler().getName());
            view.setCpuCoolerManufacturer(computer.getCPUCooler().getManufacturer());
            view.setCpuCoolerPrice(computer.getCPUCooler().getPrice());
            totalPrice += computer.getCPUCooler().getPrice();
            totalPower += computer.getCPUCooler().getTdp();
        } else {
            view.setCpuCoolerName("");
            view.setCpuCoolerManufacturer("");
            view.setCpuCoolerPrice(0.0); // 빈 가격 처리
        }

        // Motherboard 정보 업데이트
        if (computer.getMotherboard() != null) {
            view.setMotherBoardName(computer.getMotherboard().getName());
            view.setMotherBoardManufacturer(computer.getMotherboard().getManufacturer());
            view.setMotherBoardPrice(computer.getMotherboard().getPrice());
            totalPrice += computer.getMotherboard().getPrice();
        } else {
            view.setMotherBoardName("");
            view.setMotherBoardManufacturer("");
            view.setMotherBoardPrice(0.0); // 빈 가격 처리
        }

        // Memory 정보 업데이트
        if (computer.getMemory() != null) {
            view.setMemoryName(computer.getMemory().getName());
            view.setMemoryManufacturer(computer.getMemory().getManufacturer());
            view.setMemoryPrice(computer.getMemory().getPrice());
            totalPrice += computer.getMemory().getPrice();
        } else {
            view.setMemoryName("");
            view.setMemoryManufacturer("");
            view.setMemoryPrice(0.0); // 빈 가격 처리
        }

        // Storage 정보 업데이트
        if (computer.getStorage() != null) {
            view.setStorageName(computer.getStorage().getName());
            view.setStorageManufacturer(computer.getStorage().getManufacturer());
            view.setStoragePrice(computer.getStorage().getPrice());
            totalPrice += computer.getStorage().getPrice();
        } else {
            view.setStorageName("");
            view.setStorageManufacturer("");
            view.setStoragePrice(0.0); // 빈 가격 처리
        }

        // GPU 정보 업데이트
        if (computer.getGPU() != null) {
            view.setGpuName(computer.getGPU().getName());
            view.setGpuManufacturer(computer.getGPU().getManufacturer());
            view.setGpuPrice(computer.getGPU().getPrice());
            totalPrice += computer.getGPU().getPrice();
            totalPower += computer.getGPU().getTdp();
        } else {
            view.setGpuName("");
            view.setGpuManufacturer("");
            view.setGpuPrice(0.0); // 빈 가격 처리
        }

        // Power Supply 정보 업데이트
        if (computer.getPowerSupply() != null) {
            view.setPowerSupplyName(computer.getPowerSupply().getName());
            view.setPowerSupplyManufacturer(computer.getPowerSupply().getManufacturer());
            view.setPowerSupplyPrice(computer.getPowerSupply().getPrice());
            totalPrice += computer.getPowerSupply().getPrice();
        } else {
            view.setPowerSupplyName("");
            view.setPowerSupplyManufacturer("");
            view.setPowerSupplyPrice(0.0); // 빈 가격 처리
        }

        // 총액과 총전력량 업데이트
        view.setTotalPriceLabel(totalPrice);
        view.setTotalPowerLabel("Total Power: " + totalPower + "W");
    }
    // 컴퓨터 객체를 .dat 파일로 저장하는 메서드
    private void saveComputerToFile(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(computer);  // 컴퓨터 객체를 파일에 저장
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error saving the computer object.");
        }
    }

    // Load 컴퓨터 목록을 불러오는 메서드
    private void loadComputers() {
        // 파일 다이얼로그를 사용하여 컴퓨터 파일 선택
        JFileChooser fileChooser = new JFileChooser("saves/");
        fileChooser.setDialogTitle("Select a Computer File");
        int result = fileChooser.showOpenDialog(view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(selectedFile))) {
                    Computer loadedComputer = (Computer) in.readObject();  // 선택된 파일에서 컴퓨터 객체 로드
                    computer = loadedComputer;  // loadedComputer로 기존 컴퓨터 객체 업데이트
                    System.out.println("Loaded Computer: " + computer.getCPU().getName());
                    updateComponentLabels();  // UI 업데이트
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    System.out.println("Error loading the computer object.");
                }
            }
        }
    }
}
