import ui.MainMenu;
public class Main {
    public static void main(String[] args) {
        // 시작 화면 호출
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainMenu();
        });
    }
}