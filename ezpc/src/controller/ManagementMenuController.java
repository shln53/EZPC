package controller;

import view.ManagementMenu;
import view.PartsManagement;
import view.GameSpecManagement;
import view.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementMenuController {
    private ManagementMenu view;

    public ManagementMenuController(ManagementMenu view) {
        this.view = view;

        // 버튼 이벤트 리스너 추가
        view.getPartsManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 부품 관리 화면으로 전환
                new PartsManagement(); // 새 창 열기
                view.dispose(); // 현재 창 닫기
            }
        });

        view.getGameSpecManagementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 사양 관리 화면으로 전환
                new GameSpecManagement(); // 새 창 열기
                view.dispose(); // 현재 창 닫기
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
}
