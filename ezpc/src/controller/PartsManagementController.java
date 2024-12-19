package controller;
import view.ManagementView;
import view.PartsManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartsManagementController {
    private PartsManagementView view;

    public PartsManagementController(PartsManagementView view) {
        this.view = view;

        // 부품 선택 버튼 이벤트 처리
        view.getCpuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // 다른 부품에 대해서도 동일한 방식으로 처리
        view.getCpuCoolerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getGpuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getMemoryButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getMotherboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getPowerSupplyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getStorageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagementView managementMenu = new ManagementView();
                new ManagementMenuController(managementMenu);
                managementMenu.setVisible(true);
                view.dispose(); // 현재 창 닫기
            }
        });
    }
}
