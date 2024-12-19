import controller.MainMenuController;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        new MainMenuController(mainMenu);
        mainMenu.setVisible(true);
    }
}