package controller;

import view.MainMenu;
import view.PCBuild;
import model.Computer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                //cpu리스트
            }
        });
        view.getCpuCoolerSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cpu쿨러 리스트
            }
        });
        view.getMotherBoardSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //마더보드 리스트
            }
        });
        view.getMemorySelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //메모리 리스트
            }
        });
        view.getStorageSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //저장소 리스트
            }
        });
        view.getGpuSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //그래픽카드 리스트
            }
        });
        view.getPowerSupplySelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //파워서플라이 리스트
            }
        });
        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //컴퓨터 저장
                System.out.println("saved");
            }
        });
        view.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //컴퓨터 로드
                System.out.println("loaded");
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
    private void updateComponentLabels() {
        // 총액과 총전력량 초기화
        double totalPrice = 0.0;
        int totalPower = 0;

        // CPU 정보 업데이트
        if (computer.getCPU() != null) {
            view.setCpuName(computer.getCPU().getName());
            view.setCpuManufacturer(computer.getCPU().getManufacturer());
            view.setCpuPrice(computer.getCPU().getPrice());
            totalPrice += computer.getCPU().getPrice();
            //otalPower += computer.getCPU().getPower();
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
            //totalPower += computer.getCPUCooler().getPower();
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
            //totalPower += computer.getMotherboard().getPower();
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
            //totalPower += computer.getMemory().getPower();
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
            //totalPower += computer.getStorage().getPower();
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
            //totalPower += computer.getGPU().getPower();
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
            //totalPower += computer.getPowerSupply().getPower();
        } else {
            view.setPowerSupplyName("");
            view.setPowerSupplyManufacturer("");
            view.setPowerSupplyPrice(0.0); // 빈 가격 처리
        }

        // 총액과 총전력량 업데이트
        view.setTotalPriceLabel(totalPrice);
        view.setTotalPowerLabel("Total Power: " + totalPower + "W");
    }
}
