package controller;

import view.MainMenuView;
import view.PCBuilderView;
import view.ManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Computer;

public class MainMenuController {
    private MainMenuView view;

    public MainMenuController(MainMenuView view) {
        this.view = view;

        // 버튼 클릭 이벤트 리스너 추가
        view.getPcBuildButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 컴퓨터 구성 화면으로 전환
                PCBuilderView pcBuild = new PCBuilderView();
                Computer computer = new Computer(null, null, null, null, null, null, null);
                new PCBuilderController(pcBuild, computer);
                pcBuild.setVisible(true);
                view.dispose();
            }
        });

        view.getManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 관리 화면으로 전환
                ManagementView managementMenu = new ManagementView();
                new ManagementMenuController(managementMenu);
                managementMenu.setVisible(true);
                view.dispose(); // 현재 창 닫기
            }
        });
    }
}
