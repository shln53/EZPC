import controller.MainMenuController;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        // 시작 화면 호출
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            new MainMenuController(mainMenu);
            mainMenu.setVisible(true);
        });
    }
}