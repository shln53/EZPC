package controller;

import view.MainMenu;
import view.PCBuild;
import view.ManagementMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Computer;

public class MainMenuController {
    private MainMenu view;

    public MainMenuController(MainMenu view) {
        this.view = view;

        // 버튼 클릭 이벤트 리스너 추가
        view.getPcBuildButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 컴퓨터 구성 화면으로 전환
                PCBuild pcBuild = new PCBuild();
                Computer computer = new Computer(null, null, null, null, null, null, null);
                new PCBuildController(pcBuild, computer);
                pcBuild.setVisible(true);
                view.dispose();
            }
        });

        view.getManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 관리 화면으로 전환
                ManagementMenu managementMenu = new ManagementMenu();
                new ManagementMenuController(managementMenu);
                managementMenu.setVisible(true);
                view.dispose(); // 현재 창 닫기
            }
        });
    }
}
