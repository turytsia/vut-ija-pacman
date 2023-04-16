import gui.Game;
import gui.views.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Game game = new Game();
        game.launch(new MainView(game));
    }
}
