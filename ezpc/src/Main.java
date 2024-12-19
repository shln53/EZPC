import controller.MainMenuController;
import view.MainMenuView;

public class Main {
    public static void main(String[] args) {
        // 시작 화면 호출
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainMenuView mainMenu = new MainMenuView();
            new MainMenuController(mainMenu);
            mainMenu.setVisible(true);
        });
    }
}