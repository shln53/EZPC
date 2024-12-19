package controller;

import view.ManagementView;
import view.PartsManagementView;
import view.GameSpecManagementView;
import view.MainMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementMenuController {
    private ManagementView view;

    public ManagementMenuController(ManagementView view) {
        this.view = view;

        // 버튼 이벤트 리스너 추가
        view.getPartsManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PartsManagementView partsManagement = new PartsManagementView();
                new PartsManagementController(partsManagement);
                view.dispose(); // 현재 창 닫기
            }
        });

        view.getGameSpecManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 사양 관리 화면으로 전환
                new GameSpecManagementView(); // 새 창 열기
                view.dispose(); // 현재 창 닫기
            }
        });

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 메인 메뉴로 돌아가기
                MainMenuView mainMenu = new MainMenuView();
                new MainMenuController(mainMenu);
                mainMenu.setVisible(true);
                view.dispose(); // 현재 창 닫기
            }
        });
    }
}
